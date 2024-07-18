# -*- coding:utf-8 -*-
from cx_Oracle import connect

# select 번호순으로 조회 => 번호를 입력하면 => 그 데이터가 삭제!
# 999를 입력하게 되면 프로그램이 종료 => 종료하기 전까지 반복
con = connect("kg/8230@localhost:1521/xe")
while True:
    sql = "select * from jul18_coffee order by c_no"
    cur = con.cursor()
    cur.execute(sql)
    
    for no, name, price, bean in cur:
        print(f"{no}] {name}, {price}원, {bean}산")
    print("----------------")
    
    # input으로 번호를 입력하면, 해당 데이터가 삭제되도록!
    d = int(input("번호 입력 : "))
    if d == 999:
        print("프로그램 종료")
        break
    
    sql = f"delete from jul18_coffee where c_no = {d}"
    cur.execute(sql)
    
    if cur.rowcount == 1:
        print(f"{d}번째 데이터 삭제 완료")
        con.commit()

con.close()












