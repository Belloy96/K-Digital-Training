# -*- coding:utf-8 -*-
from cx_Oracle import connect

# Table 데이터 => 번호값 제외한 모든데이터 => csv파일 담는 작업

con = connect("kg/8230@localhost:1521/xe")

cur = con.cursor()
sql = "select * from search_location order by sl_no"
cur.execute(sql)

with open("C:/Users/tpgns/Desktop/PyData/location.csv", "w", encoding="UTF-8") as f:
    for _, pn, ph, x, y in cur:
        f.write(f"{pn},{ph},{x},{y}\n")

con.close()
print("끝")








