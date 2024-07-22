# -*- coding:utf-8 -*-
from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# 가수, 노래 제목을 직접 입력해서 요청
# 노래 가사에 대한 내용을 출력

# https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=
# %EB%B9%85%EB%B1%85+%ED%95%98%EB%A3%A8%ED%95%98%EB%A3%A8+%EA%B0%80%EC%82%AC
# #main_pack > div.sc_new.cs_common_module._au_music_content_wrap.case_empasis.color_16 > div.cm_content_wrap > div.cm_content_area._cm_content_area_song_lyric > div > div.intro_box > p

def getLyrics(address, singer, title):
    dec = "%EA%B0%80%EC%82%AC"
    
    addr = address +'+'+ singer +'+'+ title +'+'+ dec
    
    res = requests.get(addr)
    
    soup = BeautifulSoup(res.text, 'html.parser')
    
    div = soup.select_one("div.intro_box")
    lyrics = div.select('p')
    
    for l in lyrics:
        print(l.text)

singer = quote(input("가수 : "))
title = quote(input("제목 : "))
address = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query="

getLyrics(address, singer, title)

# 강사님 답안
# artist = quote(input("artist : "))
# title = quote(input("title : "))
# url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8"
# url += f"&query={artist}+{title}+%EA%B0%80%EC%82%AC"
# response = requests.get(url)
# if response.status_code == 200:
#    html = response.text
#    soup = BeautifulSoup(html, 'html.parser')
#    lyrics = soup.select_one('#main_pack > div.sc_new.cs_common_module._au_music_content_wrap.case_empasis.color_16 > div.cm_content_wrap > div.cm_content_area._cm_content_area_song_lyric > div > div.intro_box > p')
#    print(lyrics.text)
# else:
#    print(response.status_code)
