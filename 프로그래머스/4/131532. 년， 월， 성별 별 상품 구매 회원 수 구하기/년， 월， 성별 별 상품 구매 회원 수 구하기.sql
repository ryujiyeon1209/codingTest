-- 코드를 입력하세요
select  year(o.SALES_DATE) as YEAR, month(o.SALES_DATE) as MONTH,
    u.GENDER as GENDER,  count(distinct(o.user_id)) as USERS
from ONLINE_SALE as o join USER_INFO as u
where o.user_id = u.user_id
    and u.GENDER is not null
group by year(o.SALES_DATE), month(o.SALES_DATE), u.GENDER
order by YEAR, MONTH, GENDER;