# -*- coding:utf-8 -*-
from cx_Oracle import connect

# input 2개 : 원두 이름 검색 / 숫자를 입력
# 검색한 원두를 사용하는 커피의 가격을 => 입력한 숫자만큼 인상

con = connect("kg/8230@localhost:1521/xe")

b = input("원두 : ")
p = int(input("인상할 가격  : "))

sql = f"update jul18_coffee set c_price = c_price + {p} where c_bean = '{b}'"

cur = con.cursor()
cur.execute(sql)

if cur.rowcount >= 1:
    print("성공 !")
    con.commit()

con.close()








