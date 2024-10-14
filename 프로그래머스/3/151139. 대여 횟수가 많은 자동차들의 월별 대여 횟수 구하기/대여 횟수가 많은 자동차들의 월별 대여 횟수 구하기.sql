-- 코드를 입력하세요
with CAR as (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where "2022-08-01"<=START_DATE and START_DATE<="2022-10-31"  
        group by CAR_ID
        having 5<=count(CAR_ID)
)

select month(START_DATE) as MONTH, h.CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h join CAR as c
on h.CAR_ID=c.CAR_ID
where month(START_DATE)=8 or month(START_DATE)=9 or month(START_DATE)=10
group by month(START_DATE), h.CAR_ID
order by MONTH, CAR_ID desc


