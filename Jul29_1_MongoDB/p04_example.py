# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient
from http.client import HTTPConnection
from json import loads

# http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/
# 1/5/로 해보니 총 132개가 나옴. 그래서 1/5/에서 1/132/로 수정!

# openAPI.seoul.go.kr:8088
# /4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/

# 전체 공원 데이터 중에
#    공원이름 (PK), 공원 소개, 개원일, 주소
#    => MongoDB에 넣고

# 다 넣었으면 => 출력 (console)

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
u = "/4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/"
hc.request("GET", u)

resBody = hc.getresponse().read()
# print(resBody)

parkData = loads(resBody)

con = MongoClient("192.168.0.77")
db = con.jul29

# P_PARK, P_LIST_CONTENT, OPEN_DT, P_ADDR
# for p in parkData["SearchParkInfoService"]["row"]:
    # db.jul29_park.insert_many([
        # { "_id": p["P_PARK"], "content": p["P_LIST_CONTENT"],
         # "open": p["OPEN_DT"], "addr": p["P_ADDR"] }
        # ])

# 강사님 답안
# for p in parkData["SearchParkInfoService"]["row"]:
    # db.jul29_park.insert_one( { "_id" : p["P_PARK"], "introduce" : p["P_LIST_CONTENT"],
                                # "open_dt" : p["OPEN_DT"], "address" : p["P_ADDR"] } )

s = db.jul29_park.find()
for p in s:
    print(p["_id"])
    print(p["content"])
    if p["open"] == "":
        print(" - ")
    else:
        print(p["open"])
    print(p["addr"])
    print("------------------")

con.close()
print("해치웠나")

