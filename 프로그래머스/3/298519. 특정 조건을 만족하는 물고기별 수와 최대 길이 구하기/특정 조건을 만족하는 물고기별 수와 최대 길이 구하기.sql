-- 코드를 작성해주세요
select count(f.id) as FISH_COUNT, max(f.length) as MAX_LENGTH, f.FISH_TYPE
from (
    select id, fish_type, ifnull(length, 10) as length, time
    from FISH_INFO
) as f
group by f.fish_type
having 33<=avg(f.length)
order by f.fish_type