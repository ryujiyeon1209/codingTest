-- 코드를 입력하세요
select ins.animal_id as ANIMAL_ID, ins.animal_type as ANIMAL_TYPE, ins.name as NAME
from ANIMAL_INS as ins join ANIMAL_OUTS as outs
where ins.animal_id=outs.animal_id
    and ins.sex_upon_intake like "Intact%" 
    and (outs.sex_upon_outcome like "Neutered%" or outs.sex_upon_outcome like "Spayed%")
order by ins.animal_id;