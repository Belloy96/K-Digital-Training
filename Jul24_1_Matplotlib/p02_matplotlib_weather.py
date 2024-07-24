# -*- coding:utf-8 -*-

import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring

# 기상청 데이터
#    => 각 3시간별 기온(temp)와 습도(reh)를 선 그래프로 표현
# https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168072000
# www.kma.go.kr
# /wid/queryDFSRSS.jsp?zone=1168072000

plt.rcParams['axes.unicode_minus'] = False # 음수부호(마이너스) 제대로 안나올 때 처리(온도가 영하로 떨어질때)

hc = HTTPSConnection("www.kma.go.kr")
u = "/wid/queryDFSRSS.jsp?zone=1168072000"
hc.request("GET", u)

res = hc.getresponse().read()
# print(res.decode())

hour = []
temp = []
reh = []

# 기본 타입이 문자열인데 이를 형변환해서 사용하면 각 y축의 값들이 깔끔하게 나옴
for w in fromstring(res).iter("data"):
    hour.append(w.find("hour").text + "시")
    temp.append(float(w.find("temp").text))
    reh.append(float(w.find("reh").text))
    # print(w.find("hour").text)
    # print(w.find("temp").text)
    # print(w.find("reh").text)
    # print("----------")

# print(hour)
# print(temp)
# print(reh)

# x축에 hour 대신 indexes 입력
indexes = range(len(hour))
fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

x1 = plt.subplot() 
p1 = x1.plot(indexes, temp, "r-o")
x1.axis([None, None, None, 38])
x1.set_xlabel("시간")
x1.set_ylabel("기온")

x2 = x1.twinx() 
p2 = x2.plot(indexes, reh, "b-o")
x2.axis([None, None, 0, 100])
x2.set_ylabel("습도")
plt.title("날씨", loc="center")
x1.legend(p1 + p2, ["기온", "습도"])

# indexes를 시간 데이터로 활용
plt.xticks(indexes, hour)

plt.show()

