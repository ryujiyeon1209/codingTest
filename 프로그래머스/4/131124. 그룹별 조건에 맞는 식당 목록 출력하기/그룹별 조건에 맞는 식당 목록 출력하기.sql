-- 코드를 입력하세요

# with maxCount as (
#     select count(r.REVIEW_ID)
#     from MEMBER_PROFILE as m join REST_REVIEW as r
#     on m.MEMBER_ID = r.MEMBER_ID
#     group by m.MEMBER_ID
#     order by count(r.REVIEW_ID) desc
#     limit 1
# )

select m.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as m join REST_REVIEW as r 
on m.MEMBER_ID = r.MEMBER_ID
where m.MEMBER_ID in (
    select m.MEMBER_ID
    from MEMBER_PROFILE as m join REST_REVIEW as r 
    on m.MEMBER_ID = r.MEMBER_ID
    group by m.MEMBER_ID
    having count(r.REVIEW_ID) = (
        select count(*)
        from MEMBER_PROFILE as m join REST_REVIEW as r
        on m.MEMBER_ID = r.MEMBER_ID
        group by m.MEMBER_ID
        order by count(*) desc
        limit 1
    )
)
order by REVIEW_DATE, REVIEW_TEXT


