# select i.ITEM_ID, i.ITEM_NAME, i.RARITY
# from ITEM_INFO i
# where i.ITEM_ID not in 
# (
#     select PARENT_ITEM_ID
#     from ITEM_TREE
# )
# order by i.ITEM_ID desc

select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO 
where ITEM_ID not in (
select PARENT_ITEM_ID
from ITEM_TREE
where PARENT_ITEM_ID is not null
)
order by ITEM_ID desc