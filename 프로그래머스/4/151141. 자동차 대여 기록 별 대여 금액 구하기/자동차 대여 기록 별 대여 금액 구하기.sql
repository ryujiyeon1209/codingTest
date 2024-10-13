-- 코드를 입력하세요
with TRUCK as (
    select c.CAR_ID, c.CAR_TYPE, h.HISTORY_ID, c.DAILY_FEE, timestampdiff(day, h.START_DATE, h.END_DATE)+1 as RENTDAY,
    if(90<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "90일 이상", 
      if(30<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "30일 이상",
        if(7<=timestampdiff(day, h.START_DATE, h.END_DATE)+1, "7일 이상", "N"))) as DURATION_TYPES
    from CAR_RENTAL_COMPANY_CAR as c join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.CAR_ID=h.CAR_ID
    where c.CAR_TYPE="트럭"
)

select t.HISTORY_ID, 
round((t.DAILY_FEE*(1-(ifnull(d.DISCOUNT_RATE, 0)/100)))*t.RENTDAY, 0) as FEE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d right join TRUCK as t
on d.CAR_TYPE=t.CAR_TYPE and d.DURATION_TYPE=t.DURATION_TYPES
order by FEE desc, t.HISTORY_ID desc;