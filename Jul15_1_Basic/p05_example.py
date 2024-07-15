# -*- coding:utf-8 -*-
import random

# UP/DOWN 게임 (함수)
# 유저의 이름을 입력받고 환영하는 인사를 출력
# (컴퓨터) 1 ~ 100 사이의 랜덤한 숫자를 하나 뽑아서
# 유저에게 정답을 입력하게 했을 때
# 저 범위의 숫자가 아니면 다시 입력하도록
# 입력한 숫자가 정답보다 작으면 'UP', 크면 'DOWN' 출력
# 정답을 맞췄을 때는 몇 번만에 맞췄는지 출력 + 종료
# 정답 기회는 총 10번

name = input("이름 : ")
print('%s' % name + '님 환영합니다')
print('==================')
comAnswer = random.randint(1, 100)
userAnswer = 0;
count = 0;

while count < 10:
    userAnswer = int(input("정답 입력 : "))
    
    if userAnswer > comAnswer:
        count += 1
        print('%d' % count + '번째 시도 : ' + 'DOWN')
    elif userAnswer < comAnswer:
        count += 1
        print('%d' % count + '번째 시도 : ' + 'UP')
    elif userAnswer == comAnswer:
        count += 1
        print('%d' % count + '번 만에 정답 !')    
        break
    
    if count == 10:
        print('시도횟수 모두 소진! 다음 기회에 ...')
    
##########################################################
# 강사님 답안
def greetUser():
    userName = input("당신의 이름은 ? : ")
    print("반갑고 ~ ", userName)

def getComAns():
    comAns = random.randint(1, 100)
    return comAns    

def explainRule():    
    print("####################")
    print("기회는 총 10번!")
    print("1부터 100사이의 숫자를 맞춰봐!")
    print("####################")
    
def sayUserAnswer():    
    userAns = int(input("입력할 답은 ? : "))
    if userAns > 100 or userAns < 1:
        print("정답은 1부터 100사이라고 휴먼")
    return userAns if 1 <= userAns <= 100 else sayUserAnswer()
    
def playGame():    
    greetUser()
    comAns = getComAns()
    explainRule()
    count = 0;
    while count < 10:
        userAns = sayUserAnswer()
        count += 1
        if userAns < comAns:
            print("UP !")
        elif userAns > comAns:
            print("DOWN !")    
        else:
            print("####################")
            print("정답이야! %d번 만에 맞췄어 !" % count)    
            print("정답은 %d번이었어 !" % comAns)    
            print("####################")
            break
    if count == 10:
        print("10번의 기회를 다 썼어 ! 정답은 %d이었어 ! " % comAns)
##########################################################
playGame()


