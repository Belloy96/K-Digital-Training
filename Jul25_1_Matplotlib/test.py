# -*- coding:utf-8 -*-

data_count = 0
target_date = "201901"
target_date2 = "201902"

with open("C:/Users/tpgns/Desktop/PyData/subwayPayFree.csv", "r", encoding="UTF-8") as f:
    for line in f:
        if line.startswith(target_date):
            data_count += 1
        elif line.startswith(target_date2):
            break
print(f"{data_count}")

























