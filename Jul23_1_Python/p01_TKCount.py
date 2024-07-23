# -*- coding:utf-8 -*-
from cx_Oracle import connect

# sss = ["ㅋㅋㅋ", "ㅁㅁㅁ", "ㅂㅂㅂ", "ㅎㅎㅎ", "ㅁㅁㅋㅋㅋ", "ㄹㄹㄹ"]
# for s in sss:
    # # 찾는 문자열이 존재하는 경우 : 그 문자열이 있는 인덱스값을 리턴
    # # 찾는 문자열이 존재하지 않는 경우 : -1 리턴
    # print(s.find("ㅋㅋㅋ"))
    # print(s.find("ㅊㅊㅊ"))
    # print()

# 조조(맹덕), 유비(현덕), 손권(중모)
# 책을 훑어보면서... => 위의 인물들이 몇 번 언급됐는지 카운팅하기!
# 인물, 언급횟수    의 형태로 => csv파일에 저장

# f1 = open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms01.txt", "r", encoding="UTF-8")
# book1 = f1.read()
# print(book1)
# print(book1)

# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms01.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("1권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j1 = data1.count("조조") + data1.count("맹덕")
    # u1 = data1.count("유비") + data1.count("현덕")
    # s1 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms02.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("2권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j2 = data1.count("조조") + data1.count("맹덕")
    # u2 = data1.count("유비") + data1.count("현덕")
    # s2 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms03.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("3권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j3 = data1.count("조조") + data1.count("맹덕")
    # u3 = data1.count("유비") + data1.count("현덕")
    # s3 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms04.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("4권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j4 = data1.count("조조") + data1.count("맹덕")
    # u4 = data1.count("유비") + data1.count("현덕")
    # s4 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms05.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("5권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j5 = data1.count("조조") + data1.count("맹덕")
    # u5 = data1.count("유비") + data1.count("현덕")
    # s5 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms06.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("6권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j6 = data1.count("조조") + data1.count("맹덕")
    # u6 = data1.count("유비") + data1.count("현덕")
    # s6 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms07.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("7권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j7 = data1.count("조조") + data1.count("맹덕")
    # u7 = data1.count("유비") + data1.count("현덕")
    # s7 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms08.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("8권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j8 = data1.count("조조") + data1.count("맹덕")
    # u8 = data1.count("유비") + data1.count("현덕")
    # s8 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms09.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("9권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j9 = data1.count("조조") + data1.count("맹덕")
    # u9 = data1.count("유비") + data1.count("현덕")
    # s9 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# with open("C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms10.txt", "r", encoding="UTF-8") as file1:
    # data1 = file1.read()
    # print("10권")
    # print(data1.count("조조") + data1.count("맹덕"))
    # print(data1.count("유비") + data1.count("현덕"))
    # print(data1.count("손권") + data1.count("중모"))
    # j10 = data1.count("조조") + data1.count("맹덕")
    # u10 = data1.count("유비") + data1.count("현덕")
    # s10 = data1.count("손권") + data1.count("중모")
    # print("----")
    #
# print(j1+j2+j3+j4+j5+j6+j7+j8+j9+j10)
# print(u1+u2+u3+u4+u5+u6+u7+u8+u9+u10)
# print(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10)
#
# con = connect("kg/8230@localhost:1521/xe")
# cur = con.cursor()
#
# sqlj = "insert into jul23_book values('조조', 6059)"
# sqlu = "insert into jul23_book values('유비', 3986)"
# sqls = "insert into jul23_book values('손권', 988)"
#
# cur.execute(sqlj)
# cur.execute(sqlu)
# cur.execute(sqls)
#
# if cur.rowcount == 1:
        # con.commit()
        #
# sql = "select * from jul23_book"
# cur.execute(sql)
#
# con.close()

# 강사님 답안
wc = {"조조": 0, "유비": 0, "손권": 0}
for i in range(1, 11):
   fileName = "C:/Users/tpgns/OneDrive/바탕 화면/Class_Download/ThreeKingdoms/ThreeKingdoms%02d.txt" % i
   # print(fileName)
   with open(fileName, "r", encoding="UTF-8") as f:
       for line in f.readlines():
           # print(line)
           line = line.replace("\n", "")
           line = line.split(" ")
           for word in line:
               # print(word)
               if word.find("조조") != -1 or word.find("맹덕") != -1:
                   wc["조조"] += 1
               elif word.find("유비") != -1 or word.find("현덕") != -1:
                   wc["유비"] += 1
               elif word.find("손권") != -1 or word.find("중모") != -1:
                   wc["손권"] += 1
for key in wc:
   print(key)
for val in wc.values():
   print(val)
with open("C:/Users/tpgns/Desktop/PyData/tkResult.csv", "w", encoding="UTF-8") as f:
   for k, v in wc.items():
       f.write(f"{k},{v}\n")
print("END !")

