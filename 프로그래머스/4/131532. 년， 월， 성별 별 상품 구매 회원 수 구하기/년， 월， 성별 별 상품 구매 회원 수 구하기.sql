-- 코드를 입력하세요
select year(s.SALES_DATE) as YEAR, month(s.SALES_DATE) as MONTH, 
    u.GENDER, count(distinct u.USER_ID) as USERS
from USER_INFO  as u join ONLINE_SALE as s
on u.USER_ID=s.USER_ID
where u.GENDER is not null
group by year(s.SALES_DATE), month(s.SALES_DATE), u.GENDER
order by year(s.SALES_DATE), month(s.SALES_DATE), u.GENDER
