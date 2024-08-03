-- 코드를 입력하세요
select ANIMAL_ID, NAME, date_format(DATETIME, "%Y-%m-%d") as "날짜"
from ANIMAL_INS as ins
order by ANIMAL_ID;