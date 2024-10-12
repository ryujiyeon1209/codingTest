-- 코드를 작성해주세요
with recursive generation as (
    select id, 1 as gen
    from ECOLI_DATA 
    where PARENT_ID is null
    
    union

    select e.id, gen+1
    from ECOLI_DATA as e join generation g
    on e.parent_id=g.id
)

select count(*) as COUNT, g.gen as GENERATION
from generation as g left join ECOLI_DATA as e
on e.parent_id=g.id
where e.id is null
group by g.gen
