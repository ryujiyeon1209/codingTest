-- 코드를 입력하세요
select i.flavor
from(
    select flavor, sum(total_order) as TOTAL_ORDER
    from FIRST_HALF 
    group by flavor
    union all
    select flavor, sum(total_order) as TOTAL_ORDER
    from JULY 
    group by flavor
) as i
group by i.flavor
order by sum(total_order) desc
limit 3;
