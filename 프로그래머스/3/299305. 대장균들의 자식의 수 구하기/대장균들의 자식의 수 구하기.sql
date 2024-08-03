-- 코드를 작성해주세요
select c.id, if(p.parent_id is null, 0, count(c.id)) as CHILD_COUNT
from ECOLI_DATA as c left outer join ECOLI_DATA as p
on c.id = p.parent_id
group by c.id
order by c.id;