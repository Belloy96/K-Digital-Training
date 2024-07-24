# -*- coding:utf-8 -*-

import matplotlib.pyplot as plt
import numpy as np

# 동일한 순서로 난수를 발생시키기 위해서 'seed'라는 것을 난수에 부여
np.random.seed(0)

n = 50
# 0 ~ 1범위의 난수를 50개 생성
x = np.random.rand(n)
y = np.random.rand(n)
##################################################
# < 기본 >
# x, y 데이터를 순서대로 scatter() 함수에 입력을 하면
#    => 해당 위치(좌표)에 마커가 표시됨 (산점도, 분포도)
# plt.scatter(x, y)
# plt.show()
##################################################
# < 마커 크기, 색상 >
# area = (30 * np.random.rand(n)) ** 2
# colors = np.random.rand(n)  # rgb, hexcode 색상을 지정
                            # # 0 ~ 1까지의 숫자를 임의의 색으로 지정을 하게 됨
# plt.scatter(x, y, s=area, c=colors)
# plt.show()
##################################################
# < 투명도, 컬러맵 >
# area = (30 * np.random.rand(n)) ** 2
# colors = np.random.rand(n)
#
# # alpha : 마커의 투명도 (0 ~ 1) / cmap : 컬러맵(colormap)에 해당하는 문자열을 지정
# import matplotlib.cm
# print(matplotlib.cm._colormaps) # cmap종류 !
# plt.scatter(x, y, s=area, c=colors, alpha=0.5, cmap='Spectral')
# plt.colorbar()
# plt.show()
##################################################
# 다차원 랜덤 배열 생성
np.random.seed(0)
arr = np.random.standard_normal((8, 100)) # (8, 100) 형태의 난수 array
# print(arr)

plt.subplot(2, 2, 1)    # 2 x 2 size 중에서 1번째 라는 뜻임!
plt.scatter(arr[0], arr[1], c=arr[1])
plt.spring()
plt.title('Spring')

plt.subplot(2, 2, 2)
plt.scatter(arr[2], arr[3], c=arr[3])
plt.summer()
plt.title('Summer')

plt.subplot(2, 2, 3)
plt.scatter(arr[4], arr[5], c=arr[5])
plt.autumn()
plt.title('Autumn')

plt.subplot(2, 2, 4)
plt.scatter(arr[6], arr[7], c=arr[7])
plt.winter()
plt.title('Winter')

plt.tight_layout() # 자동으로 여백에 관련된 파라미터를 조정


plt.show()
