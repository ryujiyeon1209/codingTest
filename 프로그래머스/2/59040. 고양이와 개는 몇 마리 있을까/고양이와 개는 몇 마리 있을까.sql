-- 코드를 입력하세요
select animal_type, count(animal_id) as count
from animal_ins
group by animal_type 
having animal_type = "Cat" or animal_type = "Dog"
order by animal_type asc;