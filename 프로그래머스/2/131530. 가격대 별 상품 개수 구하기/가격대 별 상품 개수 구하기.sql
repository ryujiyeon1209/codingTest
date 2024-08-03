-- 코드를 입력하세요
select round(((PRICE-5000)/10000), 0)*10000 as PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT 
group by PRICE_GROUP
order by PRICE_GROUP