-- 코드를 입력하세요
select i.rest_id as REST_ID, i.rest_name as REST_NAME, i.food_type as FOOD_TYPE, 
    i.favorites as FAVORITES, i.address as ADDRESS, round(avg(r.review_score), 2) as SCORE
from REST_INFO as i join REST_REVIEW as r
where i.rest_id=r.rest_id 
    and i.address like "서울%"
group by rest_id
order by SCORE desc, i.favorites desc;