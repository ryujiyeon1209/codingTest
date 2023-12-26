-- 코드를 입력하세요
select o.animal_id, o.name from animal_outs as o join animal_ins as i 
where o.animal_id=i.animal_id and o.datetime<i.datetime 
order by i.datetime asc 