-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO as info join FISH_NAME_INFO as name
on info.FISH_TYPE=name.FISH_TYPE
where name.FISH_NAME="BASS" or name.FISH_NAME="SNAPPER";