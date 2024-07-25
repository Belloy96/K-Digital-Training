# -*- coding:utf-8 -*-

# 방금 만든 csv파일 불러와서
#    연월에 맞춰서 => 유임승차,무임승차,유임하차,무임하차 (전체 합)
#    => 선 그래프 그리기 ! # 복습필요

import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
from p01_getSubwayPayFree import when

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# 유/무임승/하차 Dict 생성
prnDict, frnDict, panDict, fanDict = {}, {}, {}, {}

with open("C:/Users/tpgns/Desktop/PyData/subwayPayFreeAns.csv", "r", encoding="UTF-8") as f:
    for line in f.readlines():
        # print(line)
        line = line.replace("\n", "").split(",")
        # print(line)
        when = line[0]
        prn = float(line[3]); frn = float(line[4])
        pan = float(line[5]); fan = float(line[6])
        
        if when in prnDict: # 어떤 값이 들어와도 상관 x
            prnDict[when] += prn
            frnDict[when] += frn
            panDict[when] += pan
            fanDict[when] += fan
        else:
            prnDict[when] = prn
            frnDict[when] = frn
            panDict[when] = pan
            fanDict[when] = fan
            
print(when)
print(prnDict)
print(frnDict)
print(panDict)
print(fanDict)

whens, prns, frns, pans, fans = [], [], [], [], []
for k, v in prnDict.items():    # 어떤 Dict를 상관 없으나 이 Dict에 해당하는 것으로 다다음줄 작성
    whens.append(k)
    prns.append(v)
    frns.append(frnDict[k])
    pans.append(panDict[k])
    fans.append(fanDict[k])
print("------------------")    
print(whens)    
print(prns)    
print(frns)    
print(pans)    
print(fans)    
    
plt.plot(whens, prns, color="#EF9A9A")
plt.plot(whens, frns, color="blue")
plt.plot(whens, pans, color="#90CAF9")
plt.plot(whens, fans, color="black")
plt.legend(["유임승차", "무임승차", "유임하차", "무임하차"])
plt.title("월별 지하철 유.무임 승차 정보")
plt.show()
   
