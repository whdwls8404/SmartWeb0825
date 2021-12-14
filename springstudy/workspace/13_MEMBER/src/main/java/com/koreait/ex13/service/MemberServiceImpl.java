package com.koreait.ex13.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.koreait.ex13.domain.Member;
import com.koreait.ex13.repository.MemberRepository;
import com.koreait.ex13.util.SecurityUtils;

public class MemberServiceImpl implements MemberService {

	private SqlSessionTemplate sqlSession;
	private JavaMailSender javaMailSender;
	
	@Autowired
	public void setBean(SqlSessionTemplate sqlSession, JavaMailSender javaMailSender) {
		this.sqlSession = sqlSession;
		this.javaMailSender = javaMailSender;
	}

	@Override
	public Map<String, Object> idCheck(String id) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", repository.selectMemberById(id));
		return map;
	}
	
	@Override
	public Map<String, Object> findMemberByEmail(String email) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", repository.selectMemberByEmail(email));
		return map;
	}

	@Override
	public Map<String, Object> sendAuthCode(String email) {
		
		// 인증코드 발생
		String authCode = SecurityUtils.authCode(6); 
		
		// 이메일 전송
		try {
			
			MimeMessage message = javaMailSender.createMimeMessage();
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress("forspringlec@gmail.com", "인증코드관리자"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("인증 요청 메일입니다.");
			message.setText("인증번호는 " + authCode + " 입니다.");
			javaMailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authCode", authCode);
		return map;
		
	}
	
	@Override
	public void join(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		member.setPw(SecurityUtils.sha256(member.getPw()));
		member.setName(SecurityUtils.xxs(member.getName()));
		repository.joinMember(member);
	}
	
	@Override
	public void login(HttpServletRequest request) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(SecurityUtils.sha256(request.getParameter("pw")));
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Member loginUser = repository.login(member);
		if (loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}
	}
	
	@Override
	public void updatePw(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		member.setPw(SecurityUtils.sha256(member.getPw()));
		repository.updatePw(member);
	}
	
	@Override
	public void updateMember(Member member, HttpSession session) {
		member.setName(SecurityUtils.xxs(member.getName()));
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		repository.updateMember(member);
		Member loginUser = (Member)session.getAttribute("loginUser");
		loginUser.setName(member.getName());
		loginUser.setEmail(member.getEmail());
	}
	
	@Override
	public Map<String, Object> presentPwCheck(HttpServletRequest request) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Member member = repository.selectMemberById(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", SecurityUtils.sha256(request.getParameter("pw0")).equals(member.getPw()));
		return map;
	}
	
	@Override
	public void leave(Long no, HttpSession session) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		int result = repository.leaveMember(no);
		if (result > 0)	session.invalidate();
	}
	
}