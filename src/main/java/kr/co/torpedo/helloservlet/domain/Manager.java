package kr.co.torpedo.helloservlet.domain;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "manager")
public class Manager {
	@Id
	@Column(name = "id", columnDefinition = "varchar(100)")
	private String id;
	@Column(name = "passwd", columnDefinition = "varchar(100)")
	private String pwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean checkManager(String id, String passwd) throws NoSuchAlgorithmException {
		if (!this.id.equals(id) || !BCrypt.checkpw(passwd, pwd)) {
			return false;
		}
		return true;
	}
}