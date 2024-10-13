-- 코드를 입력하세요
with totalSales as (
    select PRODUCT_ID, sum(SALES_AMOUNT) as TOTAL
    from OFFLINE_SALE 
    group by PRODUCT_ID
)

select p.PRODUCT_CODE, (p.PRICE*t.TOTAL) as SALES
from PRODUCT as p join totalSales as t
on p.PRODUCT_ID = t.PRODUCT_ID
order by SALES desc, p.PRODUCT_CODE;

