# -*- coding:utf-8 -*-

# 파일로부터 데이터를 읽어와서 프로그램에서 활용하기 위함
# 프로그램에서 만든 데이터를 파일형태로 저장하기 위함

# 파일 열기 => 작업(읽기, 쓰기) => 파일 닫기 (필수 !!)

# .txt 파일 / .csv파일 (Comma Separated Value)파일

# 1. 파일에 내용 쓰기 (write : w)
# 폴더는 미리 만들어둬야함 / 파일은 존재하지 않아도 실행시 파일을 만들어줌
# C:\Users\tpgns\Desktop\PyData

# open함수에서 open(file, mode, encoding) 정도만 알아두면 될 것 같음!
#    1) file에 "파일경로"를 넣는데, \ -> / or \\ 로 변경하고, 파일명.확장자 추가하기
#    2) mode에는 현재 write를 사용할 것이라 "w"입력
#    3) encoding="UTF-8"

# w : 덮어쓰기
# file = open("C:/Users/tpgns/Desktop/PyData/test.txt", "w", encoding="UTF-8")
# file.write("오늘 비가 겁나 오네요 ㅠ_ㅠ 이따 점심 회식인데...")
# print("완료!")
# file.close()
# 실행을 여러번 해도 한줄만 나오게 됨. why? w = 덮어쓰기 모드이기 때문!!

# 2. 파일에 내용을 추가 (append : a)
# file = open("C:/Users/tpgns/Desktop/PyData/test.txt", "a", encoding="UTF-8")
# file.write("\n오늘 제가 살아서 돌아온다면...\n그녀에게 고백하겠어요... \n흙흙...")
# print("완료!")
# file.close()

# 3. 파일 읽어오기 (read : r)
file = open("C:/Users/tpgns/Desktop/PyData/test.txt", "r", encoding="UTF-8")

# 3-1. 파일 전체 읽기
# data = file.read()
# print(data)
# file.close()

# 3-2. 파일을 한줄씩 읽기
while True: # 내가 가져온 파일의 내용이 언제 끝날지 모르기 때문에 True 
    data = file.readline() # readline() = 한 줄을 읽어옴
    print(data, end="")
    # readline의 결과가 공백인 상황 (파일의 맨 마지막 줄까지 끝난 상황)
    if data == "": # if문을 추가하지 않으면 종료되지 않음
        break
file.close()









