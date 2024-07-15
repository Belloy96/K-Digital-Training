# -*- coding:utf-8 -*-

# function(함수)
# def 함수명(파라미터명):
    # code

def test():
    print("잠못잔 오빈규")

def test2():    # :을 썼으면 그 다음줄에는 반드시 들여쓰기를 해야!! 
    pass        # : 뒤에 코드 적을 것이 없을 때, 자리를 채워주라는 의미
                # 들여쓰기를 안하면 함수 안의 내용인지 별개의 내용인지 알 수 없음..
                # 함수를 만들었다면 그 다음줄에 뭐라도 적어야 오류가 발생하지 않음!

# 정수 2개를 넣으면 그 합을 '출력'하는 함수
def printHab(a=5, b=8): # 호출할 때 값을 안 넣어주면 함수파라미터의 값을
                        # 기본값으로 사용
    print(a + b)

# 정수 3개를 넣으면 그 합을 '출력'하는 함수
# def printHab(a, b, c): # Overloading이 안됨 => 모든 함수명이 다 달라야...
#     print(a + b + c)
    
def printHab2(a, b, c):
    print(a + b + c)
    
# 정수 2개를 넣으면 그 합을 '구하는 함수' / return을 사용!
def getHab(a, b):
    return a + b

# 정수 2개를 넣으면 사칙연산 결과를 '구하는' 함수(튜플로 묶이기 때문에 리턴값이 여러개가 가능)
def calc(a, b):
    
    '''
        설명서...
        이 설명서는 1743년 영국에서부터 시작되어...
        ㅁㄴㅇㄻㄹㅇㄹㄴㄴㅁㄹㅇ -> JavaDoc처럼 설명할 때 쓰임!
    '''
    
    q = a + b
    w = a - b
    e = a * b
    r = a / b
    return q, w, e ,r   # tuple 하나 리턴
    
#############################################
help(calc)  # help사용해서 함수 설명을 가지고 올 수 있음!
help(print) # print함수 예시
test()
print('---')
printHab(3, 7)
printHab()
print('---')
printHab2(4, 8, 6)
print('---')
c = getHab(2, 4)
print(c)
print('---')
d = calc(10, 5)
print(d, type(d))

# u, i, o, p = calc(10, 5)
# print(u, i , o, p)
# 곱하기 부분을 안가지고 오고 싶을 때...
u, i, _, p = calc(10, 5) # _처리하면 곱하기 결과 안가져올 수 있음
print(u, i, p)



