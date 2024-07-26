-- 코드를 작성해주세요
select info.item_id as ITEM_ID, info.item_name as ITEM_NAME
from ITEM_INFO as info join ITEM_TREE as tree
where info.item_id=tree.item_id
    and tree.PARENT_ITEM_ID is null
order by info.item_id;