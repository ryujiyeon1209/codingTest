-- 코드를 입력하세요
with USERS as (
    select distinct USER_ID
    from USER_INFO 
    where year(JOINED) = 2021
)

select year(s.SALES_DATE) as YEAR, month(s.SALES_DATE) as MONTH,
    count(distinct s.USER_ID) as PURCHASED_USERS, 
    round(count(distinct s.USER_ID)/(select count(*) from USERS), 1) as PUCHASED_RATIO
from ONLINE_SALE as s join USERS as u
on s.USER_ID=u.USER_ID
group by year(s.SALES_DATE), month(s.SALES_DATE)
order by year(s.SALES_DATE), month(s.SALES_DATE);