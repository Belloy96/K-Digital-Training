# -*- coding:utf-8 -*-
from cx_Oracle import connect

# csv파일로 만들어주세요! (번호, 시간, 온도, 최고기온, 날씨, 바람방향의 형태로)

con = connect("belloy/8230@localhost:1521/xe")

file = open("C:/Users/sdedu/Desktop/PyData/weather.csv", "a", encoding="UTF-8")

sql = "select wt_no, wt_hour, wt_temp, wt_tmx, wt_wfKor, wt_wdKor from jul19_weather"
# 강사님 답안
# sql = "select * from jul19_weather"

cur = con.cursor()
cur.execute(sql)

for no, hr, tp, tm, wf, wd in cur:
    file.write(f"{no},{hr},{tp},{tm},{wf},{wd}\n")

file.close()
con.close()
print("성공 !")











