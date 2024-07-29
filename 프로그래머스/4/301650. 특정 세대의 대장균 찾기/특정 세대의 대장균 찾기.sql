-- 코드를 작성해주세요
select e.id as ID
from ECOLI_DATA as e join ECOLI_DATA as d join ECOLI_DATA as p
where e.parent_id=d.id and d.parent_id=p.id
    and e.id is not null and p.parent_id is null
