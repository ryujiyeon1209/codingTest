-- 코드를 작성해주세요
select ecoli.ID, if(nrank.num/total.counting<=0.25, "CRITICAL", if(nrank.num/total.counting<=0.50, "HIGH",                      if(nrank.num/total.counting<=0.75, "MEDIUM", "LOW"))) as COLONY_NAME
from ECOLI_DATA as ecoli join (
    select ID, SIZE_OF_COLONY, 
        row_number() over (order by SIZE_OF_COLONY desc) as num
    from ECOLI_DATA
) as nrank join (
    select count(*) as counting
    from ECOLI_DATA
) as total
on nrank.ID=ecoli.ID


# select count(*)
# from ECOLI_DATA