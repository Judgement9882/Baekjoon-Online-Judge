-- 코드를 입력하세요

select round(avg(DAILY_FEE)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR 
where CAR_TYPE='SUV'