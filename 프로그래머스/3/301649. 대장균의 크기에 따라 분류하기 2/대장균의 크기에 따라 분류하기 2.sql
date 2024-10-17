-- 코드를 작성해주세요
with SIZE as (
    select ID, SIZE_OF_COLONY, rank() over(order by SIZE_OF_COLONY desc) as RANKING
    from ECOLI_DATA 
    order by SIZE_OF_COLONY DESC
)

select e.ID, 
    if(s.RANKING/(select count(*) from ECOLI_DATA)<=0.25, "CRITICAL", 
    if(s.RANKING/(select count(*) from ECOLI_DATA)<=0.50, "HIGH", 
    if(s.RANKING/(select count(*) from ECOLI_DATA)<=0.75, "MEDIUM", "LOW"))) as COLONY_NAME
from ECOLI_DATA as e join SIZE as s
on e.ID=s.ID
order by e.ID
