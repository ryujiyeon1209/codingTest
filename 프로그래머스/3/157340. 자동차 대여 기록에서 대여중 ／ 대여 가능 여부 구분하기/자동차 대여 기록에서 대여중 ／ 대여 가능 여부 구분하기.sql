-- 코드를 입력하세요

with AVAIL as (
    select CAR_ID, "대여중" as AVAILABILITY
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where START_DATE<="2022-10-16" and "2022-10-16"<=END_DATE
)

select distinct h.CAR_ID, if(a.AVAILABILITY is null, "대여 가능", a.AVAILABILITY) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h left join AVAIL as a
on h.CAR_ID=a.CAR_ID
order by h.CAR_ID desc;
