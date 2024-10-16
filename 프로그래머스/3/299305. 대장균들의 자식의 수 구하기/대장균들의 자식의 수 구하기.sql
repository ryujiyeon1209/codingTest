-- 코드를 작성해주세요
with COUNT_CHILD as (
    select parent.ID, count(child.ID) as CNT
    from ECOLI_DATA as parent join ECOLI_DATA as child
    on parent.ID=child.PARENT_ID
    group by parent.ID
)

select e.ID, if(c.CNT is null, 0, c.CNT) as CHILD_COUNT
from ECOLI_DATA as e left join COUNT_CHILD as c
on e.ID=c.ID
order by e.ID
