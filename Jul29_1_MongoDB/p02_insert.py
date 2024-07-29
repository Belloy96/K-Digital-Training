# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

# 연결
# 192.168.0.77
# 변수명 = MongoClient("[ip주소]") / localhost도 가능은 함!
con = MongoClient("192.168.0.77")

db = con.jul29

# 음식 메뉴와 가격을 입력받아서 mongoDB에 저장하기
m = input("메뉴 이름 : ")
p = int(input("가격 : "))

# insert_one() : 하나의 데이터를 insert할 때
# cf) insert_many() : 여러개의 데이터를 한꺼번에 insert할 때
#                        (각 데이터들은 list에 담아서 처리)

db.jul29_lunch.insert_one({ "_id": m, "price": p })

con.close()
print("Success !")

