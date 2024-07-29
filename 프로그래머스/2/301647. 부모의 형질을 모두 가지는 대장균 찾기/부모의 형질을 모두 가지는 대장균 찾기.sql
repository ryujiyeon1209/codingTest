-- 코드를 작성해주세요
select e.id as ID, e.genotype as GENOTYPE, p.genotype as PARENT_GENOTYPE
from ECOLI_DATA as e join ECOLI_DATA as p
where e.parent_id=p.id
    and e.genotype&p.genotype=p.genotype
order by id;