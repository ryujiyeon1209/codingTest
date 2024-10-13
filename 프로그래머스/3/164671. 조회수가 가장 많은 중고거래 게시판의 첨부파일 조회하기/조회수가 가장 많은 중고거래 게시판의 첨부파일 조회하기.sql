-- 코드를 입력하세요
with maxView as (
    select BOARD_ID
    from USED_GOODS_BOARD 
    order by VIEWS desc
    limit 1
)

select concat("/home/grep/src/", b.BOARD_ID, "/", f.FILE_ID, f.FILE_NAME, f.FILE_EXT) as FILE_PATH
from maxView as b join USED_GOODS_FILE as f
on b.BOARD_ID = f.BOARD_ID
order by f.FILE_ID desc;