-- 코드를 입력하세요
select USER_ID, PRODUCT_ID
from ONLINE_SALE 
group by USER_ID, PRODUCT_ID
having 2<=count(ONLINE_SALE_ID)
order by USER_ID, PRODUCT_ID desc
