-- 코드를 입력하세요
select count(distinct(name)) as count
from ANIMAL_INS as ins
where name is not null;
