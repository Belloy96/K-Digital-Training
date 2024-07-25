# -*- coding:utf-8 -*-

# cmd => pip install pandas
#    Pandas : 데이터 조작, 분석을 쉽게 하기 위한 모듈(라이브러리)

import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import pandas as pd

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# 행과 열로 이루어진 데이터프레임(2차원 행렬)에 자료형이 담기게 됨(DB의 Table같은 느낌)
df = pd.read_csv("C:/Users/tpgns/Desktop/PyData/subwayPayFreeAns.csv", 
                 names = ['언제', '호선', '역', 'prn', 'frn', 'pan', 'fan'])

# print(df)

# groupby() : 집단, 그룹별로 데이터를 집계, 요약
df2 = df.groupby('언제').sum()
# print(df2)

plt.plot(range(df2.index.size), df2['prn'], color="#EF9A9A")
plt.plot(range(df2.index.size), df2['frn'], color="blue")
plt.plot(range(df2.index.size), df2['pan'], color="#90CAF9")
plt.plot(range(df2.index.size), df2['fan'], color="black")
plt.legend(["유임승차", "무임승차", "유임하차", "무임하차"])
plt.title("월별 지하철 유.무임 승차 정보")

# x축에 0 - 60 => 5년치, 즉 60개의 값을 가지고 있음
# ↓ 해결 방법! ↓
plt.xticks(range(df2.index.size), df2.index)
plt.show()











