-- 코드를 작성해주세요
select count(id) as COUNT
from ECOLI_DATA
where conv(genotype, 10, 2) & 2 = 0
    and (conv(genotype, 10, 2) & 1 != 0 or conv(genotype, 10, 2) & 4 != 0);