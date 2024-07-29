-- 코드를 작성해주세요
select count(id) as COUNT
from ECOLI_DATA
where genotype&2=0
    and (genotype&1!=0 or genotype&4!=0);