-- 코드를 입력하세요
with CAR as (
    select CAR_ID, CAR_TYPE, DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE='세단' or CAR_TYPE='SUV'
),

PLAN as (
    select c.CAR_ID, c.CAR_TYPE, c.DAILY_FEE, p.DISCOUNT_RATE
    from CAR as c join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
    where c.CAR_TYPE=p.CAR_TYPE and p.DURATION_TYPE="30일 이상"
)

select CAR_ID, CAR_TYPE,
    ceil((DAILY_FEE*(100-DISCOUNT_RATE))/100)*30 as FEE
from PLAN
where CAR_ID not in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
    where START_DATE<="2022-11-30" and "2022-11-01"<=END_DATE
)
and 500000<=ceil((DAILY_FEE*(100-DISCOUNT_RATE))/100)*30
and ceil((DAILY_FEE*(100-DISCOUNT_RATE))/100)*30<2000000
order by FEE desc, CAR_TYPE, CAR_ID desc
