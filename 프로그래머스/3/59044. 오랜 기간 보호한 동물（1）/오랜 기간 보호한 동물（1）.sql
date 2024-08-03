-- 코드를 입력하세요
select ins.NAME as NAME, ins.DATETIME as DATETIME
from ANIMAL_INS as ins left outer join ANIMAL_OUTS as outs
on ins.ANIMAL_ID=outs.ANIMAL_ID
where outs.ANIMAL_ID is null
order by ins.DATETIME
limit 3;