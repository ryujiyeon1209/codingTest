-- 코드를 작성해주세요
select distinct devel.ID, devel.EMAIL, devel.FIRST_NAME, devel.LAST_NAME
from SKILLCODES as skill join DEVELOPERS as devel
on skill.CODE&devel.SKILL_CODE=skill.CODE
where skill.NAME="C#" or skill.NAME="Python"
order by devel.ID;
