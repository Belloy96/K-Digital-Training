# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from json import loads
from datetime import datetime

# http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/20210101/
# /4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/5/20151101/

# 2021 ~ 2023년 3년치 데이터를...
# 연,월,일,노선번호,정류장명(역명),승차총승객수,하차총승객수
# 연도별로 csv파일에 저장

# 정류장명(역명) => 혹시 ,가 들어있을수도 있으니
#        => ,를 .로 바꿔서 저장

# 인원수 관련 => 정수형태로 저장

hc = HTTPConnection("openapi.seoul.go.kr:8088")

for y in range(2021, 2024):
    with open(f"busData_{y}.csv", "w", encoding="UTF-8") as f:
        for m in range(1, 13):
            for d in range(1, 32):
                try:
                    date_str = f"{y}{m:02d}{d:02d}"
                    datetime.strptime(date_str, "%Y%m%d")
                except ValueError:
                    continue
                
                print(f"{y}-{m:02d}-{d:02d}")
                
                page = 1
                while True:
                    u = f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/{page}/1000/{date_str}/"
                    hc.request("GET", u)
                    res = hc.getresponse().read()
                    busData = loads(res)

                    if "CardBusStatisticsServiceNew" not in busData:
                        break

                    if page == 1:
                        total_count = busData["CardBusStatisticsServiceNew"]["list_total_count"]

                    for b in busData["CardBusStatisticsServiceNew"]["row"]:
                        ymd = b['USE_YMD']
                        no = b['RTE_NO']
                        nm = b['SBWY_STNS_NM']
                        on = int(b['GTON_TNOPE'])
                        off = int(b['GTOFF_TNOPE'])
                        f.write(f"{ymd[:4]},{ymd[4:6]},{ymd[6:]},{no},{nm.replace(',', '.')},{on},{off}\n")
                    
                    if page * 1000 >= total_count:
                        break
                    page += 1


# for y in range(2021, 2024):
    # with open("C:/Users/tpgns/Desktop/PyData/" + f"busData_{y}.csv", "w", encoding="UTF-8") as f:
        # for m in range(1, 13):
            # for d in range(1, 32):
                # u = f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/1000/{y}{m:02d}{d:02d}/"
                # hc.request("GET", u)
                # res = hc.getresponse().read()
                # busData = loads(res)
                # for b in busData["CardBusStatisticsServiceNew"]["row"]:
                    # ymd = b['USE_YMD']
                    # no = b['RTE_NO']
                    # nm = b['SBWY_STNS_NM']
                    # on = int(b['GTON_TNOPE'])
                    # off = int(b['GTOFF_TNOPE'])
                    # f.write(f"{ymd[:4]},{ymd[4:6]},{ymd[6:]},{no},{nm.replace(',', '.')},{on},{off}\n")
                   

# for y in range(2021, 2024):
    # for m in range(1, 13):
        # for d in range(1, 32):
            # u = f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/1000/{y}{m:02d}{d:02d}/"
            # hc.request("GET", u)
            # res = hc.getresponse().read()
            # busData = loads(res)    
            # for b in busData["CardBusStatisticsServiceNew"]["row"]:
                # print(b["USE_YMD"])
                # print(b["RTE_NO"])
                # print(b["SBWY_STNS_NM"].replace(",", "."))
                # print(int(b["GTON_TNOPE"]))
                # print(int(b["GTOFF_TNOPE"]))
