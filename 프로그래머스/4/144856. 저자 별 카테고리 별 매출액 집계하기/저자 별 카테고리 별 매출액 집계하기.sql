-- 코드를 입력하세요
select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.SALES*b.PRICE) as TOTAL_SALES
from BOOK_SALES as s join BOOK as b join AUTHOR as a
on s.BOOK_ID=b.BOOK_ID and a.AUTHOR_ID=b.AUTHOR_ID
where year(s.SALES_DATE)=2022 and month(s.SALES_DATE)=1
group by a.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc;
