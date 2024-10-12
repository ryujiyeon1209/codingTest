-- 코드를 입력하세요
# select c.CAR_ID, c.CAR_TYPE, h.START_DATE, h.END_DATE
# from CAR_RENTAL_COMPANY_CAR as c join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
# on c.CAR_ID=h.CAR_ID
# where c.CAR_TYPE="세단" or c.CAR_TYPE="SUV"
#     and ('2022-11-30'<h.START_DATE or h.END_DATE<'2022-11-01')
  
  

with CAR as (
    select CAR_ID, CAR_TYPE, DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE="세단" or CAR_TYPE="SUV"
),

FEES as (
    select CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE like "30%"
)


select  c.CAR_ID, c.CAR_TYPE, round((c.DAILY_FEE*((100-f.DISCOUNT_RATE)/100))*30) as FEE
from FEES as f join CAR as c
on f.CAR_TYPE=c.CAR_TYPE
where (c.DAILY_FEE*((100-f.DISCOUNT_RATE)/100))*30 between 500000 and 2000000
    and c.CAR_ID not in (
        select h.CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
        where h.START_DATE<='2022-11-30' and '2022-11-01'<=h.END_DATE
)
order by FEE desc, c.CAR_TYPE, c.CAR_ID desc;


