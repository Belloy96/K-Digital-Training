# -*- coding:utf-8 -*-
from cx_Oracle import connect

# input으로 숫자 2개를 입력 => 가격순(오름차순)으로 정렬해서
#                        => ? ~ ?번째까지의 평균 가격을 출력

x = int(input("x : "))
y = int(input("y : "))

con = connect("kg/8230@localhost:1521/xe")

sql = f"select avg(c_price) from (select rownum as rn, c_price from (select c_price from jul18_coffee order by c_price)) where rn between {x} and {y}"

# 강사님 답안
# sql = "select avg(c_price) "
# sql += "from (select rownum as rn, c_price "
# sql += "from (select c_price "
# sql += "from jul18_coffee order by c_price)) "
# sql += f"where rn between {x} and {y}"

cur = con.cursor()
cur.execute(sql)

for c in cur:   # cur안에 tuple 형태로 결과가 담김
    print(c)
    print(type(c))
    print(c[0]) # tuple안에 ""값 빼버리기 위해서 사용!
    
con.close()


















