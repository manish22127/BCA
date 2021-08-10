package Steganography;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend 
{
	static boolean b;
public static boolean emailSend(String id,String hash,String sp)
{
	try {
		final String username="abc@gmail.com";//gmail Id
		final String password="password";//Password
		String smailID=id;
		System.out.println(smailID.trim());
		Properties pros=new Properties();
		pros.put("mail.smtp.auth","true");
		pros.put("mail.smtp.starttls.enable","true");

		pros.put("mail.smtp.port","587");
		Session s=Session.getInstance(pros,new Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}	
		});

		Message message=new MimeMessage(s);
		message.setFrom(new InternetAddress(id));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(smailID.trim()));
		message.setSubject("hash value:: Key");
		message.setText("Total Splited Images are::"+sp+"\n\n Hash Value of Stegno Image..."+hash);
		Transport.send(message);
		System.out.println("Done");
		b=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return b;
}
}
