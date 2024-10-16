-- 코드를 입력하세요
with MILK as (
    select distinct CART_ID, NAME
    from CART_PRODUCTS
    where NAME="Milk"
),

YOGURT as (
    select distinct CART_ID, NAME
    from CART_PRODUCTS
    where NAME="Yogurt"
)

select distinct m.CART_ID
from MILK as m join YOGURT as y
on m.CART_ID=y.CART_ID
order by CART_ID
