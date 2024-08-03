-- 코드를 입력하세요
select date_format(DATETIME, "%k") as HOUR, count(ANIMAL_ID) as COUNT
from ANIMAL_OUTS 
where date_format(DATETIME, "%H") between "09" and "19" 
group by HOUR
order by date_format(DATETIME, "%H");