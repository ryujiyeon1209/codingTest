-- 코드를 입력하세요
select MCDP_CD as "진료과코드", count(APNT_NO) as "5월예약건수"
from APPOINTMENT 
where year(APNT_YMD)=2022 and month(APNT_YMD)=05
group by MCDP_CD
order by count(APNT_NO), MCDP_CD
