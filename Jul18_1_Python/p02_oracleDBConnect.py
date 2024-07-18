# -*- coding:utf-8 -*-
from cx_Oracle import connect

# OracleDB와 연동이 되는 Java : instantClient에 있는 ojdbc8.jar
# OracleDB와 연동이 되는 Python : cx_Oracle.py(가 instantClient를 사용)

# 기본적으로 python에는 OracleDB 연결 기능이 없어요...
# 시작 - cmd -> pip install cx_oracle
# pip list로 확인!

# sqlplus로 접속할 때 사용하는 주소
#    sqlplus [ID]/[PW]@[IP Address]:[PORT]/[SID]
#    sqlplus kg/8230@localhost:1521/xe

# 연결이 잘 안될수도 있으니 try - except 걸어놓고 감!
# connect 자동완성 -> cx_Oracle
try:
    c = connect("kg/8230@localhost:1521/xe")
    print("성공 !") # 접속에 성공했다면 뜰 메시지
except Exception as e:
    print(e)

c.close()