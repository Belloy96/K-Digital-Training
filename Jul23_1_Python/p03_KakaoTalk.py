# -*- coding:utf-8 -*-

import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

# 카카오톡 내용 정제
# ㅋ : ?, ㅎ : ?, ㅠ : ?, ? : ?, ! : ? => pie차트로 나타내보기!

# with open("C:/Users/tpgns/Desktop/PyData/kakaotalk.txt", "r", encoding="UTF-8") as f:
    # wc = {"ㅋ": 0, "ㅎ": 0, "ㅠ": 0, "?": 0, "!": 0}
    # for line in f.readlines():
        # line = line.replace("\n", "").split(" : ")  # " : " 앞 뒤로 두 부분으로 나누어짐
        # if len(line) == 2:  # 두 요소로 나뉘어 진다면,
            # for w in line[-1]:  # 뒤쪽에 있는 내용이 곧 내화내용
                # # print(w)    # 대화 내용을 한 글자씩 쪼갬
                # if w in wc: # w가 명시되어있는 key 값이라면, value값을 1씩 올리기
                    # wc[w] += 1
# print(wc)

# 대화 내용에 " : " 가 들어가 있다면 ?
with open("C:/Users/tpgns/Desktop/PyData/kakaotalk.txt", "r", encoding="UTF-8") as f:
    wc = {"ㅋ": 0, "ㅎ": 0, "ㅠ": 0, "?": 0, "!": 0}
    for line in f.readlines():
        line = line.replace("\n", "")
        if " : " in line:
            lines = line.split(" : ", 1) # 첫번째 " : " 에서만 분리
            if len(lines) == 2:
                dialog = lines[-1]
                for w in dialog:
                    if w in wc:
                        wc[w] += 1
            
print(wc)

word = []
count = [] # key와 value를 따로 담을 빈 list 생성

for k, v in wc.items():
    word.append(k)
    count.append(v)

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

c = ['#BBDDCC', '#B2CCFF', '#FFA7A7', '#E5DDFF', '#DDFFFF']
w = {'width' : 0.7, 'edgecolor': 'black', 'linewidth' : 5} # 테두리 설정

plt.pie(count, labels=word, autopct="%.2f%%", wedgeprops=w) # wedgeprops = 테두리 / autopct 그 단어가 차지하고 있는 비율
plt.title('카톡 단어 사용량')
plt.show()






