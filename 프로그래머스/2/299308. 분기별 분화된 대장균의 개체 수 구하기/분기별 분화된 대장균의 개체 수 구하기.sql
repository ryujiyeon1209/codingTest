-- 코드를 작성해주세요
select quarter as QUARTER, count(id) as ECOLI_COUNT
from (
    select id, parent_id, size_of_colony, differentiation_date, genotype,
        if(1<=month(differentiation_date) and month(differentiation_date)<=3, "1Q",
        if(4<=month(differentiation_date) and month(differentiation_date)<=6, "2Q",
        if(7<=month(differentiation_date) and month(differentiation_date)<=9, "3Q", "4Q"))) as quarter   
    from ECOLI_DATA 
) as d
group by quarter
order by quarter;