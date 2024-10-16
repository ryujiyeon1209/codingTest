-- 코드를 작성해주세요
select f.ID, n.FISH_NAME, f.LENGTH
from FISH_INFO as f join FISH_NAME_INFO as n
on f.FISH_TYPE=n.FISH_TYPE
where (f.FISH_TYPE, f.LENGTH) in (
    select n.FISH_TYPE, max(f.LENGTH) as LENGTH
    from FISH_INFO as f join FISH_NAME_INFO as n
    on f.FISH_TYPE=n.FISH_TYPE
    group by n.FISH_TYPE
)
order by f.ID

