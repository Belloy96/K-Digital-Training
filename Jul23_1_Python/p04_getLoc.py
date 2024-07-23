# # -*- coding:utf-8 -*-
# from urllib.parse import quote
# from http.client import HTTPSConnection
# from json import loads
#
# # 651b9143fecae45b955721c5e612edf3
#
# # 좌표
# # 37.483869 / 127.084032
#
# # dapi.kakao.com
# # /v2/local/search/keyword.json?query=
# # &y=37.483869&x=127.084032&radius=10000
#
#
# # json 데이터
# # 검색어를 입력
# #    => 위도/경도 지정
# #    => 반경 1km이내에 있는
# #    => 검색어에 대한 위치 정보
#
# #    => 장소명(업체명), 전화번호, 경도, 위도
# #        place_name  phone    x    y
# #    => DB에 저장
# #    => 전화번호 : 없는 부분은 ' - ' 으로 대체
# #    => 경도, 위도 : 소수점 6자리까지
#
# location = quote(input("검색 : "))
# addr = "&x=127.084032&y=37.483869&radius=10000"
#
# hc = HTTPSConnection("dapi.kakao.com")
#
# h = {
        # "Authorization" : "KakaoAK 651b9143fecae45b955721c5e612edf3"
    # }
    #
# hc.request("GET", "/v2/local/search/keyword.json?query=" + location + addr, headers=h)
#
# res = hc.getresponse().read()
# # print(resBody)
#
# loc = loads(res)
# locs = loc["documents"]
#
# for l in locs:
    # print(l["place_name"])
    # print(l["phone"])
    # print(l["x"])
    # print(l["y"])
    # print("----------")
from urllib.parse import quote
from http.client import HTTPSConnection
from cx_Oracle import connect
from json import loads

search = quote(input("검색어 : "))
# print(search)

hc = HTTPSConnection("dapi.kakao.com")
url = f"/v2/local/search/keyword.json?query={search}&y=37.483869&x=127.084032&radius=1000"

h = {
    "Authorization" : "KakaoAK 651b9143fecae45b955721c5e612edf3"
    }

hc.request("GET", url, headers=h)

resBody = hc.getresponse().read()
print(resBody.decode())
###############################여기까지가 HTTP통신~!
# (여기에서 loc.json 파일 만들었음)-콘솔값 복붙하세요~

# DB => insert (db 테이블 만들었음/seq만들어서 프라이머리 키 만들어주기~)
con = connect("kg/8230@localhost:1521/xe") 
cur = con.cursor()
location = loads(resBody)

for l in location["documents"]:
    sql = "insert into search_location values( "
    sql += "search_location_seq.nextval, "
    sql += f"'{l['place_name']}', "
    sql += f"nvl('{l['phone']}', '-'), "
    sql += f"{float(l['x']):.6f}, "
    sql += f"{float(l['y']):.6f} )"
     
    cur.execute(sql)
    
con.commit()
con.close()
print("완료~")


