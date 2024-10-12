-- 코드를 작성해주세요
with parent as (
    select i.ITEM_ID as PARENT_ID, t.ITEM_ID
    from ITEM_INFO as i join ITEM_TREE as t
    on i.ITEM_ID=t.PARENT_ITEM_ID
)

select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from ITEM_INFO as i left join parent as p
on i.ITEM_ID=p.PARENT_ID
where p.ITEM_ID is null
order by i.ITEM_ID desc;