package com.boot.mybatis.util;

public class SqlUtil {

	public String selectRolesByLoginId(String loginId){
		StringBuilder builder=new StringBuilder();
		builder.append("select * from (SELECT a.id,a.company_id  AS \"company.id\",a.office_id   AS \"office.id\",a.login_name,");
		builder.append("a.password,a.no,a.name,a.email,a.phone,a.mobile,a.user_type,a.login_ip,a.login_date,a.remarks,a.login_flag,a.photo,a.create_by AS \"createBy.id\",");
		builder.append("a.create_date,a.update_by AS \"updateBy.id\",a.update_date,a.del_flag,c.name AS \"company.name\",c.parent_id AS \"company.parent.id\",")
        .append("c.parent_ids  AS \"company.parentIds\",")
        .append("ca.id         AS \"company.area.id\",")
        .append("ca.name       AS \"company.area.name\",")
        .append("ca.parent_id  AS \"company.area.parent.id\",")
        .append("ca.parent_ids AS \"company.area.parentIds\",")
        .append("o.name        AS \"office.name\",")
        .append("o.parent_id   AS \"office.parent.id\",")
        .append("o.parent_ids  AS \"office.parentIds\",")
        .append("oa.id         AS \"office.area.id\",")
        .append("oa.name       AS \"office.area.name\",")
        .append("oa.parent_id  AS \"office.area.parent.id\",")
        .append("oa.parent_ids AS \"office.area.parentIds\",")
        .append("cu.id AS \"company.primaryPerson.id\",cu.name AS \"company.primaryPerson.name\",cu2.id AS \"company.deputyPerson.id\",")
        .append("cu2.name AS \"company.deputyPerson.name\",ou.id AS \"office.primaryPerson.id\",ou.name       AS \"office.primaryPerson.name\",")
        .append("ou2.id AS \"office.deputyPerson.id\",ou2.name AS \"office.deputyPerson.name\"");
		builder.append("FROM sys_user a LEFT JOIN sys_office c ON c.id = a.company_id LEFT JOIN sys_area ca ON ca.id = c.area_id LEFT JOIN sys_office o ON o.id = a.office_id LEFT JOIN sys_area oa ON oa.id = o.area_id LEFT JOIN sys_user cu ON cu.id = c.primary_person LEFT JOIN sys_user cu2 ON cu2.id = c.deputy_person LEFT JOIN sys_user ou ON ou.id = o.primary_person LEFT JOIN sys_user ou2 ON ou2.id = o.deputy_person WHERE a.del_flag = 0 ORDER BY c.code, o.code, a.name)");
		builder.append(" where rownum <= 30");
		return builder.toString();
	}
}
