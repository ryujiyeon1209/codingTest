-- 코드를 입력하세요
select b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(b.PRICE*s.SALES) as TOTAL_SALES
from BOOK as b join AUTHOR as a join BOOK_SALES as s
on b.AUTHOR_ID=a.AUTHOR_ID and b.BOOK_ID=s.BOOK_ID
where year(s.SALES_DATE)=2022 and month(s.SALES_DATE)=1
group by a.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID, b.CATEGORY desc