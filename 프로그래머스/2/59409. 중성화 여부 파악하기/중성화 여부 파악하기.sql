-- 코드를 입력하세요
select animal_id, name,
    if(sex_upon_intake like "%Neutered%" or sex_upon_intake like "%Spayed%", "O", "X") as "중성화"
from animal_ins;