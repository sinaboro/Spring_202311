package com.ezen.mybatis.prj;

import lombok.Data;

/*
 * id NUMBER(5) primary key,
    name varchar2(20),
    phone varchar2(20),
    address varchar2(50)
 */
@Data
public class MemberVO {
	private int id;
	private String name;
	private String phone;
	private String address;
}
