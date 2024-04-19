-- 코드를 입력하세요
select date_format(datetime, "%H") as hour, count(animal_id) as count
from animal_outs
where 9<=date_format(datetime, "%H") and date_format(datetime, "%H")<=19
group by date_format(datetime, "%H")
order by date_format(datetime, "%H") asc;
