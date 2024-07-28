-- 코드를 작성해주세요
select info.item_id as ITEM_ID, info.item_name as ITEM_NAME, info.rarity as RARITY
from ITEM_INFO as info left outer join ITEM_TREE as tree
on info.item_id=tree.PARENT_ITEM_ID
where tree.item_id is null
order by ITEM_ID desc;
