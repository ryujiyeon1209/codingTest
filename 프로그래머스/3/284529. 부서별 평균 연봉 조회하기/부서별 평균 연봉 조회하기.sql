-- 코드를 작성해주세요
select d.dept_id as DEPT_ID, d.dept_name_en as DEPT_NAME_EN, round(avg(e.sal), 0) as AVG_SAL
from HR_DEPARTMENT as d join HR_EMPLOYEES as e
where d.dept_id=e.dept_id
group by e.dept_id
order by AVG_SAL desc;

