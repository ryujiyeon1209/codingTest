-- 코드를 입력하세요
select distinct c.car_id
from car_rental_company_car as c join car_rental_company_rental_history as h
where c.car_id = h.car_id and
    c.car_type = "세단" and date_format(start_date, "%m") = "10"
order by c.car_id desc; 


