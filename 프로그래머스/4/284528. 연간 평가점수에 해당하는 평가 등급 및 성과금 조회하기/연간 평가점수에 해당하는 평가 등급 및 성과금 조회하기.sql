-- 코드를 작성해주세요
with AVG_GRADE as (
    select EMP_NO, avg(SCORE) as SCORE
    from HR_GRADE 
    group by EMP_NO
)

select e.EMP_NO, e.EMP_NAME, 
    if(96<=g.SCORE, "S", if(90<=g.SCORE, "A", if(80<=g.SCORE, "B", "C"))) as "GRADE",
    if(96<=g.SCORE, e.SAL*0.2, if(90<=g.SCORE, e.SAL*0.15, if(80<=g.SCORE, e.SAL*0.1, 0))) as "BONUS"
from AVG_GRADE as g join HR_EMPLOYEES as e
on g.EMP_NO=e.EMP_NO
order by e.EMP_NO