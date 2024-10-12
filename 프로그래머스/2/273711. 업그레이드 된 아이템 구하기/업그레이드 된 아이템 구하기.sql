-- 코드를 작성해주세요
select parent.ITEM_ID, info.ITEM_NAME, info.RARITY
from (
    select tree.ITEM_ID
    from ITEM_INFO as info join ITEM_TREE as tree
    on info.ITEM_ID=tree.PARENT_ITEM_ID
    where info.RARITY="RARE"
) as parent join ITEM_INFO as info
on parent.ITEM_ID=info.ITEM_ID
order by tree.ITEM_ID desc;