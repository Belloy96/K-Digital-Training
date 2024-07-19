# -*- coding:utf-8 -*-
from cx_Oracle import connect
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring

# 기상청 (주소값 구해서)
# 기상청 xml => DB에 적재
# 시간대 / 기온 / 최고기온 / 날씨(한글) / 바람의 방향(한글)
# hour / temp / tmx / wfKor / wdKor
# https://www.weather.go.kr/w/rss/dfs/hr1-forecast.do?zone=1168072000

hc = HTTPSConnection("www.weather.go.kr")
hc.request("GET", "/w/rss/dfs/hr1-forecast.do?zone=1168072000")
res = hc.getresponse()
resBody = res.read()
# resBody = hc.getresponse().read() -> 축약가능
# print(resBody.decode()) -> 잘 나오는지 확인!

con = connect("belloy/8230@localhost:1521/xe")
cur = con.cursor()

for w in fromstring(resBody).iter("data"):
    # print(w.find("hour").text) -> 잘 나오는지 확인!
    hr = w.find("hour").text
    tp = w.find("temp").text
    tm = w.find("tmx").text
    wf = w.find("wfKor").text
    wd = w.find("wdKor").text
    sql = f"insert into jul19_weather values(jul19_weather_seq.nextval, '{hr}', '{tp}', '{tm}', '{wf}', '{wd}')"
    cur.execute(sql)

    # 강사님 답안(sql)
    # sql = "insert into jul19_weather values(jul19_wather_seq.nextval, "
    # sql += "'%s', "% (w.find("hour").text)
    # sql += "'%s', "% (w.find("temp").text)
    # sql += "'%s', "% (w.find("tmx").text)
    # sql += "'%s', "% (w.find("wfKor").text)
    # sql += "'%s')"% (w.find("wdKor").text)

con.commit()
con.close()
print("END")


