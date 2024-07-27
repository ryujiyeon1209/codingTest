-- 코드를 입력하세요
select HISTORY_ID, CAR_ID, date_format(start_date, '%Y-%m-%d') as START_DATE, 
    date_format(end_date, "%Y-%m-%d") as END_DATE,
    if(29<=timestampdiff(day, start_date, end_date), "장기 대여", "단기 대여") as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as c
where start_date between '2022-09-01' and '2022-09-30'
order by history_id desc;