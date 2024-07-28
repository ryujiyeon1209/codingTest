-- 코드를 입력하세요
select b.writer_id as USER_ID, u.nickname as NICKNAME, sum(b.price) as TOTAL_SALES
from USED_GOODS_BOARD as b join USED_GOODS_USER as u
where b.writer_id=u.user_id
    and b.status="DONE"
group by b.writer_id
having 700000<=sum(b.price)
order by TOTAL_SALES;