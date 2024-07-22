# -*- coding:utf-8 -*-
from bs4 import BeautifulSoup

# Beautiful Soup
#    파이썬에서 사용할 수 있는 웹데이터 크롤링 라이브러리
# cmd => pip install bs4

htmlEx = """
<html>
<head>
<meta charset="UTF-8">
<title>우리는 bs4로 Web Crawling을 할거에요!</title>
</head>
<body>
<h1>다들 월요일이고, 비가 많이와서 힘드시겠지만</h1>
<h2>조금만 더 힘내보아요 !</h2>
<p><b>BeautifulSoup</b></p>
<p>Python에서 Crawling할 때 유용하게 사용할 수 있는 Library
<a href="#">구글</a>
<a href="#">네이버</a>
<a href="#">유튜브</a>
</p>
<p>How to use bs4</p>
</body>
</html>
"""

# bs4 초기화(객체만들기 / 만들어 놓은 html, 'html.parser')
# html.parser : HTML 문법 규칙에 따른 문자열, 해당 문법을 바탕으로
#                단어의 의미나 구조를 분석하는 프로그램
soup = BeautifulSoup(htmlEx, 'html.parser')

# print(soup)

# 코드 예쁘게 정리하기 - prettify()
# print(soup.prettify())

# title부분 찾기
title = soup.html.head.title
print(title) # title의 태그까지
print(title.string) # 1. title의 내용만 -> string 
print(title.text) # 2. title의 내용만 -> text
print(title.getText()) # 3. title의 내용만 -> getText()
print("------------------------------------")

# h1 태그 텍스트 출력
h1 = soup.html.body.h1
print(h1)
print(h1.string)
print(h1.text)
print("------------------------------------")

# p태그
p1 = soup.html.body.p
print(p1)
print(p1.string)
print(p1.text)
print("------------------------------------")

# next_sibling : 동일한 레벨 상의 다음 요소를 불러올 수 있는 기능
#     <-> previous_sibling(반대개념)
# 밑의 3줄로만 하면 결과가 출력되지 않았음. why?
# 태그와 태그 사이에 개행이 있는 경우(<p>, ...), 엔터 처리로 취급함...
#    => bs4가 하나의 요소로 인식을 함
# p2 = p1.next_sibling
p2 = p1.next_sibling.next_sibling   # <= next_sibling을 한 번더 입력!
print(p2)
print(p2.text)









