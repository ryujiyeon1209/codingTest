-- 코드를 작성해주세요
select e.emp_no as EMP_NO, e.emp_name as EMP_NAME, 
    if(96<=avg(g.score), "S", if(90<=avg(g.score), "A", if(80<=avg(g.score), "B", "C"))) as GRADE,
    if(96<=avg(g.score), sal*0.2, if(90<=avg(g.score), sal*0.15, if(80<=avg(g.score), sal*0.1, 0))) as BONUS
from HR_DEPARTMENT as d join HR_EMPLOYEES as e join HR_GRADE as g
where d.dept_id=e.dept_id and e.emp_no=g.emp_no
group by e.emp_no
order by EMP_NO;