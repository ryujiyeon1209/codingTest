-- 코드를 입력하세요
with CAR as (
    select CAR_ID, CAR_TYPE, DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE="트럭"
),

HISTORY as (
    select h.HISTORY_ID, h.CAR_ID, c.CAR_TYPE, c.DAILY_FEE,
        timestampdiff(day, START_DATE, END_DATE)+1 as TIMESTAMP,
    if(90<=timestampdiff(day, START_DATE, END_DATE)+1, "90일 이상", 
      if(30<=timestampdiff(day, START_DATE, END_DATE)+1, "30일 이상", 
        if(7<=timestampdiff(day, START_DATE, END_DATE)+1, "7일 이상", "0일 이상"))) as TYPE
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h join CAR as c
    on c.CAR_ID=h.CAR_ID
),

PLAN as (
    select h.HISTORY_ID, p.CAR_TYPE, h.TIMESTAMP, h.TYPE, 
        if(p.DISCOUNT_RATE is null, 0, p.DISCOUNT_RATE) as DISCOUNT_RATE, h.DAILY_FEE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p right join HISTORY as h
    on p.CAR_TYPE=h.CAR_TYPE and h.TYPE=p.DURATION_TYPE
)

select HISTORY_ID,
    floor((DAILY_FEE*(100-DISCOUNT_RATE))/100) *TIMESTAMP as FEE
from PLAN
order by FEE desc, HISTORY_ID desc