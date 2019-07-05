package kr.co.torpedo.helloservlet.domain;

import java.security.NoSuchAlgorithmException;

import org.mindrot.jbcrypt.BCrypt;

public class Admin {
	private String id;
	private String passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String pwd) {
		this.passwd = pwd;
	}

	public boolean checkAdminInfo(String id, String passwd) throws NoSuchAlgorithmException {
		if (!this.id.equals(id) || !BCrypt.checkpw(passwd, this.passwd)) {
			return false;
		}
		return true;
	}
}