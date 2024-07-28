-- 코드를 입력하세요
select  a.apnt_no as APNT_NO, p.pt_name as PT_NAME, p.pt_no as PT_NO,
    d.mcdp_cd as MCDP_CD, d.dr_name as DR_NAME, (a.apnt_ymd) as APNT_YMD 
from PATIENT as p join APPOINTMENT as a join DOCTOR as d
where p.pt_no=a.pt_no and d.dr_id=a.mddr_id
    and date_format(a.apnt_ymd, "%Y-%m-%d")='2022-04-13'
    and a.apnt_cncl_yn="N"
    and d.mcdp_cd="CS"
order by a.apnt_ymd;
