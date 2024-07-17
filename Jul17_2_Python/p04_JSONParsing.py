# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from urllib.parse import quote
from json import loads

# 651b9143fecae45b955721c5e612edf3
# https://dapi.kakao.com/v3/search/book

# 책 이름 검색해서 책 제목 - 작가 / 할인가 / 도서 소개 출력
# Authorization: KakaoAK 651b9143fecae45b955721c5e612edf3 

book = input("책 검색 : ")
book = quote(book)
hc = HTTPSConnection("dapi.kakao.com")

k = {
        "Authorization" : "KakaoAK 651b9143fecae45b955721c5e612edf3"
    }

hc.request("GET", "/v3/search/book?query=" + book, headers=k)

resBody = hc.getresponse().read()
# print(resBody.decode())

bookData = loads(resBody)   # JS -> Python
books = bookData["documents"]

for b in books:
    # print(b["title"], "-", b["authors"][0]) 저자가 0번째에 있는 사람만 나오는 상황..!
    print(b["title"], "-", ", ".join(b["authors"]))
                            # .join() : list를 문자열로 만들 때 사용
                            # 구분자.join() : list의 요소들을 지정한 구분자로 나눠
                            #                 하나의 문자열로 합쳐줌
                            # ex) ", ".join(b['a', 'b', 'c']) => a, b, c
    print(b["sale_price"])
    print(b["contents"])
    print("--------------------")
    
# print(bookData["documents"][0]["title"])
# print(bookData["documents"][0]["authors"][0])
# print(bookData["documents"][0]["sale_price"])
# print(bookData["documents"][0]["contents"])




