-- 코드를 입력하세요
select CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
from CAR_RENTAL_COMPANY_CAR as car
where options like "%네비게이션%"
order by car_id desc;