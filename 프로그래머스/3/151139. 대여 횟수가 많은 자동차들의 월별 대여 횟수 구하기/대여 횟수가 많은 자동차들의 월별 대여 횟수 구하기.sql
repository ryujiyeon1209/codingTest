-- 코드를 입력하세요
select month(start_date) as MONTH, car_id as CAR_ID, count(history_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-10-31'
    and car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date between '2022-08-01' and '2022-10-31'
        group by car_id
        having 5<=count(history_id)
    )
group by month(start_date), car_id
order by month(start_date), car_id desc;
