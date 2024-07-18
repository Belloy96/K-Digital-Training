# -*- coding:utf-8 -*-
from cx_Oracle import connect

# 1. DB연결
con = connect("kg/8230@localhost:1521/xe")

# 3. data 확보!
# 로부스타 / 아라비카 / 리베리카
# 원두당 커피 3-4개씩
n = input("커피 이름 : ")
p = int(input("가격 : "))
b = input("원두 이름 : ")

# 4. sql문 작성
#    Java : ?, ?
#    MyBatis : #{멤버변수명}
#    Python : 완성된 sql문을 사용 !
#        sql문 끝나고 나서 ;(세미콜론) 넣지 않는다!

# sql문 작성을 할 때 f-string 활용 시 문자열 데이터에는 '{}' 넣는거 주의!!!
sql = f"insert into jul18_coffee values(jun18_coffee_seq.nextval, '{n}', {p}, '{b}')"
# print(sql) # sql문이 정상적으로 만들어진 것을 확인하는 용도!

# 5. DB관련 작업 (sql문을 서버로 전송, 실행, 결과 받기) : 총괄객체
#    Java : PreparedStatment (pstmt)
#    Python : cursor()
cur = con.cursor()

# 6. 수행 (sql문을 서버로 전송, 실행, 결과 받기)
cur.execute(sql)

# 7. 결과처리
if cur.rowcount == 1: # 방금 작업 때문에 영향을 받은 행 수가 하나라면...
    print("성공 !")
    con.commit()      # commint을 해야 DB서버에 실제로 반영 가능 O

# 2. DB연결종료
con.close()




