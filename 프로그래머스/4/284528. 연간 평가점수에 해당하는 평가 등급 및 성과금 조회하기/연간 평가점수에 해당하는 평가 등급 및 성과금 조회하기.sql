-- 코드를 작성해주세요
select EMP_NO, EMP_NAME, GRADE, 
    if(grade="S", sal*0.2, if(grade="A", sal*0.15, if(grade="B", sal*0.1, 0))) as BONUS
from(
    select e.emp_no, e.emp_name, e.sal,
        if(96<=avg(g.score), "S", if(90<=avg(g.score), "A", if(80<=avg(g.score), "B", "C"))) as grade
    from HR_DEPARTMENT as d join HR_EMPLOYEES as e join HR_GRADE as g
    where d.dept_id=e.dept_id and e.emp_no=g.emp_no
    group by e.emp_no
) as t
order by EMP_NO;