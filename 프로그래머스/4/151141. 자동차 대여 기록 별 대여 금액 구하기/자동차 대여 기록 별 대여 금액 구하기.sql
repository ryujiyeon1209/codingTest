-- 코드를 입력하세요
with CAR as (
    select *
    from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE="트럭"
)
,
HISTORY as (
    select h.HISTORY_ID, c.CAR_ID, c.CAR_TYPE, timestampdiff(day, h.START_DATE, h.END_DATE)+1 as DAY,
        if(90<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "90일 이상", 
        if(30<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "30일 이상", 
        if(7<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "7일 이상", "N"))) as DAYS,
        c.DAILY_FEE
    from CAR as c join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h 
    on c.CAR_ID=h.CAR_ID
)
,
DISCOUNT as (
    select h.HISTORY_ID, h.CAR_ID, h.CAR_TYPE, h.DAY, h.DAYS, h.DAILY_FEE, 
        if(d.DISCOUNT_RATE is null, 0, d.DISCOUNT_RATE) as DISCOUNT_RATE
    from HISTORY as h left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d
    on h.CAR_TYPE=d.CAR_TYPE and h.DAYS=d.DURATION_TYPE
)

select HISTORY_ID, round((DAILY_FEE*((100-DISCOUNT_RATE)/100))) * DAY as FEE
from DISCOUNT
order by FEE desc, HISTORY_ID desc





