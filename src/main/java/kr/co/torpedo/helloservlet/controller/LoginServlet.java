package kr.co.torpedo.helloservlet.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.torpedo.helloservlet.domain.Admin;
import kr.co.torpedo.helloservlet.repository.hibernate.HibernateRepository;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 3755421297984377453L;
	private Admin admin;
	private ConfigReader reader;
	private HibernateRepository repository;

	@Override
	public void init() throws ServletException {
		repository = new HibernateRepository();
		reader = new ConfigReader();
		admin = new Admin();
		admin.setId(reader.getAdminId());
		admin.setPasswd(reader.getAdminPasswd());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String id = req.getParameter("id");
		String pwd = req.getParameter("passwd");

		if (id == "") { // 아이디를 입력하지 않았을 경우
			dispatcher = req.getRequestDispatcher("/");
			req.setAttribute("errormsg", "아이디를 입력해 주세요!");
			dispatcher.forward(req, resp);
		} else if (pwd == "") { // 비밀번호를 입력하지 않았을 경우
			dispatcher = req.getRequestDispatcher("/");
			req.setAttribute("errormsg", "비밀번호를 입력해 주세요!");
			dispatcher.forward(req, resp);
		} else {
			try {
				boolean check = admin.checkAdminInfo(id, pwd);
				if (check) { // 로그인 성공
					req.setAttribute("userList", repository.selectUserList());
					dispatcher = req.getRequestDispatcher("/viewUserList.jsp");
					dispatcher.forward(req, resp);
				} else { // 로그인 실패
					dispatcher = req.getRequestDispatcher("/loginFail.html");
					dispatcher.forward(req, resp);
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
}
