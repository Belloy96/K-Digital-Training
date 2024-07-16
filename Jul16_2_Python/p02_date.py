# -*- coding:utf-8 -*-
from datetime import datetime

# 현재시간 날짜
# datetime 자동완성 중 _이 없는 datetime을 가져옴
now = datetime.today() # 자동완성 주의 (_datetime X)
print(now)

# 특정 시간 날짜
yesterday = datetime(2024, 7, 15)
print(yesterday)
print(type(yesterday))
print(yesterday.year)
print(yesterday.month)
print(yesterday.day)

# 생일을 입력받아서 나이를 계산해주는 프로그램 (출력)
birthday = input("생년월일(yyyy/mm/dd) : ")
curYear = now.year
print(curYear - int(birthday[0:4]))

# strptime : str => datetime
bd = datetime.strptime(birthday, "%Y/%m/%d")
print(type(bd))

# strftime : datetime => str // strftime에서의 f는 format한다고 생각하면 편함!
bd = datetime.strftime(bd, "%A")
print(bd)
##################################################################
# Pattern
# %Y : 연도 4자리 / %y : 연도 뒤에 2자리
# %m : 월 / %d : 일 / %H : 시간(24시간) / %I : 시간(12시간) / %p : AM, PM
# %M : 분 / %S : 초 / %a : 요일(짧게 / 'Tue') / %A : 요일(길게 / 'Tuesday')
##################################################################


