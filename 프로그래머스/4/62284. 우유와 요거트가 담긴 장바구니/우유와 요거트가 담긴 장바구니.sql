-- 코드를 입력하세요
select CART_ID
from CART_PRODUCTS 
where NAME="Yogurt" or NAME="Milk"
group by cart_id
having 2<=count(distinct NAME)
order by CART_ID;