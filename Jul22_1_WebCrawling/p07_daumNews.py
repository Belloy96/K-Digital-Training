# -*- coding:utf-8 -*-
from bs4 import BeautifulSoup
import requests
from urllib.parse import quote

# https://search.daum.net/search?w=news&q=
# &enc=utf8&cluster=y&cluster_page=1&DA=DNS
# &enc=utf8&cluster=y&cluster_page=1&DA=PGD&p=
# #dnsColl > div:nth-child(1) > ul > li:nth-child(1) > div.c-item-content > div.item-bundle-mid > div.item-title > strong > a


# 검색어 콘솔에 입력
# 요청했을때 나오는 결과 1 ~ 5페이지까지 뉴스 제목을 출력

def getTitle(address, q):
    for i in range(1, 6):
        print(f"====================== {i} 페이지 =======================")
        
        addr = address + q
        addr += f"&enc=utf8&cluster=y&cluster_page=1&DA=PGD&p={i}"
        
        res = requests.get(addr)
        
        soup = BeautifulSoup(res.text, 'html.parser')
        
        # 강사님 답안
        # ul = soup.select_one("ul.c-list-basic")
        # news = ul.select("li:nth-child(1) > div.c-item-content > div.item-bundle-mid > div.item-title > strong > a")
        # news = ul.select("li > div > div > div > strong > a")
        
        news = soup.select('strong > a')
        
        for n in news:
            print(n.text)
            
address = "https://search.daum.net/search?w=news&q="
q = quote(input("검색어 입력 : "))

getTitle(address, q)
    
