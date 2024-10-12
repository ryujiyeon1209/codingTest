-- 코드를 입력하세요
select p.PRODUCT_ID, p.PRODUCT_NAME, sum(AMOUNT)*PRICE as TOTAL_SALES
from FOOD_PRODUCT as p join FOOD_ORDER as o
on p.PRODUCT_ID=o.PRODUCT_ID
where year(PRODUCE_DATE)=2022 and month(PRODUCE_DATE)=5
group by p.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID