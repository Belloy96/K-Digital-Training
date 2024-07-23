# -*- coding:utf-8 -*-

# Python의 시각화를 위한 library - matplotlib
# cmd => pip install matplotlib

# 두 가지 기능 불러오기
import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

name = []
count = []

with open("C:/Users/tpgns/Desktop/PyData/tkResult.csv", "r", encoding="UTF-8") as f:
    for line in f.readlines():
        # print(line)
        line = line.replace("\n", "").split(",")
        name.append(line[0])
        count.append(int(line[1]))  # 기본 문자열이기때문에 int로 형변환

# print(name, count)

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# 막대그래프 - 절대적인 값 비교
c = ['#00CCFF', '#B2CCFF', '#FFA7A7']
# plt.bar(name, count, width=0.4, color=c) # (x, y, 두께, 색상)
# plt.title('Three Kingdoms')
# plt.xlabel('name')  # x축 설명
# plt.ylabel('count') # y축 설명
# plt.xticks(range(len(name)), name)  # 눈금 설정
# plt.show()        

# 파이차트 (pie)
plt.pie(count, labels=name, colors=c, shadow=True, explode=(0.1, 0.1, 0.1))
# explode : 각 항목이 원점에서 튀어나오는 정도
plt.title('Three Kindoms')
plt.show()









