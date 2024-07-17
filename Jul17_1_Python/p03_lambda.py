# -*- coding:utf-8 -*-

# 람다(lambda) 함수
#    장점 : 메모리 절약, 가독성 향상, 코드가 간결
#        일반 함수 : 함수 생성 => 메모리에 할당
#        람다 함수 : 즉시 실행함수 => 메모리 초기화
#    표현법 :
#        lambda 파라미터 : 표현식

# 변수를 할당하는 일반적인 함수
def hab(num):
    x = num + 100
    return x
print(hab(100))

# 위의 내용을 람다함수로!
(lambda num: print(num + 100))(100)

# 숫자 두개 넣으면 그 곱을 출력하는 함수
(lambda x, y: print(x * y))(7, 77)

# 숫자 두개 넣으면 그 합을 구하는 함수
hab2 = (lambda x, y: x + y)(7, 77)  # hab2에는 결과값을 담아둔 상태임!(함수가 아니고..)
print(hab2)



