# -*- coding:utf-8 -*-
import random
from random import randint
import time

# Java (null) = Python (None) 자바에서는 null, 파이썬에서는 None

# 가위바위보 (함수) => 한 번 질 때까지 => 총 몇 번 이겼는지 출력

def getComAns():
    comAns = random.randint(1, 3)
    return comAns

def getUserAns():
    userAns = input("가위 or 바위 or 보 입력 : ")
    if userAns == '가위':
        userAns = 1
        return userAns
    elif userAns == '바위':
        userAns = 2
        return userAns
    elif userAns == '보':
        userAns = 3
        return userAns    
    else:
        print('다시 정확히 입력')
        return getUserAns()

def playGame():
    win = 0;
    lose = 0;
    while lose < 1:
        comAns = getComAns()
        userAns = getUserAns()
        result = userAns - comAns
        print(result, type(result))
        if result == 1 or -2:
            win += 1
            print('컴퓨터 : %d' % comAns)
            print('나 : %d' % userAns)
            print('승리! 지금까지 이긴 횟수 %d회' % win)
        elif result == -1 or 2:
            lose += 1
            break
        elif result == 0:
            print('무승부! 승부를 재개!')    
    if lose == 1:
        print('한 번 지면 끝이야.. 이긴 횟수 %d회' % win)
    
# playGame()    

#################################################
# 강사님 답안
handTable = [None, "가위", "바위", "보"]

def printRule():
    print("-----------")
    for i, h in enumerate(handTable):
        if (i != 0):
            print("[%d] %s" % (i, h))
    print("-----------")
    
def comFire():
    return randint(1, 3)  # import로 가져옴  

def userFire():
    print("-----------")
    uh = int(input("뭐 낼 까 ? : "))
    print("-----------")
    if (1 <= uh <= 3):
        return uh
    else:
        print("잘 못 입 력 했 음 !")
        return userFire()

def printHand(uhuh, chch):
    print("유저 : %s" % handTable[uhuh])
    print("컴퓨터 : %s" % handTable[chch])

def judge(uhuh, chch):
    t = uhuh - chch
    if t == 0:
        print("무승부")
        return 0
    elif t == -1 or 2:
        print("패배")
        return 999 # 아무 값이나 return
    else:
        print("승리")
        return 1

def playGame2():
    printRule()
    win = 0;
    while True:
        uHand = userFire()
        cHand = comFire()
        printHand(uHand, cHand)
        result = judge(uHand, cHand)
        if result == 999:
            print("-=-=-=-=-=-=-=-=-=-")
            print("종료 !")
            
            if win >= 10: # 밋밋해서 추가한 기능, import time 추가
                time.sleep(1) # Java의 Thread.sleep()
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print("댕고수...")
            elif win >= 5:
                time.sleep(1)
                print(".", end="")
                time.sleep(1)    
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print("좀 치네?")
            else:
                time.sleep(1)
                print(".", end="")
                time.sleep(1)    
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print("삭제해라 애송이")
            break
        win += result    
    print("%d승으로 종료 !" % win)

playGame2()
