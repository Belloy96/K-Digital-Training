# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from datetime import datetime
from json import loads

# http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/1/5/201501/
# openapi.seoul.go.kr:8088
# /4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/1/5/201901/

# 2019 ~ 2023년 월별로 > 하나의 파일(csv)에 저장
# 연월(ex:201901),호선명,지하철역,유임승차인원,무임승차인원,유임하차인원,무임하차인원

# 1    USE_MM    사용월
# 2    SBWY_ROUT_LN_NM    호선명
# 3    STTN    지하철역
# 4    RMIO_GTON_NOPE    유임승차인원
# 5    FREECHRG_GTON_NOPE    무임승차인원
# 6    RMIO_GTOFF_NOPE    유임하차인원
# 7    FREECHRG_GTOFF_NOPE    무임하차인원

# hc = HTTPConnection("openapi.seoul.go.kr:8088")
#
# with open("C:/Users/tpgns/Desktop/PyData/subwayPayFree.csv", "w", encoding="UTF-8") as f:
    # f.write("사용월,호선명,지하철역,유임승차인원,무임승차인원,유임하차인원,무임하차인원\n")
    # for y in range(2019, 2024):
        # for m in range(1, 13):
            # date_str = f"{y}{m:02d}"
            # datetime.strptime(date_str, "%Y%m")
            #
            # f.write(f"{y}년 {m}월\n")
            #
            # print(f"{y}-{m:02d}")
            #
            # page = 1
            # while True: 
                # u = f"/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/{page}/1000/{date_str}/"
                # hc.request("GET", u)
                # res = hc.getresponse().read()
                # subwayData = loads(res)
                #
                # if "CardSubwayPayFree" not in subwayData:
                    # break
                    #
                # if page == 1:
                    # total_count = subwayData["CardSubwayPayFree"]["list_total_count"]
                    #
                # for s in subwayData["CardSubwayPayFree"]["row"]:
                    # MM = s["USE_MM"]
                    # NM = s["SBWY_ROUT_LN_NM"]
                    # ST = s["STTN"]
                    # RON = int(s["RMIO_GTON_NOPE"])
                    # FON = int(s["FREECHRG_GTON_NOPE"])
                    # ROFF = int(s["RMIO_GTOFF_NOPE"])
                    # FOFF = int(s["FREECHRG_GTOFF_NOPE"])
                    # f.write(f"{MM},{NM},{ST},{RON},{FON},{ROFF},{FOFF}\n")
                    #
                # if page * 1000 >= total_count:
                    # break    
                # page += 1

# 강사님 답안
with open("C:/Users/tpgns/Desktop/PyData/subwayPayFreeAns.csv", "a", encoding="UTF-8") as f:
    hc = HTTPConnection("openapi.seoul.go.kr:8088")
    for y in range(2019, 2024):
        for m in range(1, 13):
            when = "%d%02d" % (y, m)
            for start in range(1, 2000, 1000):  
                hc.request("GET", f"/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/{start}/{start + 999}/{when}/")
                resBody = hc.getresponse().read()
                subwayData = loads(resBody)

                if "CardSubwayPayFree" in subwayData:
                    for b in subwayData["CardSubwayPayFree"]["row"]:
                        f.write(f"{when},")
                        f.write(f"{b['SBWY_ROUT_LN_NM']},")
                        f.write(f"{b['STTN']},")
                        f.write(f"{b['RMIO_GTON_NOPE']},")
                        f.write(f"{b['FREECHRG_GTON_NOPE']},")
                        f.write(f"{b['RMIO_GTOFF_NOPE']},")
                        f.write(f"{b['FREECHRG_GTOFF_NOPE']}\n")
print("종료")



