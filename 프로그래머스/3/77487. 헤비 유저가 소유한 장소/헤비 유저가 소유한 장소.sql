-- 코드를 입력하세요
select ID, NAME, HOST_ID
from PLACES 
where host_id in (
    select host_id
    from PLACES
    group by host_id
    having 2<=count(*)
)
order by id;