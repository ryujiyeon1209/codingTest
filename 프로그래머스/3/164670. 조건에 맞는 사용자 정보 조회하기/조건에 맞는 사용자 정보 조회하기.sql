-- 코드를 입력하세요
select u.user_id as USER_ID, nickname as NICKNAME, 
    concat(u.city, " ", u.street_address1, " ", u.street_address2) as 전체주소, 
    concat(substring(tlno, 1, 3), "-", substring(tlno, 4, 4), "-", substring(tlno, 8, 4))as 전화번호
from USED_GOODS_BOARD as b right outer join USED_GOODS_USER as u
on b.writer_id=u.user_id
group by u.user_id
having 3<=count(b.title)
order by u.user_id desc;
