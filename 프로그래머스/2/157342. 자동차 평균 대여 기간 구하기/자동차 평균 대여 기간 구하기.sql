-- 코드를 입력하세요
select CAR_ID, round(avg(timestampdiff(day, start_date, end_date)+1), 1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as c
group by car_id
having 7<=avg(timestampdiff(day, start_date, end_date)+1)
order by AVERAGE_DURATION desc, car_id desc;


