# -*- coding:utf-8 -*-
from _ast import In

# 조건문 : 흐름 제어 // Java에서 {}에 해당하는 부분 => : // print()부분의 들여쓰기 꼭 하기!

if True:
    print("와 ~ 조건문")
if False:
    print("안나오G ~ ?")
############################################
# 우선순위 (산술, 관계, 논리)
# 산술 > 관계 > 논리
print(10 + 2 > 8 + 3)   # 산술이 관계보다 앞서서 진행이 되어(계산함) => 12 > 11 -> True
print(10 + 2 * 2 > 8 + 3 * 2) # 14 > 14 -> False
print(((10 + 2) > 3) and (6 + 4 == 10)) # 둘 다 참이어서 True!
############################################
# if 조건A:
#    코드
# else:
#    코드    

# 놀이동산 >> A : 성인, 150이상 (값은 입력받아서)
# 입력시에 => 탑승 가능 or 탑승 불가 출력
age = int(input("나이 : "))
height = float(input("키 : "))

if age < 20 or height < 150:
    print('탑승 불가')
else:
    print('탑승 가능')

# 강사님 답안
# if (age >= 20):
#    if (height >= 150):
#        print('탑승 가능')
#    else:
#        print('탑승 불가')    

# if (age >= 20 and height >= 150):
#    print('탑승 가능')
# else:
#    print('탑승 불가')

# print("탑승 가능" if (age >= 20 and height >= 150) else "탑승 불가" )
# print((age >= 20 and height >= 150) and "탑승 가능" or "탑승 불가")
############################################
# 다중 조건문
# Java : if - else if - else
# Python : if - elif - else
# 점수 입력 => 80점 이상은 'A'
#            70점 이상은 'B'
#            60점 이상은 'C'
#            나머지는 'D'를 출력
score = int(input("점수 : "))

if score > 100 or score < 0:
    print("엥 ?")
elif (score >= 80):
    print("A")
elif (score >= 70):
    print("B")
elif (score >= 60):
    print("C")
else:
    print("D")
############################################
# switch - case : 없음

# in, not in
abc = {"name" : "벨로이", "age" : 19, "phone" : "010-1111-2222"}

print("name" in abc) # name이라는 key가 abc에 있는지 확인. 있으면 True, 없으면 False
print(20 in abc.values()) # 20이라는 value가 abc에 있는지 확인. 있으면 True, 없으면 False
print("height" not in abc) # height이라는 key가 abc에 있는지 확인. 있으면 True, 없으면 False    











