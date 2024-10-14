-- 코드를 작성해주세요
with AVGSCORE as (
    select EMP_NO, avg(SCORE) as ASCORE
    from HR_GRADE  
    group by EMP_NO
) 

select e.EMP_NO, e.EMP_NAME,
    if(96<=s.ASCORE, "S", if(90<=s.ASCORE, "A", if(80<=s.ASCORE, "B", "C"))) as GRADE,
    if(96<=s.ASCORE, SAL*0.2, if(90<=s.ASCORE, SAL*0.15, if(80<=s.ASCORE, SAL*0.1, 0))) as BONUS
from HR_EMPLOYEES as e join AVGSCORE as s
on e.EMP_NO=s.EMP_NO
order by e.EMP_NO;