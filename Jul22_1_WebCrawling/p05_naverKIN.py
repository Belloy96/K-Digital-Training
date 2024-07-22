# -*- coding:utf-8 -*-
from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# https://kin.naver.com/search/list.naver?query=

# 검색했을 때 글 제목만 가져오기!

q = quote(input("검색어 : "))
# print(q)

url = f"https://kin.naver.com/search/list.naver?query={q}"

# cmd => pip install requests
# requests : 간편하게 HTTP 요청하기 위해서 사용하는 모듈

# 요청이 오면 응답을 할 변수하나 만들고... / 이때 requests 자동완성은 모듈모양!!
response = requests.get(url)      # get() : GET방식 요청
# print(response.status_code)     # 성공했다면 200 나옴!

if response.status_code == 200:
    html = response.text
    # print(html)
    soup = BeautifulSoup(html, 'html.parser')
    
    # select_one을 사용할 경우 : 문서의 처음부터 찾게 되며,
    #                        가장 처음에 만나는 해당 selector(선택자)를 호출함
    ul = soup.select_one('ul.basic1')   # class명으로 접근
    
    # #s_content > div.section > ul > li:nth-child(1) > dl > dt > a (개발자 모드에서 해당 태그 우클릭 - Copy)
    # select를 사용할 경우 : 해당하는 selector(선택자)들의 모든 내용이 list에 담긴다
    # > : 그 하위에 있는 selector(선택자)들을 전부 다
    titles = ul.select('li > dl > dt > a')  # 여러개 찾기 위해 select()함수
    
    # List에 들어가기때문에 반복문을 사용해야함!
    for title in titles:
        print(title.text)
    
else:
    print(response.status_code)






