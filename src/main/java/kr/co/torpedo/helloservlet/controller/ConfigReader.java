package kr.co.torpedo.helloservlet.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	public ConfigReader() {
		properties = new Properties();
		loadProp();
	}

	private void loadProp() {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			properties.load(inputStream);
		} catch (IOException e) {
		}
	}

	public String getAdminId() {
		if (properties == null || !properties.containsKey("admin.id")) {
			throw new NullPointerException("properties가 null이거나 admin.id키가 없습니다.");
		}
		return properties.get("admin.id").toString();
	}

	public String getAdminPwd() {
		if (properties == null || !properties.containsKey("admin.passwd")) {
			throw new NullPointerException("properties가 null이거나 admin.passwd키가 없습니다.");
		}
		return properties.get("admin.passwd").toString();
	}
}
