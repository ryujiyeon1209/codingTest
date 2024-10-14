-- 코드를 입력하세요
with WRITER as (
    select WRITER_ID 
    from USED_GOODS_BOARD 
    group by WRITER_ID
    having 3<=count(BOARD_ID)
)

select u.USER_ID, u.NICKNAME, concat(u.CITY, " ", u.STREET_ADDRESS1, " ", u.STREET_ADDRESS2) as "전체주소",
    concat(substring(u.TLNO, 1, 3), "-", substring(u.TLNO, 4, 4), "-", substring(u.TLNO, 8, 4)) as "전화번호"
from WRITER as w join USED_GOODS_USER as u
on w.WRITER_ID=u.USER_ID
order by u.USER_ID desc;
