# -*- coding:utf-8 -*-

# Java vs Python
#    Java : 컴퓨터 활용 효율적으로 사용 => 규칙의 언어 => Perfect한 객체지향언어
#          - 장점: 명확하고, 혼란스럽지 않은 코드
#          - 단점: 코드가 길어짐

#    Python : 사람이 쓰기 편하게 만들어진 언어 => 자유의 언어 => Hybrid한 객체지향언어
#          - 장점: 코드가 짧아짐
#          - 단점: 명확하지 않아서 코드가 길어지면 헷갈릴 여지가 있음 (자료형을 python이 알아서 골라줌)
######################################################################################

# 기본적인 출력 방식
print("WA! 파이썬!")
print('WA! 금요일!')  # print 안에는 enter기능 포함 O
print()

# seperator(구분자)
print('내', '일', '토', '요', '일', sep='ㅋ')
# 메일주소 출력
print('yjna29', 'skkukdp.re.kr', sep='@')
# 전화번호 출력
print('010', '9599', '3380', sep='-')
print()

# end
print('파이썬이', end=' ')
print('본격적으로', end=' ')
print('시작되었습니다.', end=' ')
print()

# 출력 형식(format)
print('{} and {}'.format('1번', '2번'));
print('{1} and {0} and {0}'.format('1번', '2번')); # 순서에 맞는 값
print('{p1} is {p2}'.format(p1='Life', p2='Egg')) # 값 지정 
print()

# %d, %f, %s
# System.out.printf("%d", 123);
print('%d' % 123)
print('%.2f' % 123.45678)

# 10이라는 값을 0번째에, 11.11111이라는 값을 1번째에 소수점 둘째자리까지 출력
print('{} , {}'.format('%d' % 10, '%.2f' % 11.11111))
print('{0: d} , {1: .2f}'.format(10, 11.11111))


