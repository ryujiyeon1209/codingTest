-- 코드를 입력하세요
select h.history_id as HISTORY_ID, round(day*(c.daily_fee*((100-ifnull(d.discount_rate, 0))/100)), 0) as FEE
from CAR_RENTAL_COMPANY_CAR as c  join (
    select history_id, car_id, timestampdiff(day, START_DATE, END_DATE)+1 as day,
        if(90<=timestampdiff(day, START_DATE, END_DATE)+1, "90일 이상",
        if(30<=timestampdiff(day, START_DATE, END_DATE)+1, "30일 이상",
        if(7<=timestampdiff(day, START_DATE, END_DATE)+1, "7일 이상", "0일 이상"))) as duration
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
) as h 
on c.car_id=h.car_id 
left outer join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d
on c.car_type=d.car_type and d.duration_type=h.duration 
where c.car_type="트럭"
order by FEE desc, HISTORY_ID desc;