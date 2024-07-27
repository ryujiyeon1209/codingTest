-- 코드를 입력하세요
select p.product_id as PRODUCT_ID, p.product_name as PRODUCT_NAME, (p.price*sum(o.amount)) as TOTAL_SALES
from FOOD_PRODUCT as p join FOOD_ORDER as o
where p.product_id=o.product_id
    and o.produce_date between '2022-05-01' and '2022-05-31'
group by o.product_id
order by TOTAL_SALES desc, PRODUCT_ID;
