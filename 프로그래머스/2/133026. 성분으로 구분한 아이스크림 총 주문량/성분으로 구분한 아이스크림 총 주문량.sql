-- 코드를 입력하세요
select i.INGREDIENT_TYPE, sum(h.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF as h join ICECREAM_INFO as i
on h.FLAVOR=i.FLAVOR
group by i.INGREDIENT_TYPE
order by TOTAL_ORDER