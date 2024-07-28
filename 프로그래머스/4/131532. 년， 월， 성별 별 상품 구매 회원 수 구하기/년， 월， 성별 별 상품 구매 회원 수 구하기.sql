-- 코드를 입력하세요
select year(sales_date) as YEAR, month(sales_date) as MONTH, u.gender as GENDER, count(distinct(s.user_id)) as USERS
from USER_INFO as u join ONLINE_SALE as s
where u.user_id=s.user_id
    and u.gender is not null
group by year(sales_date), month(sales_date), u.gender
order by year(sales_date), month(sales_date), u.gender
