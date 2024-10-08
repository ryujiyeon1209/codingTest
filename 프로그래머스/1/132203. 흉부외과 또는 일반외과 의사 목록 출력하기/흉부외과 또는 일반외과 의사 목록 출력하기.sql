-- 코드를 입력하세요
select dr_name, dr_id, mcdp_cd, date_format(hire_ymd, '%Y-%m-%d') as hire_ymd
from DOCTOR 
where MCDP_CD="CS" or MCDP_CD="GS"
order by hire_ymd desc, dr_name;