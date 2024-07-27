-- 코드를 입력하세요
select BOARD_ID, WRITER_ID, TITLE, PRICE, 
    if(STATUS="SALE", "판매중", if(STATUS="RESERVED", "예약중", "거래완료")) as STATUS
from USED_GOODS_BOARD 
where date_format(created_date, "%Y")="2022"
    and date_format(created_date, "%m")="10" and date_format(created_date, "%d")="05"
order by board_id desc;
