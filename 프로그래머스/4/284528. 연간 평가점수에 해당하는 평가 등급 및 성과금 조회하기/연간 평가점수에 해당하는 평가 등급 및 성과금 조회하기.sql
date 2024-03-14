-- 코드를 작성해주세요

select e.EMP_NO, e.EMP_NAME, 
(case 
when avg(g.SCORE) >= 96 then 'S'
when avg(g.SCORE) >= 90 then 'A'
when avg(g.SCORE) >= 80 then 'B'
else 'C' end) as GRADE, 
e.SAL*
(case 
when avg(g.SCORE) >= 96 then 0.2
when avg(g.SCORE) >= 90 then 0.15
when avg(g.SCORE) >= 80 then 0.1
else 0 end) as BONUS
from HR_EMPLOYEES e join HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by e.EMP_NO
order by e.EMP_NO