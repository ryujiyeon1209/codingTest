-- 코드를 작성해주세요
select count(id) as FISH_COUNT
from FISH_INFO as f
where f.length is null;