-- 코드를 입력하세요
select u.user_id as USER_ID, u.nickname as NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD as b join USED_GOODS_USER as u 
where b.writer_id=u.user_id and b.status="DONE"
group by u.user_id
having 700000<=sum(price)
order by sum(price);
