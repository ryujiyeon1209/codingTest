-- 코드를 입력하세요
select substring(product_code, 1, 2) as category, count(substring(product_code, 1, 2)) as products
from product
group by substring(product_code, 1, 2)
order by substring(product_code, 1, 2) asc;
