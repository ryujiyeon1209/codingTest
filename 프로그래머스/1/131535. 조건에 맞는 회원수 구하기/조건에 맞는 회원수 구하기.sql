-- 코드를 입력하세요
select count(USER_ID) as USERS
from USER_INFO 
where date_format(JOINED, "%Y")=2021 and AGE between 20 and 29;