-- 코드를 입력하세요
select f.flavor
from first_half as f join icecream_info as i
where f.flavor = i.flavor and
    3000 < f.total_order and i.ingredient_type = "fruit_based"
order by f.total_order desc;
