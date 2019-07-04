package kr.co.torpedo.helloservlet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
	private String filePath = "D:\\eclipse_workspace\\HelloServlet\\src\\main\\resources\\config.properties";
	private File profile;
	private FileOutputStream fos;

	public ConfigReader() {
		properties = new Properties();
		init();
		loadProp();
	}

	public void init() {
		profile = new File(filePath);

		try {
			if (!profile.exists()) {
				profile.createNewFile();
			}
			fos = new FileOutputStream(profile);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void setManagerId(String id) {
		if (properties == null || !properties.containsKey("manager.id")) {
			throw new NullPointerException("properties가 null이거나 processor.type키가 없습니다.");
		}
		properties.setProperty("manager.id", id);
	}

	public void setManagerPwd(String pwd) {
		if (properties == null || !properties.containsKey("manager.passwd")) {
			throw new NullPointerException("properties가 null이거나 manager.passwd키가 없습니다.");
		}
		properties.setProperty("manager.passwd", pwd);
	}

	public void store() throws IOException {
		properties.store(fos, "");
	}
}
