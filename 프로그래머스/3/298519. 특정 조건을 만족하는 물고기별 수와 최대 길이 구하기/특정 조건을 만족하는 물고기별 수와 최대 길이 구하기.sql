-- 코드를 작성해주세요
select count(ID) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from FISH_INFO 
group by FISH_TYPE
having 33<=avg(if(LENGTH is null, 10, LENGTH))
order by FISH_TYPE