-- 코드를 입력하세요
select substring(PRODUCT_CODE, 1, 2) as CATEGORY, count(PRODUCT_ID) as PRODUCTS
from PRODUCT 
group by CATEGORY
order by CATEGORY