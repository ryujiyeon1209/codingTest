-- 코드를 작성해주세요
select count(f.ID) as FISH_COUNT, n.FISH_NAME
from FISH_INFO as f join FISH_NAME_INFO as n
on f.FISH_TYPE=n.FISH_TYPE
group by n.FISH_NAME
order by FISH_COUNT desc