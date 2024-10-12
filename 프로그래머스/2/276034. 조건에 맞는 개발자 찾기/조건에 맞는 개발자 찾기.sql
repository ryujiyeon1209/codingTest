-- 코드를 작성해주세요
select distinct de.ID, de.EMAIL, de.FIRST_NAME, de.LAST_NAME
from SKILLCODES as sk join DEVELOPERS as de
on 0<sk.CODE & de.SKILL_CODE
where sk.NAME="Python" or sk.NAME="C#"
order by de.ID;