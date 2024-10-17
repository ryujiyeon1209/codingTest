-- 코드를 작성해주세요
with STDEV as (
    select year(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as MSIZE
    from ECOLI_DATA 
    group by year(DIFFERENTIATION_DATE)
)

select s.YEAR, (s.MSIZE-e.SIZE_OF_COLONY) as YEAR_DEV, e.ID
from ECOLI_DATA as e join STDEV as s
on year(e.DIFFERENTIATION_DATE)=s.YEAR
order by s.YEAR,  (s.MSIZE-e.SIZE_OF_COLONY)