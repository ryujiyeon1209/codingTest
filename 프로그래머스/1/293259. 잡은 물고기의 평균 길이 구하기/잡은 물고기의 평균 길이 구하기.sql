-- 코드를 작성해주세요
select round(avg(if(length is null, 10, length)), 2) as AVERAGE_LENGTH
from FISH_INFO;
