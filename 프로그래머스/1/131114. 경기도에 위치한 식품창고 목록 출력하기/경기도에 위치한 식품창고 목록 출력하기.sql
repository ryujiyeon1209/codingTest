-- 코드를 입력하세요
select warehouse_id, warehouse_name, address, if(freezer_yn is null, "N", freezer_yn) as freezer_yn
from FOOD_WAREHOUSE 
where address like "경기도%"
order by warehouse_id;