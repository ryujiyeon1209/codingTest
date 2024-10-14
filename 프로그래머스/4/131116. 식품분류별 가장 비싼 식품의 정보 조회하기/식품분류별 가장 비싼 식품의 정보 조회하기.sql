-- 코드를 입력하세요

select CATEGORY, PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where CATEGORY in ( '과자', '국', '김치', '식용유') and (CATEGORY, PRICE) in (
    select CATEGORY, max(PRICE) as MAX_PRICE
    from FOOD_PRODUCT 
    group by CATEGORY
)
order by PRICE desc;

