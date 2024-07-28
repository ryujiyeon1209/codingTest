-- 코드를 입력하세요
select outs.animal_id as ANIMAL_ID, outs.name as NAME
from ANIMAL_OUTS as outs left outer join ANIMAL_INS as ins 
on outs.animal_id=ins.animal_id
where ins.animal_id is null
order by outs.animal_id;


