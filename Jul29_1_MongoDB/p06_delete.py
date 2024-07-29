# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

con = MongoClient("192.168.0.77")

db = con.jul29
#                데이터 하나        데이터 여러 개
# remove() / delete_one() + delete_many() 

# db.jul29_lunch.remove({ "_id" : "test" }) 수업 진행에서는 실행되지 않았음

# mongoDB cmd 내부에서 db.jul29_lunch.remove({})를 실행했을 때는 정상 구동 됨
# => 전체 데이터 삭제 시
# db.jul29_lunch.remove({ "_id" : "test" }) -> 이것도 정상 구동됨(cmd 내부에서)

# 해당 데이터 하나만 삭제(처음 만나는 데이터에서만 적용함!!)
db.jul29_lunch.delete_one({"price": 12000})

# 해당 데이터 전체 삭제(예시에 있는 12000원의 데이터를 가지고 있는 모든 것을 삭제)
db.jul29_lunch.delete_many({"price": 12000})
db.jul29_lunch.delete_many({}) # = db.jul29_lunch.remove({})

con.close()
print("해치웠나")

