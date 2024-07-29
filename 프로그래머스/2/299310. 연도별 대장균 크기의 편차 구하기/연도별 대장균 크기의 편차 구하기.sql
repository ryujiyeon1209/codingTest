-- 코드를 작성해주세요
select year(e.differentiation_date) as YEAR, d.max_size-e.size_of_colony as YEAR_DEV, e.id as ID
from ECOLI_DATA as e join (
    select year(differentiation_date) as year, max(size_of_colony) as max_size
    from ECOLI_DATA
    group by year(differentiation_date)
) as d
where year(e.differentiation_date)=d.year
order by YEAR, YEAR_DEV;

