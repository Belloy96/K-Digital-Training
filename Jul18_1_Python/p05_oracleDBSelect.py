# -*- coding:utf-8 -*-
from cx_Oracle import connect

# 원두를 검색해서
# 그 원두를 사용하는 커피의 종류 갯수, 평균가를 출력

con = connect("kg/8230@localhost:1521/xe")

n = input("원두 이름 : ")
sql = f"select COUNT(*) ,round(AVG(c_price), 2) from jul18_coffee where c_bean = '{n}'"

# 강사님 답안
# sql = "select count(*) ,round(avg(c_price), 2) from jul18_coffee where c_bean = '%s'" % b
cur = con.cursor()
cur.execute(sql)

for c, a in cur:
    print(c, a)
    print("------------")

con.close()






