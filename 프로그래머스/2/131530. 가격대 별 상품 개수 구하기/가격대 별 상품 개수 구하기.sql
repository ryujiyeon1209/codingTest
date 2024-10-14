-- 코드를 입력하세요
select floor(PRICE/10000)*10000 as PRICES, count(PRODUCT_ID) as PRODUCTS
from PRODUCT 
group by PRICES
order by PRICES