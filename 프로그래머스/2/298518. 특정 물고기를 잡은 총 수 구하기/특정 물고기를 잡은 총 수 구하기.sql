-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO as f join FISH_NAME_INFO as n
where f.fish_type=n.fish_type
    and (n.fish_name="BASS" or n.fish_name="SNAPPER");