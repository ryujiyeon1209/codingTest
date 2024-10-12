-- 코드를 작성해주세요
select number.ID, ifnull(counting.cnt, 0) as CHILD_COUNT
from ECOLI_DATA as number left join
(
    select parent.ID, count(*) as cnt
    from ECOLI_DATA as parent join ECOLI_DATA as child
    on parent.ID=child.PARENT_ID
    group by parent.ID
) as counting
on number.ID=counting.ID
order by number.ID;
