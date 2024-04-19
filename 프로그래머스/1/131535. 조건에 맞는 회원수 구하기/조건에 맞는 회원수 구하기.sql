-- 코드를 입력하세요
select count(user_id) as users
from user_info
where 20<=age and age<=29 and
substring(date_format(joined, "%Y"), 1, 4)=2021;