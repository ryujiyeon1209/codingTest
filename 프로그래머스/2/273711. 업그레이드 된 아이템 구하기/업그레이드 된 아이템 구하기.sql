-- 코드를 작성해주세요
select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where item_id in (
    select tree.item_id
    from ITEM_INFO as info join ITEM_TREE as tree
    where info.item_id=tree.parent_item_id
        and info.rarity="RARE")
order by ITEM_ID desc;