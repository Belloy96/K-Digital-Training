# -*- coding:utf-8 -*-
from cx_Oracle import connect
from datetime import datetime

# 메뉴만들기 (함수)
# 1. 학생 등록 / 2. 강의장 조회 / 3. 학생 조회 / 4. 학생정보를 파일로 내보니기
# 0. 종료

# 강의장 조회 : 1강의장 - 6층 복도 오른쪽
# 학생 조회 : 이름, 생년월일(연-월-일 (요일)), 나이, 몇 강의장,
#        중간 점수, 기말 점수, 평균 점수
# 파일로 내보내기 (학생의 전체 정보 다 csv파일로)

def showMenu():
    print("---------------------")
    print("1. 학생 등록")
    print("2. 강의장 조회")
    print("3. 학생 조회")
    print("4. 학생 정보를 파일로 내보내기")
    print("0. 종료")
    print("---------------------")
    return input("번호 입력 : ")

def regStudent():
    con = connect("belloy/8230@localhost:1521/xe")
    cur = con.cursor()
    s_name = input("이름 : ")
    s_birthday = input("생년월일(YYYYMMDD) : ")
    s_classroom = input("강의장 : ")
    s_mid = int(input("중간 점수 : "))
    s_fin = int(input("기말 점수 : "))
    
    sql = f"insert into jul19_student values(jul19_student_seq.nextval, '{s_name}', to_date('{s_birthday}', 'yyyymmdd'), '{s_classroom}', {s_mid}, {s_fin})"
    cur.execute(sql)
    
    if cur.rowcount == 1:
        print("등록 성공")
        con.commit()
    con.close()

def checkClassroom():
    con = connect("belloy/8230@localhost:1521/xe")
    cur = con.cursor()
    sql = "select * from jul19_classroom"
    cur.execute(sql)
    for c, l in cur:
        print(f"{c} - {l}")
    con.close()

# 학생 조회 : 이름, 생년월일(연-월-일 (요일)), 나이, 몇 강의장,
#        중간 점수, 기말 점수, 평균 점수
def checkStudent():
    con = connect("belloy/8230@localhost:1521/xe")
    # sql = "select s_name, s_birthday, s_classroom, s_mid, s_fin from jul19_student"
    sql = "select * from jul19_student"
    
    cur = con.cursor()
    cur.execute(sql)
    now = datetime.today()
    # curYear = now.year
    
    for _, name, birthday, classroom, mid, fin in cur:
        print("################")
        print(f"이름 : {name}")
        bd = datetime.strftime(birthday, "%Y-%m-%d")
        print(f"생일: {bd} ({birthday.strftime('%a')})")
        # age = curYear - int(birthday[0:4])
        print(f"나이: {now.year - birthday.year}세")
        print(f"강의장 : {classroom}")
        print(f"중간고사 점수 : {mid}점")
        print(f"기말고사 점수 : {fin}점")
        print(f"평균 점수 : {(mid + fin) / 2}점")
        
    con.close()
    
def makeCSV():
    con = connect("belloy/8230@localhost:1521/xe")
    f = open("C:/Users/sdedu/Desktop/PyData/student.csv", "w", encoding="UTF-8")
    cur = con.cursor()
    sql = "select * from jul19_student"
    cur.execute(sql)
    for no, na, bd, cr, mi, fi in cur:
        f.write(f"{no},'{na}','{bd}','{cr}',{mi},{fi}\n")
    f.close()
    con.close()
    print("파일 생성 성공!")

# 기능 모아주기
def go():
    while True:
        menu = showMenu()
        if menu == "0":
            print('종료합니다')
            break
        elif menu == "1":
            regStudent()
        elif menu == "2":
            checkClassroom()    
        elif menu == "3":
            checkStudent()    
        elif menu == "4":
            makeCSV()
        else:
            print("정확한 숫자를 입력하세요")    
            go()
            
go()
