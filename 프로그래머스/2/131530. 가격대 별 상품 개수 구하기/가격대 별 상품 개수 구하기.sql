-- 코드를 입력하세요
select floor((PRICE/10000))*10000 as PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT 
group by PRICE_GROUP
order by PRICE_GROUP