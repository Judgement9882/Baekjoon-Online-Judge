-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPER_INFOS 
where SKILL_1 = 'python' or SKILL_2 = 'python' or SKILL_3 = 'python'
order by ID