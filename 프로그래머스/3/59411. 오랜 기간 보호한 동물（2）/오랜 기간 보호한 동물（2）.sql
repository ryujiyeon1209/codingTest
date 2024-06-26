-- 코드를 입력하세요
select  i.animal_id, i.name
from animal_ins as i left join animal_outs as o
    on i.animal_id = o.animal_id
where o.animal_id is not null
order by datediff(o.datetime, i.datetime) desc
limit 2;