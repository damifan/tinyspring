package org.trii.tinyspring.security;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 13, 2014
 * Time: 12:31
 */
public class TinyUser {

	String username;

	String password;

	String rawPrivilege;

	PrivilegeSet privilegeSet;

	Object nestedEntity;

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getRawPrivilege() {

		return rawPrivilege;
	}

	public void setRawPrivilege(String rawPrivilege) {

		this.rawPrivilege = rawPrivilege;
	}

	public PrivilegeSet getPrivilegeSet() {

		return privilegeSet;
	}

	public void setPrivilegeSet(PrivilegeSet privilegeSet) {

		this.privilegeSet = privilegeSet;
	}

	public Object getNestedEntity() {

		return nestedEntity;
	}

	public void setNestedEntity(Object nestedEntity) {

		this.nestedEntity = nestedEntity;
	}
}
