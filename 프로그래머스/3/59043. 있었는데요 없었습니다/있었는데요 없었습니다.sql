-- 코드를 입력하세요
select ins.animal_id as ANIMAL_ID, ins.name as NAME
from ANIMAL_INS as ins join ANIMAL_OUTS as outs
where ins.animal_id=outs.animal_id
    and outs.datetime<ins.datetime
order by ins.datetime;