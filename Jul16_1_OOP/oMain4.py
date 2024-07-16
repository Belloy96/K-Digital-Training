# -*- coding:utf-8 -*-

# abstract - X

# Java : 생성자 상속이 안됨
# Python : 생성자가 상속이 됨
#    멤버변수를 생성자에서 결정 => 생성자를 상속을 해주지 않으면
#        => 멤버변수가 상속이 안되는...

class Avengers:
    def __init__(self, name, age):
        print("Avengers Assemble ~")
        self.name = name
        self.age = age

    def attack(self):    
        print("공----격")

    def printInfo(self):
        print(self.name)
        print(self.age)
###################################################

class Ironman(Avengers):    # (Avengers)상속했다는 뜻!
    
    # overloading : 메서드명 같게, 파라미터는 다르게
    # overriding : 상속받은 메서드의 기능을 바꾸기
    def __init__(self, name, age, suitType):
        Avengers.__init__(self, name, age)  # -> 상속 받아오고
        self.suitType = suitType            # -> 기능을 바꿈! 따라서 overriding!

    def attack(self):
        # Avengers.attack(self)    
        super().attack()                    # super()즉, 상위 클래스에 있는 attack()기능
        print("탈모빔 발4 ~~~")
        
    def printInfo(self):
        Avengers.printInfo(self)    
        print(self.suitType)

###################################################
# 헐크어벤져스 소속) / 이름, 나이, 바지사이즈 / 공격 O / 정보 출력

class Hulk(Avengers):
    def __init__(self, name, age, pantsSize):
        Avengers.__init__(self, name, age)
        self.pantsSize = pantsSize
    
    def attack(self):
        super().attack()
        print("항상 화가 나있는 사람")

    def printInfo(self):
        Avengers.printInfo(self)
        print(self.pantsSize)

###################################################
if __name__ == "__main__":
    i = Ironman("토니스타크", 1, "mk50")
    i.attack()
    i.printInfo()
    print('----------')
    h = Hulk("브루스배너", 2, 50)
    h.attack()
    h.printInfo()
    print('----------')





