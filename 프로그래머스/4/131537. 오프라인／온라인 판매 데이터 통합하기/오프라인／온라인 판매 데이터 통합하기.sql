-- 코드를 입력하세요
select date_format(ons.SALES_DATE, "%Y-%m-%d") as SALES_DATE,
    ons.PRODUCT_ID, ons.USER_ID, ons.SALES_AMOUNT
from ONLINE_SALE as ons
where year(ons.SALES_DATE)=2022 and month(ons.SALES_DATE)=3
union
select date_format(off.SALES_DATE, "%Y-%m-%d") as SALES_DATE,
    off.PRODUCT_ID, null as USER_ID, off.SALES_AMOUNT
from OFFLINE_SALE as off
where year(off.SALES_DATE)=2022 and month(off.SALES_DATE)=3
order by SALES_DATE, PRODUCT_ID, USER_ID;
