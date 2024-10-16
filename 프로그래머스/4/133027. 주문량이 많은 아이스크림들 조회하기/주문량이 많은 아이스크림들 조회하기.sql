-- 코드를 입력하세요
with ICECREAM as (
    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from FIRST_HALF 

    union all

    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from JULY 
)

select FLAVOR
from ICECREAM
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3;
