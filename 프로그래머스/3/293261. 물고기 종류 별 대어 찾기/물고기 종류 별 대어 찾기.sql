-- 코드를 작성해주세요
with len as (
    select FISH_TYPE, max(LENGTH) as mlen
    from FISH_INFO 
    WHERE LENGTH is not null
    group by FISH_TYPE
)

select f.ID, n.FISH_NAME, f.LENGTH
from FISH_INFO as f join FISH_NAME_INFO as n join len
on f.FISH_TYPE=n.FISH_TYPE and f.FISH_TYPE=len.FISH_TYPE 
where f.LENGTH=len.mlen