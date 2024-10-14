-- 코드를 작성해주세요
with SCORES as (
    select EMP_NO, sum(SCORE) as SCORE
    from HR_GRADE 
    group by EMP_NO
    order by SCORE desc
    limit 1
)

select s.SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from SCORES as s join HR_EMPLOYEES as e
on s.EMP_NO=e.EMP_NO



