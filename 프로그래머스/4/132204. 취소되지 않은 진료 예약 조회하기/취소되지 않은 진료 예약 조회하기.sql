-- 코드를 입력하세요
with APPOINT as (
    select APNT_YMD, APNT_NO, PT_NO, MDDR_ID
    from APPOINTMENT as a
    where date_format(APNT_YMD, "%Y-%m-%d") = "2022-04-13" 
        and MCDP_CD = "CS" and APNT_CNCL_YN = "N"
)

select a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINT as a join PATIENT as p join DOCTOR as d
on a.PT_NO=p.PT_NO and a.MDDR_ID=d.DR_ID
order by a.APNT_YMD;