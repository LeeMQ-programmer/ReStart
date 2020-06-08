package com.start.pro.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.start.pro.dto.DTO_Email;
import com.start.pro.models.email.IService_Email;

@Service
public class AsyncTask_SendEmail {

	
	private final String setFrom = "ckadl0118@gmail.com";
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private IService_Email service;
	
	
	// 단일 메세지 전송
		@Async("myex")
		public void sendOneMail(DTO_Email dto, HttpServletResponse resp) {
			System.out.println("비동기 들어왔어");
			MimeMessage message = mailSender.createMimeMessage();
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setFrom);
				System.out.println("보낼사람이메일");
				messageHelper.setTo(dto.getUser_email());
				System.out.println("받는사람이메일");
				messageHelper.setSubject(dto.getEmail_title());
				messageHelper.setText(dto.getEmail_content(),true);

				System.out.println("메세지 보내?");
				mailSender.send(message);
				System.out.println("메세지 보냈어");
			} catch (MessagingException e) {
				System.out.println("메일발송 오류??");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>alert('메일 발송을 실패했습니다.');</script>");
					out.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		}
		
		@Async("myex")
		public void LJMail(String code, String email,HttpServletResponse resp) {
			System.out.println("비동기 들어왔어");
			
			DTO_Email dto = service.SelDetailAuto(code);
			System.out.println("잘가져왔어?"+dto.toString());
			
			String content = dto.getEmail_content();
			content = content.replace("#{email}", email);
			content =content.replace("#{key}", "1234");
			dto.setEmail_content(content);
			Map<String, String> map = new HashMap<String, String>();
			map.put("user_email", email);
			map.put("lj_key","1234");
			map.put("lj_code",code);
			service.sendLJ(map);
			
			
			MimeMessage message = mailSender.createMimeMessage();
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setFrom);
				System.out.println("보낼사람이메일");
				messageHelper.setTo(email);
				System.out.println("받는사람이메일");
				messageHelper.setSubject(dto.getEmail_title());
				messageHelper.setText(dto.getEmail_content(),true);

				System.out.println("메세지 보내?");
				mailSender.send(message);
				System.out.println("메세지 보냈어");
			} catch (MessagingException e) {
				System.out.println("메일발송 오류??");
				PrintWriter out;
				try {
					out = resp.getWriter();
					out.println("<script>alert('메일 발송을 실패했습니다.');</script>");
					out.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		}
		
		
		@Async("myex")
		public void sendManyMail(List<DTO_Email> mailList) {
			
					MimeMessagePreparator[] preparators = new MimeMessagePreparator[mailList.size()];
			
					int i = 0;
					for(final DTO_Email vo: mailList) {
						if(i != 2) {
							preparators[i++] = new MimeMessagePreparator() {
			
								@Override
								public void prepare(MimeMessage mimeMessage) throws Exception {
									final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
									helper.setFrom(setFrom);
									helper.setTo(vo.getUser_email());
									helper.setSubject(vo.getEmail_title());
									helper.setText(vo.getEmail_content(), true);
								}
							};
						}else {
							preparators[i++] = new MimeMessagePreparator() {
			
								@Override
								public void prepare(MimeMessage mimeMessage) throws Exception {
									final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
									helper.setFrom(setFrom);
									helper.setTo("fe@gewg.fef");
									helper.setSubject(vo.getEmail_title());
									helper.setText(vo.getEmail_content(), true);
								}
							};
						}
					}
					mailSender.send(preparators);

		}
		
		
		
		@Async("myex")
		public void chkFailMail() {


			String host = "imap.gmail.com"; //imap 호스트 주소. ex) imap.gmail.com
			String userEmail = "ckadl0118@gmail.com"; //유저 이메일 주소
			String password = "3wndeo12!@"; //유저 암호

			URLName url = new URLName("imaps", host, 993, "INBOX", userEmail, password);

			Session session= null;
			Store store = null;
			Folder folder = null;	

			if (session == null) {
				Properties props = null;
				try {
					props = System.getProperties();
				} catch (SecurityException sex) {
					props = new Properties();
				}
				session = Session.getInstance(props, null);
			}
			try {
				store = session.getStore(url);
				store.connect();
				folder = store.getFolder("inbox"); //inbox는 받은 메일함을 의미
				
				if(folder==null || !folder.exists()) {
					return;
				}
				
				folder.open(Folder.READ_WRITE); //읽고 쓰기 전용


				Message[] msgArray = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

				if(msgArray.length == 0) {
					System.out.println("안읽은 메일이 없음");
					return;
				}
				
				for (int i = 0; i < msgArray.length; i++) {

					Message msg = msgArray[i];
					try {
						if(msg.getSubject().equalsIgnoreCase("Delivery Status Notification (Failure)")) {
							
							if(saveParts(msg.getContent())) {
								folder.setFlags(new Message[] {msg}, new Flags(Flags.Flag.SEEN), true);
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}

				folder.close(false);
				store.close();
//				store = null;
//				session = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("unused")
		private boolean saveParts(Object content) throws Exception { 
			
			if (content instanceof Multipart) {
				
				Multipart multi = ((Multipart) content);

				for (int j = 0; j < multi.getCount(); j++) {
					
					MimeBodyPart part = (MimeBodyPart) multi.getBodyPart(j);
					
					if (part.getContent() instanceof Multipart) {
						saveParts(part.getContent());
					} else if(part.isMimeType("text/plain")){
						System.out.println("내용 ㅜㅜ"+part.getContent()); 
						String str = (String) part.getContent();
						String failEmail = (str.substring(str.indexOf("to")+2, str.indexOf("because"))).trim();
						System.out.println(failEmail);
						if(true) { // 쿼리 실행
							return true;
						}else {
							return false;
						}
					} 
				} 
			}
				return true;
		} 

	
}
