-- 코드를 작성해주세요
select child.ID, child.GENOTYPE as GENOTYPE, parent.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as child join ECOLI_DATA as parent
on parent.ID = child.PARENT_ID
where child.GENOTYPE&parent.GENOTYPE=parent.GENOTYPE
order by child.ID