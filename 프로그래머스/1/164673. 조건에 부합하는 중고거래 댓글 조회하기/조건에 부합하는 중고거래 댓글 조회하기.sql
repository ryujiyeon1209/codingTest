-- 코드를 입력하세요
select b.title as TITLE, b.board_id as BOARD_ID, r.reply_id as REPLY_ID, r.writer_id as WRITER_ID, 
    r.contents as CONTENTS, date_format(r.created_date, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD as b join USED_GOODS_REPLY as r
where b.board_id=r.board_id
    and b.created_date between '2022-10-01' and '2022-10-31'
order by r.created_date, b.title; 