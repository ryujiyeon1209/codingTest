-- 코드를 입력하세요
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, ifnull(FREEZER_YN, 'N') as FREEZER_YN
from FOOD_WAREHOUSE as f
where address like "%경기도%"
order by WAREHOUSE_ID;