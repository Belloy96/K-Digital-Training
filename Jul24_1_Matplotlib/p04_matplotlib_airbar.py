# -*- coding:utf-8 -*-

import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from http.client import HTTPConnection
from json import loads

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/
# 4f626857416f6c6c3632586a416843

hc = HTTPConnection("openapi.seoul.go.kr:8088")
u = "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/"
hc.request("GET", u)

res = hc.getresponse().read()

airData = loads(res)
# print(airData)

whereDict = {}  # {'동남권' : 3, '서북권' : 2, ... }
pm10Dict = {}   # {'동남권' : 150.0, '서북권' : 147.0, ... }
pm25Dict = {}

for a in airData["RealtimeCityAir"]["row"]:
    # print(a["MSRRGN_NM"])
    # print(a["PM10"])
    # print(a["PM25"])
    where = a["MSRRGN_NM"]
    pm10 = float(a["PM10"])
    pm25 = float(a["PM25"])
    
    if where in pm10Dict:   # 어떤 Dict로 해도 상관 없음
        pm10Dict[where] += pm10
        pm25Dict[where] += pm25
        whereDict[where] += 1
    else:
        pm10Dict[where] = pm10
        pm25Dict[where] = pm25
        whereDict[where] = 1
        
    print(pm10Dict); print(pm25Dict); print(whereDict); print("---------")
    
print('최종'); print(whereDict); print(pm10Dict); print(pm25Dict)
    
names = []
pm10s = []
pm25s = []
        
for k, v in whereDict.items():
    names.append(k)
    pm10s.append(pm10Dict[k] / v)
    pm25s.append(pm25Dict[k] / v)

print("---------------------")
print(names);   print(pm10s);   print(pm25s)

# 서북권, 도심권, 동북권, ... 의 미세먼지 / 초미세먼지
#    각각 평균값을 bar그래프로 표현 (누적합)
plt.bar(names, pm10s, color="#FFA7A7")
plt.bar(names, pm25s, color="#B2CCFF", bottom=pm10s)
plt.legend(["미세먼지", "초미세먼지"])
plt.show()




