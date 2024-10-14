-- 코드를 입력하세요
with recursive TIME as (
    select 0 as HOUR
    
    union all
    
    select hour+1 as HOUR
    from TIME 
    where HOUR<23
)

select t.HOUR, count(o.ANIMAL_ID) as COUNT
from TIME as t left join ANIMAL_OUTS as o
on t.HOUR=hour(o.DATETIME) 
group by t.HOUR