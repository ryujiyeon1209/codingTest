-- 코드를 입력하세요
select cart_id
from CART_PRODUCTS
where name="Milk" or name="Yogurt"
group by cart_id
having 2<=count(distinct(name))
order by cart_id;
