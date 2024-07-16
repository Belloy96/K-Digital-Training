# -*- coding:utf-8 -*-

class Cat:
    def __init__(self, name, age):
        # print("OL Check")
        self.name = name
        self.age = age

    def printInfo(self):    
        print(self.name, self.age)

# [이 모듈을 실행했을 때 동작해라]가 가능한 조건
#    프로그램의 시작점이라는 뜻
# 이 모듈이 import를 당했을 때 아무 작업도 하지 말고
#    실제 이 모듈에서 코드가 실행되었을 때만 동작해라(라는 뜻도 된다..! pet에서 건너옴)
#    >> 실질적인 main 역할이 가능 O

# Java의 main 메서드의 느낌을 표현하고자 함 ↓ (Java's Main Method와 유사한 기능을 함)
if __name__ == "__main__":
    from animal.pet import Dog  # from 폴더명.모듈명 import 클래스명
    d = Dog('고양이', 2)
    d.printInfo()



