-- 코드를 입력하세요
select t.FLAVOR
from (
    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from FIRST_HALF 
    union all
    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from JULY
) as t
group by t.FLAVOR
order by sum(t.TOTAL_ORDER) desc
limit 3;