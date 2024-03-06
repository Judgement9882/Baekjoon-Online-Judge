-- 코드를 입력하세요
select user_id, product_id
from online_sale
group by user_id, product_id
having count(user_id) > 1
order by USER_ID, PRODUCT_ID desc