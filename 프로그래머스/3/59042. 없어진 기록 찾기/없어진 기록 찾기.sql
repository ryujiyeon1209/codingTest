-- 코드를 입력하세요
select outs.animal_id as ANIMAL_ID, outs.name as NAME
from ANIMAL_INS as ins right outer join ANIMAL_OUTS as outs
on ins.animal_id=outs.animal_id
where ins.intake_condition is null;

