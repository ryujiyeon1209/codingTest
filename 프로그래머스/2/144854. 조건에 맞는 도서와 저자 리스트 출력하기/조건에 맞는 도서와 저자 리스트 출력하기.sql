-- 코드를 입력하세요
select b.book_id, a.author_name, date_format(b.published_date, "%Y-%m-%d") as published_date
from book as b join author as a
where b.author_id = a.author_id 
    and b.category = "경제"
order by published_date asc
