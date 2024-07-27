-- 코드를 입력하세요
select date_format(sales_date, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where sales_date between '2022-03-01' and '2022-03-31'
union
select date_format(sales_date, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
from OFFLINE_SALE 
where sales_date between '2022-03-01' and '2022-03-31'
order by sales_date, product_id, USER_ID;