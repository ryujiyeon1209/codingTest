-- 코드를 입력하세요
with CAR as (
    select *
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE="SUV" or CAR_TYPE="세단"
),

HISTORY as (
    select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where CAR_ID not in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
        where START_DATE<='2022-11-30' and '2022-11-01'<=END_DATE	
    ) 
),

DISCOUNT as (
    select *
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where DURATION_TYPE="30일 이상"
)

select c.CAR_ID, c.CAR_TYPE, round((c.DAILY_FEE*((100-d.DISCOUNT_RATE)/100))*30) as FEE 
from CAR as c join HISTORY as h join DISCOUNT as d
on c.CAR_ID=h.CAR_ID and c.CAR_TYPE=d.CAR_TYPE
where 500000<=(c.DAILY_FEE*((100-d.DISCOUNT_RATE)/100))*30 and (c.DAILY_FEE*((100-d.DISCOUNT_RATE)/100))*30<2000000
order by FEE desc, c.CAR_TYPE, c.CAR_ID desc



