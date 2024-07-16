# -*- coding:utf-8 -*-


class Book:
    # def __init__(self):     # __ -> 생성자 자동완성 단축키
        # print("기본생성자 - 책 생성")
    
    # 생성자 : 객체가 메모리상에 만들어질 때 호출하는 메소드   
    # overloading이 안되니 => 생성자를 하나만...!
    def __init__(self, title, price):   # 파라미터 설정(제목과 가격정도..)
        print("오버로딩 된 생성자 ?!?!?!")
        self.title = title  # 보통은 이렇게 생성자에서 멤버변수를 만들어서 결정
        self.price = price  

    def printInfo(self):
        print(self.title, self.price)
        
    # 소멸자(destructor) : 객체가 메모리상에서 사라질 때 호출하는 메소드    
    def __del__(self):
        print("책 삭제")
######################################################
# 사람 클래스 : 이름, 나이 / 그 속성을 출력하는 기능 / 생성자, 소멸자
class Human:
    def __init__(self, name, age):
        print("오버로딩 되었는지 확인용")
        self.name = name
        self.age = age
    
    def printInfo2(self):
        print(self.name, self.age)
    
    def __del__(self):    
        print("인간 소멸")
        
######################################################
# b1 = Book()
b2 = Book("요리책", 7000)       # 오버로딩 된 생성자 ?!?!?!
b2.printInfo()                 # 요리책 7000
print("------")                # 이후에 소멸자 발동! (책 삭제)
######################################################
# Garbage Collection : 그 객체를 가리키는 변수가 없게 되면 Heap영역을 자동으로 정리
h1 = Human("벨로이", 7)
h1.printInfo2()
print("------")                

h2 = Human("김겸", 77)
h2.printInfo2()                 # 모든 출력이 끝나고 소멸자가 발동되었음
print("------")                 # 순서대로 책 삭제 / 인간 소멸 / 인간 소멸             

h3 = h1
h3.printInfo2()
print(id(h1))                   # h1과 h3의 저장위치가 같음을 확인할 수 있음
print(id(h3))                   # 그림판 참조!

h1 = None                       # h1을 없애버림
# h1.printInfo2()               # h1을 없애버렸기 때문에 오류가 발생함
# h3.printInfo2()                 # 제대로 작동함
h3 = None                       # h3를 없애버림

print("asfasdfsdfasfasdfasfsdf")

# 그림판 참조해서 나오는 순서 확인할 것
# ------
# 벨로이 7
# 2857926451408
# 2857926451408
# 인간 소멸
# asfasdfsdfasfasdfasfsdf
# 책 삭제
# 인간 소멸
