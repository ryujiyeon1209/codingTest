-- 코드를 입력하세요
select distinct  c.car_id, c.car_type, round(c.daily_fee*((100-d.discount_rate)/100)*30) as fee
 
from car_rental_company_car as c
join car_rental_company_rental_history as h
on c.car_id=h.car_id
join car_rental_company_discount_plan as d
on c.car_type = d.car_type

where
c.car_type in ('세단', 'SUV')
and
d.duration_type='30일 이상'
and
c.car_id not in(
    select car_id
    from car_rental_company_rental_history 
    where end_date > '2022-11-01' and start_date < '2022-12-01'
)
group by c.car_id
having fee between 500000 and 1999999
order by fee desc, car_type asc, car_id desc