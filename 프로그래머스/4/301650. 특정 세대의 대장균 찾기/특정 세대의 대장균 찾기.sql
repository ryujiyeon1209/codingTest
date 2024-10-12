-- 코드를 작성해주세요
select child.ID
from (
    select ID
    from ECOLI_DATA
    where PARENT_ID is null
) as  grand
join ECOLI_DATA as parent join ECOLI_DATA as child 
on grand.ID=parent.PARENT_ID and parent.ID=child.PARENT_ID
order by child.ID