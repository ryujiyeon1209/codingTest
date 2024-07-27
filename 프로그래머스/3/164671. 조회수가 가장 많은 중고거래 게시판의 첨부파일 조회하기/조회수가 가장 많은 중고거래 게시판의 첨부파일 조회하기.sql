-- 코드를 입력하세요
select concat("/home/grep/src/", f.board_id, "/", f.file_id, f.file_name, f.file_ext) as FILE_PATH
from USED_GOODS_FILE as f
where f.board_id = (
        select b.board_id
        from USED_GOODS_BOARD as b
        order by b.views desc
        limit 1)
order by f.file_id desc;