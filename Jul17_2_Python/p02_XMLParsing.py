# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from urllib.parse import quote
from urllib import request
from xml.etree.ElementTree import fromstring

# dev.naver.com -> Application -> 내 어플리케이션 -> 이름 클릭 후 값 가져오기
# obLGF990TYmxpeiDEmMu
# YYrUajKoJI

# Documents -> 서비스 API -> 검색 -> 쇼핑
# https://openapi.naver.com/v1/search/shop.xml

# 상품명 : 입력
# xml 파싱해서
# 문서의 상품 이름 / 최저가 / 브랜드 / 대분류 카테고리 정보를 출력

q = input("상품명 : ")
# 주소값에 한글이 들어갈 수 없으니
# URLEncoding해서 주소로 넘겨줄 것 / quote - urllib.parse
q = quote(q)
print(q)

# 상품명 강조를 위해 <b>태그가 생성되는데 이를 삭제하는 함수 생성
def cut(t):
    t = t.replace("<b>", "").replace("</b>", "")
    return t

# naver 요청헤더 request를 잘 이용해 보아라~~
hc = HTTPSConnection("openapi.naver.com")
# request 함수의 body
#    : 요청할 때 데이터를 보내야 하는 경우에 body에 담아서 보냄
h = {
        "X-Naver-Client-Id" : "obLGF990TYmxpeiDEmMu",
        "X-Naver-Client-Secret" : "YYrUajKoJI"
    }

hc.request("GET", "/v1/search/shop.xml?query=" + q, headers=h)

# res = hc.getresponse()
# resBody = res.read()
resBody = hc.getresponse().read()
# print(resBody.decode())

# XML Parsing
# DOM객체 여러개 찾기 : .getiterator("태그명") / .iter("태그명") / 둘 다 같은 기능, 후자가 최신
# DOM객체 하나 찾기 : .find("태그명")

for s in fromstring(resBody).iter("item"):
    print(cut(s.find("title").text))
    print(s.find("lprice").text)
    print(s.find("brand").text)
    print(s.find("category1").text)
    print("----------")
