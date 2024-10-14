-- 코드를 입력하세요
select hour(DATETIME) as HOUR, count(ANIMAL_ID) as COUNT
from ANIMAL_OUTS 
where 9<=hour(DATETIME) and hour(DATETIME)<=19
group by hour(DATETIME)
order by hour(DATETIME)

