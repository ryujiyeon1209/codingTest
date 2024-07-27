-- 코드를 작성해주세요
select sum(g.score) as SCORE, e.emp_no as EMP_NO, e.emp_name as EMP_NAME, e.position as POSITION, e.email as EMAIL
from HR_DEPARTMENT as d join HR_EMPLOYEES as e join HR_GRADE as g
where d.dept_id=e.dept_id and e.emp_no=g.emp_no
group by g.emp_no
order by SCORE desc
limit 1;
