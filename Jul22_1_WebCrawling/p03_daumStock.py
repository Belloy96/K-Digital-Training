# -*- coding:utf-8 -*-
from fake_useragent.fake import UserAgent
import urllib.request as req
from json import loads
# 어떤 브라우저는 get, post방식을 요청을 하는 상대방이 컴퓨터인 것을 알게 되면
#    해당 웹에 접속하는 것을 차단하는 경우가 있음!
#        => '나 컴퓨터 아니야!' 라고 '사람인 척'을 하기 위해서 어떤 라이브러리를 사용
# fake-useragent (라이브러리)
#    cmd => pip install fake-useragent
# fake header 정보(가상으로 User-agent 랜덤 생성)
# Python으로 정보를 크롤링하지만, 브라우저쪽에서는 마치 웹브라우저에서 실행하는 것처럼 인식하게끔 만들것임!
ua = UserAgent()
# print(ua.ie)
# print(ua.msie)
# print(ua.chrome)
# print(ua.safari)
# print(ua.random)

# 헤더 선언 : dict 형태로(key, value)
h = {
        "User-Agent" : ua.chrome,
        "referer": "https://finance.daum.net/"  # 이 경로를 통해서 왔다!!
    }

# 다음 금융(주식) 요청 URL
url = "https://finance.daum.net/api/search/ranks?limit=10"

# 요청(하기 전에 urllib.request 불러오기)
res = req.urlopen(req.Request(url, headers=h)).read().decode()

# 응답 데이터 확인
# print('res : ', res)

# 응답 데이터 => python
stockData = loads(res)
# print(stockData)

stocks = stockData["data"]

# 순위, 주식명, 거래가를 콘솔에 출력
for s in stocks:
    print(f"순위: {s['rank']}, 이름: {s['name']}, 거래가: {s['tradePrice']}")
    # print(s['rank'])
    # print(s['name'])
    # print(s['tradePrice'])
    print("---------")    








