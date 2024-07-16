# -*- coding:utf-8 -*-

# 강아지 클래스 => 생성자에 이름, 나이 + 그 속성 출력 기능
class Dog:
    def __init__(self, name, age):
        # print("OL Check")
        self.name = name
        self.age = age

    def printInfo(self):    
        print(self.name, self.age)

# wild에서 main method같은 기능 사용 후에 여기로 다시 돌아와서 작성

# 이 부분을 실행했을 때 wild의 main method는 안불러와지는 상태임!(다시 wild로!)
if __name__ == "__main__":
    # 여기서 야생동물 불러와서 => 객체 만들어서 출력하는 기능까지!
    from animal.wild import Cat
    c = Cat("러시안블루", 7)
    c.printInfo()


