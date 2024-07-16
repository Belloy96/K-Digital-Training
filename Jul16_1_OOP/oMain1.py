# -*- coding:utf-8 -*-

# OOP : 객체 단위로 실생활을 표현 => 유지보수가 편하다는 장점!
#    캡슐화 => 데이터를 안전하게 처리
#    1 file == 1class => 코드 재사용

# Java : Perfect한 OOP
#    Java File(class) => 파일 하나가 곧 클래스 하나
#    클래스명은 항상 대문자로 시작! ex) Cat / Dog

# Python : hybrid한 OOP
#    Python File(module) => 파일 하나에 클래스가 여러개 들어올 수 있음
#                            (1 file != 1 class)
#    클래스명 무조건 대문자로 시작하라는 법은 없음
#    접근제어자(ex: public, private, ...) 없음 => 캡슐화 없음
#    static 멤버변수 없음(대신 static method는 있음)
################################################################
class Shop():
    def showInfo(self):
        print(self.name, self.floor)
# 클래스 내부에서 사용했으니 위의 Shop은 method!    

class Dog:
    name = "asdf"   # 의미 없음 
                    # 42번줄에서 넣은 값이 24번줄의 name에 담기는 것이 아님
                    # 단순 기본값 처리용(멤버 변수의 느낌이 아님!)
                    # 멤버 변수는 생성자에서 만들어줄것!
                        
    def bark(self):     # self는 필수적으로 들어가 있어야 함
        print("왈왈컹컹왈왈컹컹왈왈컹컹왈컹왈컹컹컹왈왈")
    
    def printInfo(self):
        # Java : 속성을 표현하기위해(this = 자기자신) -> this.name 
        #        => this. 은 생략이 가능 => name
        # Python : self.name => self. 은 생략이 불가능 => self.name으로 써야!
        print(self.name, self.age)

    # overloading 지원 안됨 => 모든 메소드명은 다 달라야
    def printInfo2(self, c): # 반복횟수는 내가 설정(c)..    
        for _ in range(c):
            print(self.name, self.age)
    
    # static method : 객체 만들지 않고 사용할 수 있는 메소드
    # @ : decorator(데코레이터, Spring에서 Annotation)
    @staticmethod       # 이걸 추가하면 static method로써 사용 가능!
    def staticMethodTest():
        print("Mㅔthㅗdㅡ")    

################################################################
Dog.staticMethodTest()

s = Shop()
s.name = '카페'    
s.floor = 1
s.showInfo()
print("------------------")  
d = Dog()
d.name = "댕댕이" # 주석 처리하면 댕댕이 대신 24번 줄에서 넣었던 값이 나옴   

d.age = 1982
print(d, type(d))
d.printInfo()

d.bark()        # 메소드 호출방법 1 (해당 객체에 접근해서 메서드를 불러오기)
Dog.bark(d)     # 메소드 호출방법 2 
print("------------------")  
d.printInfo2(3)

