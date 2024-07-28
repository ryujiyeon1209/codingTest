-- 코드를 작성해주세요
select i.id as ID, n.fish_name as FISH_NAME, i.length as LENGTH
from FISH_INFO as i join FISH_NAME_INFO as n
on i.fish_type = n.fish_type
where (i.fish_type, i.length) in (
    select fish_type, max(length)
    from FISH_INFO
    group by fish_type
)
order by i.id;

