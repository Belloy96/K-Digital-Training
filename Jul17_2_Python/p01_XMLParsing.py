# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring

# https://www.weather.go.kr/w/rss/dfs/hr1-forecast.do?zone=1168072000

# HTTP 통신(원하는 값만 얻어오기 위해 요청을 해야하고.. 따라서 HTTP 통신이 필요..!
# https면 HTTPConnection - http.client 불러옴
#                     서버 주소까지만 담아줌
hc = HTTPSConnection("www.weather.go.kr")                       # 서버 주소
hc.request("GET", "/w/rss/dfs/hr1-forecast.do?zone=1168072000") # 요청

# 응답을 해주었으니 응답(getresponse())을 먼저 가져오고
res = hc.getresponse()      # 응답
# 응답 내용이 들어있을 것임
resBody = res.read()        # 응답 내용
# print(resBody)            # 인코딩 처리가 되어 있음을 확인 할 수 있음
# print(resBody.decode())   # 출력(한글처리)
#############################################################################
# XML Parsing
# DOM객체 여러개 찾기 : .getiterator("태그명") / .iter("태그명") / 둘 다 같은 기능, 후자가 최신
# DOM객체 하나 찾기 : .find("태그명")

# kmaWeather = fromstring(resBody)
# # print(kmaWeather)
# weathers = kmaWeather.iter("data")
# # print(weathers)
# for w in weathers:
    # print(w)
    # print("-------------")

for w in fromstring(resBody).getiterator("data"):
    print(w.find("hour").text)
    print(w.find("temp").text)
    print(w.find("wfKor").text)
    print("----------")
    
    
    
    
    
    
