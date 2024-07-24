data_count = 0
target_date = "2021,01,01"
target_date2 = "2021,01,02"

with open("C:/Users/tpgns/Desktop/PyData/busData_2021.csv", "r", encoding="UTF-8") as f:
    for line in f:
        if line.startswith(target_date):
            data_count += 1
        elif line.startswith(target_date2):
            break
print(f"2021년 01월 01일의 데이터 개수: {data_count}개")





