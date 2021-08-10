package Steganography;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
 
public class Mail
{
        /* String  d_email = "iamdvr@gmail.com",
            d_password = "****",
            d_host = "smtp.gmail.com",
            d_port  = "465",
            m_to = "kalim_mce@yahoo.com",
            m_subject = "Testing",
            m_text = "Hey, this is the testing email using smtp.gmail.com.";*/
            
            
            public Mail(String mailid,String key)
            {
            	String to=mailid;
                String cc=mailid;
                String bcc=mailid;
                String msg="                          WELCOME  \n\n\n\n\n Dear user\n\n\n              To get original picture with message, your secret key is \n\n"+key;
                //This is for google
                    sendMail("manish.22127@gmail.com","password","smtp.gmail.com","465","true",
"true",true,"javax.net.ssl.SSLSocketFactory","false",to,cc,bcc,
"INFORMATION",msg); 
            }
            
            
    public static void main(String[] args)
    {
    	
    			

                //This is for google
                        
          
    }
 
        public synchronized static boolean sendMail(String userName,String passWord,String host,String port,String starttls,String auth,boolean debug,String socketFactoryClass,String fallback,String to,String cc,String bcc,String subject,String text){
                Properties props = new Properties();
                //Properties props=System.getProperties();
        props.put("mail.smtp.user", userName);
        props.put("mail.smtp.host", host);
                if(!"".equals(port))
        props.put("mail.smtp.port", port);
                if(!"".equals(starttls))
        props.put("mail.smtp.starttls.enable",starttls);
        props.put("mail.smtp.auth", auth);
                if(debug){
                props.put("mail.smtp.debug", "true");
                }else{
                props.put("mail.smtp.debug", "false");          
                }
                if(!"".equals(port))
        props.put("mail.smtp.socketFactory.port", port);
                if(!"".equals(socketFactoryClass))
        props.put("mail.smtp.socketFactory.class",socketFactoryClass);
                if(!"".equals(fallback))
        props.put("mail.smtp.socketFactory.fallback", fallback);
 
        try
        {
                        Session session = Session.getDefaultInstance(props, null);
            session.setDebug(debug); 
            MimeMessage msg = new MimeMessage(session);
            msg.setText(text);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress("p_sambasivarao@sutyam.com"));
                        
                        	Thread.sleep(100);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                                               
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
                       
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
                       
            msg.saveChanges();
                        Transport transport = session.getTransport("smtp");
                        transport.connect(host, userName, passWord);
                        transport.sendMessage(msg, msg.getAllRecipients());
                        transport.close();
                        return true;
        }
        catch (Exception mex)
        {
            mex.printStackTrace();
                        return false;
        } 
        }
 
}
