# -- 코드를 입력하세요
select rest.FOOD_TYPE, rest.REST_ID, rest.REST_NAME, rest.FAVORITES
from REST_INFO as rest join (
    select FOOD_TYPE, max(FAVORITES) as FAVORITES
    from REST_INFO
    group by FOOD_TYPE
) as info
where rest.FOOD_TYPE=info.FOOD_TYPE and rest.FAVORITES=info.FAVORITES
order by rest.FOOD_TYPE desc;
