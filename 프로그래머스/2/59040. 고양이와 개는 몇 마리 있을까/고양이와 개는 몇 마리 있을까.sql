-- 코드를 입력하세요
select ANIMAL_TYPE, count(*) as count
from ANIMAL_INS 
where ANIMAL_TYPE="Dog" or ANIMAL_TYPE="Cat"
group by ANIMAL_TYPE
order by ANIMAL_TYPE