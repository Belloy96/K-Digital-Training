# -*- coding:utf-8 -*-

import numpy as np
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

xData = np.array([1, 2, 3, 4])
yData = np.array([12, 31, 7, 24])
yData2 = np.array([1, 51, 23, 10])

c = ['#FFB2D9', '#D941C5', '#B5B2FF', '#FFC19E']

# plt.bar(xData, yData, width=0.5, edgecolor="#670000", linewidth=5, color=c)
# plt.show()

# 여러 항목
# align="edge" : 막대의 기본 x축 위치에서 왼쪽 끝에 눈금 표시
# plt.bar(xData, yData, color="#FFC19E", width=0.3, align="edge")
# width에 -(음수)를 붙이면 정렬(눈금 표시가)이 오른쪽
# plt.bar(xData, yData2, color="#B5B2FF", width=-0.3, align="edge")
# data에 -(음수)를 붙이면 바로 위의 그래프의 옆으로 이동하게
# plt.bar(xData - 0.3, yData2, color="#FFB2D9", width=-0.3, align="edge")
# plt.show()

# 누적합
plt.bar(xData, yData, color="#B5B2FF")
plt.bar(xData, yData2, color="#FFC19E", bottom=yData)
plt.show()








