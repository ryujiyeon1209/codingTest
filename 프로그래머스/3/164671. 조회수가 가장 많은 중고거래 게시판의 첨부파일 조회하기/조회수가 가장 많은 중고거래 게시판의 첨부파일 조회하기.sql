-- 코드를 입력하세요
select concat("/home/grep/src/", b.board_id, "/", f.FILE_ID, f.FILE_NAME, f.FILE_EXT) as FILE_PATH
from USED_GOODS_FILE as f join (
    select board_id
    from USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
) as b
where b.board_id=f.board_id
order by f.FILE_ID desc;