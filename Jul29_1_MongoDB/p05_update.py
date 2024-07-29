# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

con = MongoClient("192.168.0.77")

db = con.jul29

# update_one / update_many

db.jul29_lunch.update_one( { "_id": "알새우비프샤브카레"}, {"$set": {"price": 19000 } } )

# 존재하지 않는 데이터를 update 진행해보려고 함
# upsert는 해당 정보를 찾아서 update하게 되는데,
#    만약에 해당 값이 없으면 새롭게 생성하겠다 라는 옵션
db.jul29_lunch.update_one( { "_id": "test"}, {"$set": {"price": 9000 } } 
                           , upsert = True)


con.close()
print("해치웠나")

