# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

# Python + MongoDB

# cmd => pip install pymongo

# 연결
# 192.168.0.77
# 변수명 = MongoClient("[ip주소]") / localhost도 가능은 함!
con = MongoClient("192.168.0.77")

db = con.jul29

con.close()
print("Success !")
# -------연결완료!----------

