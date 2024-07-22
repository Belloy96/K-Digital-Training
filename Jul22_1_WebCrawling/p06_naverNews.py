# -*- coding:utf-8 -*-
from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# 검색어를 입력했을 때,
# url 주소 뒤에 요청 파라미터로 start=숫자를 넣으면 
# 관련 뉴스 내용 5페이지까지의 뉴스 제목들을 콘솔에 출력

# https://search.naver.com/search.naver?ssc=tab.news.all&where=news&sm=tab_jum&query=
# #sp_nws1 > div.news_wrap.api_ani_send > div > div.news_contents > a.news_tit


# 강사님 답안
def getTitle(address, q):
    for i in range(0, 5):
        # 1페이지 : 1 ~ 10 / 2페이지 : 11 ~ 30 / 3페이지 : 21 ~ 30 / ...
        print(f"====================== {i + 1} 페이지 =======================")
        start = 10 * i + 1 # 1 / 11 / 21 / 31 / 41
        addr = address + q
        addr += "&sm=tab_tmr&nso=so:r,p:all,a:all&sort=0&start=" + str(start)
        res = requests.get(addr)
        
        soup = BeautifulSoup(res.text, 'html.parser')
        
        news = soup.select('.news_tit')
        
        for n in news:
            print(n.text)

q = quote(input("검색어 입력 : "))
address = "https://search.naver.com/search.naver?where=news&query="

getTitle(address, q)
