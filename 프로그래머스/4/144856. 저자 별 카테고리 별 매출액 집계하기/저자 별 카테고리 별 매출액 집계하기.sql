-- 코드를 입력하세요
select b.AUTHOR_ID, a.AUTHOR_NAME,  b.CATEGORY, sum(s.SALES*b.PRICE) as TOTAL_SALES
from BOOK_SALES as s join BOOK as b join AUTHOR as a
on s.BOOK_ID=b.BOOK_ID and b.AUTHOR_ID=a.AUTHOR_ID
where year(s.SALES_DATE)=2022 and month(s.SALES_DATE)=1
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID, b.CATEGORY desc