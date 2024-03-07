-- 코드를 작성해주세요

select I.ITEM_ID, I.ITEM_NAME, I.RARITY
from ITEM_INFO I join ITEM_TREE T
on I.item_id = T.item_id
where T.PARENT_ITEM_ID in
(select ITEM_ID from ITEM_INFO where rarity='RARE')
order by I.Item_id desc