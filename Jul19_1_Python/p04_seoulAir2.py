# -*- coding:utf-8 -*-
from cx_Oracle import connect

# DB에 있는 미세먼지 데이터 => csv에 저장(데이터 콤마로 구분)

con = connect("belloy/8230@localhost:1521/xe")

f = open("C:/Users/sdedu/Desktop/PyData/airs.csv", "a", encoding="UTF-8")

sql = "select * from jul19_airs"

cur = con.cursor()
cur.execute(sql)

for no, nm, pm10, pm25 in cur:
    f.write(f"{no},'{nm}',{pm10},{pm25}\n")

f.close()
con.close()
print("성공 !")



