-- 코드를 입력하세요
select a.author_id as AUTHOR_ID, a.author_name as AUTHOR_NAME, b.category as CATEGORY, sum(b.price*s.sales) as TOTAL_SALES
from BOOK as b join AUTHOR  as a join BOOK_SALES as s
where b.book_id=s.book_id and b.author_id=a.author_id
    and s.sales_date between '2022-01-01' and '2022-01-31'
group by a.author_id, b.category
order by a.author_id, b.category desc;