-- 코드를 입력하세요
select m.member_name as MEMBER_NAME, r.review_text as REVIEW_TEXT, 
    date_format(r.review_date, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as m join REST_REVIEW as r
where m.member_id=r.member_id and
    m.member_id = (
        select member_id
        from REST_REVIEW 
        group by member_id
        order by count(review_id) desc
        limit 1
)
order by r.review_date, r.review_text;