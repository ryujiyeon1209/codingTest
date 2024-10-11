-- 코드를 입력하세요
select h.FLAVOR
from FIRST_HALF as h join ICECREAM_INFO as i 
on h.FLAVOR = i.FLAVOR
where 3000<=h.TOTAL_ORDER and i.INGREDIENT_TYPE="fruit_based"
order by h.TOTAL_ORDER desc;