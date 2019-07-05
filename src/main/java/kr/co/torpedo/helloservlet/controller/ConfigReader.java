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

	public String getManagerId() {
		if (properties == null || !properties.containsKey("manager.id")) {
			throw new NullPointerException("properties가 null이거나 processor.type키가 없습니다.");
		}
		return properties.get("manager.id").toString();
	}

	public String getManagerPwd() {
		if (properties == null || !properties.containsKey("manager.passwd")) {
			throw new NullPointerException("properties가 null이거나 manager.passwd키가 없습니다.");
		}
		return properties.get("manager.passwd").toString();
	}
}
