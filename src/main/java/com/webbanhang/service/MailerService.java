package com.webbanhang.service;

import javax.mail.MessagingException;

import com.webbanhang.jpa.model.MailInfo;


public interface MailerService {

	/**
	 * gửi email
	 * @param mailInfo nội dung email
	 * @throws MessagingException
	 */
	void send(MailInfo mailInfo)throws MessagingException;
	/**
	 * gửi mail theo mục
	 * @param to email
	 * @param subject tiêu đề
	 * @param body nội dung
	 * @throws MessagingException
	 */
	void send(String to, String subject, String body) throws MessagingException;

	/**
	 * gửi email theo list
	 * @param mail
	 */
	void queue(MailInfo mail);

	/**
	 * gửi list email theo mục
	 * @param to
	 * @param subject
	 * @param body
	 */
	void queue(String to, String subject, String body);

	/**
	 * gửi email về tài khoản cần đổi password
	 * @param email email đổi password
	 * @param capchas mã số
	 * @throws MessagingException
	 */
	void sendPassword(String email,String capchas)throws MessagingException;

	/**
	 * gửi mail xác nhận đăng ký
	 * @param email  email đăng ký
	 * @param capchas mã số
	 * @throws MessagingException
	 */
	void sendSignUp(String email,String capchas) throws MessagingException;
}
