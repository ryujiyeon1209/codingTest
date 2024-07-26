-- 코드를 작성해주세요
select count(f.fish_type) as FISH_COUNT, n.fish_name as FISH_NAME
from FISH_INFO as f join FISH_NAME_INFO as n 
where f.fish_type=n.fish_type 
group by n.fish_name
order by count(f.fish_type) desc;

