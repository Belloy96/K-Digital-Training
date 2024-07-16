# -*- coding:utf-8 -*-
from random import randint

# randint

# animal 폴더 생성 후 pet 모듈 생성(이름, 나이)
# animal 폴더 안에 wild 모듈 생성
# pet, wild main method 역할 다 수행하고 oMain3으로 넘어왔음!

# 패키지에 있는 Class 불러오기

# 방법 1
#    import 패키지명.모듈명
#    객체명 = 패키지명.모듈명.클래스명(값1, 값2, ...)
#    객체명.메서드

# import animal.pet   # import 패키지명.모듈명 => 써먹을 수 있게 불러온 것
                      # pet.py의 소스가 여기로 들어온 셈
# d = animal.pet.Dog("댕댕이", 14)   # 패키지명.모듈명.클래스명(...)
# d.printInfo()

####################################################################

# 방법 2
#    import 패키지명.모듈명 as 별명
#    객체명 = 별명.클래스명(값1, 값2, ...)
#    객체명.메서드

# import animal.pet as ap     # import 패키지명.모듈명 as 별명
# d = ap.Dog("멈뭄미", 1)       # 별명.클래스명(...)
# d.printInfo()

####################################################################

# 방법 3
#    from 패키지명.모듈명 import 클래스명
#    객체명 = 클래스명(값1, 값2, ...)
#    객체명.메서드

# from animal.pet import Dog  # from 패키지명.모듈명 import 가져올거
# d = Dog("댕댕쓰", 3)
# d.printInfo()

####################################################################

# 방법 4
#    from 패키지명.모듈명 import 클래스명 as 별칭
#    객체명 = 클래스명(값1, 값2, ...)
#    객체명.메서드

# from animal.pet import Dog as dd
# d = dd("댕댕e", 6)
# d.printInfo()

####################################################################

# Java :
#    전세계적으로 많이 사용되고
#    자기가 작업한거 공유하는 문화 => maven
#    클래스명이 당연히 중복이 될 것
#    클래스명이 중복될 때 구분하는 수단 : package
#    패키지명은 전세계적으로 중복이 되지 않도록 => com(kr).회사명.프로그램명.주제
#                                     ex) com.belloy.jul161.project
#    패키지명.클래스로 사용 => 어떤 조건에 맞으면 패키지명을 안써도 됨
#        (같은 패키지 or (Class가)java.lang 소속 or import하면 패키지명 생략 O)
#    java.util.Random r = new java.util.Random(); -> 원래라면 이렇게 작성해야 하는데 ..
#    Random r = new Random(); -> import를 했기 때문에 이렇게 표현을 했었음 !
#    import는 선택사항

# Python :
#    전세계적으로 많이 사용되고
#    자기가 작업한거 공유하는 문화 => pip
#    클래스명이 당연히 중복이 될 것
#    클래스명이 중복될 때 구분하는 수단 : package
#    패키지명에 규칙이 없음 => 패키지명 중복 => ?!??!?!?!
#    클래스를 꼭 패키지에 넣지만은 않음
#    다른 파일을 불러온다면 import는 필수!!!!

####################################################################

import animal.pet as ap

class Dog:
    def punch(self):
        print("댕댕펀취 ~ ")

d = ap.Dog("댕댕이", 1)    # pet의 Dog 클래스를 가져옴
d.printInfo()

# 클래스명이 중복된다면, 가까운 걸로 판정 ↓
d2 = Dog()          # oMain3의 Dog 클래스를 가져옴
d2.punch()        








