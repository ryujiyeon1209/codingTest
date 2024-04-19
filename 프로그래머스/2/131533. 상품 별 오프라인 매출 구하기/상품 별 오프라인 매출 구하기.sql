-- 코드를 입력하세요
select p.product_code, (p.price * sum(o.sales_amount)) as sales
from product as p  join offline_sale as o
where p.product_id = o.product_id
group by o.product_id
order by sales desc, p.product_code asc;