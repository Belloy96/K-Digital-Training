# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring
from json import loads

# 42008a8c8e7402a3fc9d3b1a7df8fee9 -> API key

# https://api.openweathermap.org/data/2.5/weather?q={city name}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr

# 도시 이름 : 입력 (영어)
# 요청파라미터 추가 O
# 응답 내용 출력까지

cityName = input("city : ")

hc = HTTPSConnection("api.openweathermap.org")
u = "/data/2.5/weather?q=%s&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr" % cityName
hc.request("GET", u)

resBody = hc.getresponse().read()
# print(resBody.decode())   # 여기까지가 HTTP통신
                            # 여기까지 만들고 file 생성. 확장자 주의!
# loads - json__init__
weatherData = loads(resBody)# JS => Python
# print(weatherData)

# dict : {"key" : "value"}
# list : [1, 2, 3] => 인덱스 값으로 
l = [1, 2, 3]                       # python : list / JS에서 [] : array(배열)
d = {"name" : "홍길동", "age" : 30}   # python : dict / JS에서 {} : object(객체)
#######################################################################
# 날씨 / 기온 / 체감기온 / 습도 / 바람속도
# weather - description / main - temp / main - feels_like / main - humidity / wind - speed
# 데이터를 콘솔창에 출력
# dict / list 잘 확인하면서!

# 단 하나의 데이터 O => 반복문이 필요없음 !

print(weatherData["weather"][0]["description"])
print(weatherData["main"]["temp"])
print(weatherData["main"]["feels_like"])
print(weatherData["main"]["humidity"])
print(weatherData["wind"]["speed"])

