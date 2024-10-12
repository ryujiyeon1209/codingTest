-- 코드를 작성해주세요
with maxSize as (
    select year(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as smax
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
)

select m.YEAR, (m.SMAX-e.SIZE_OF_COLONY) as YEAR_DEV, e.ID
from ECOLI_DATA as e join maxSize as m
on year(e.DIFFERENTIATION_DATE)=m.YEAR
order by m.YEAR, YEAR_DEV