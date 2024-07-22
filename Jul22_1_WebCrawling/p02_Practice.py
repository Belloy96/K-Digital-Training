# -*- coding:utf-8 -*-
import urllib.request as req
from urllib.error import HTTPError, URLError

# 저장 경로 - list 형식으로 !

urlList = ["https://upload3.inven.co.kr/upload/2021/09/02/bbs/i16072863835.jpg", 
           "http://www.google.com"]

pathList = ["C:/Users/tpgns/Desktop/PyData/Crawling/mokoko2.png", 
            "C:/Users/tpgns/Desktop/PyData/Crawling/index.html"]

# enumerate를 사용하면 인덱스까지 알 수 있음!
for i, url in enumerate(urlList):
    # 예외처리
    try:
        # web의 수신정보를 확인(하기 전에 import로 request 불러옴)
        res = req.urlopen(url)
    
        # 수신받는 내용
        content = res.read()
        print("----------------------")    
    
        # 상태정보 확인
        print(f"헤더 정보 : {i, res.info()}")
        print(f"http status : {res.getcode()}")
        print("----------------------")    
    
        # 파일 쓰기
        # with : 파일을 열고, 닫는거 같이 해주는 역할(close 함수 사용할 필요 x)
        with open(pathList[i], "wb") as f:    # 'b' : binary mode(이진)
            f.write(content)
    
    # HTTPError -> urllib    
    except HTTPError as e:
        print("HTTPError Code : ", e.code)
    except URLError as e:
        print("URLError Code : ", e.code)
    else:
        print("----------------------")    
        print("성공 !")
        print("----------------------")    






