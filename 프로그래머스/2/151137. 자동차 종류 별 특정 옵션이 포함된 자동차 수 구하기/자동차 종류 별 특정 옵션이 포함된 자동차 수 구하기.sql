-- 코드를 입력하세요
select car_type, count(car_id) as cars
from car_rental_company_car
where options like "%시트%"
group by car_type
order by car_type asc;
