# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from json import loads
from cx_Oracle import connect

# http://openAPI.seoul.go.kr:8088
# /4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/

# 구 이름, 미세먼지, 초미세먼지의 정보를 DB에 담아주세요!
#    (여러 기간에 걸쳐 이 데이터를 모은다고 가정)

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
u = "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/"
hc.request("GET", u)

resBody = hc.getresponse().read()
# print(resBody.decode())
###################### 여기까지 HTTP 통신!

airData = loads(resBody)
# print(airData)

con = connect("belloy/8230@localhost:1521/xe")
cur = con.cursor()

for a in airData["RealtimeCityAir"]["row"]:
    # print(a["MSRSTE_NM"], a["PM10"], a["PM25"]) 잘 나오는지 확인!
    nm = a["MSRSTE_NM"]
    pm10 = a["PM10"]
    pm25 = a["PM25"]
    sql = f"insert into jul19_airs values(jul19_airs_seq.nextval, '{nm}', {pm10}, {pm25})"
    cur.execute(sql)
    
con.commit()    
con.close()
print("성공 !")





