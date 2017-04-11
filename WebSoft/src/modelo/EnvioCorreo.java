/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.w3c.dom.Document;

/**
 *
 * @author ferchs
 */
public class EnvioCorreo {

        
       /*
       //String valor =conf.obtenerConfiguracion("propiedad");
       //System.out.println(conf.obtenerConfiguracion("otra"));
       conf.escribirConfiguracion("prop", "value");
       conf.escribirConfiguracion("propp", "val");
       conf.escribirConfiguracion("prop", "valor");

       
        String Username="websoftcol@gmail.com";
        String PassWord="fundafro";
        String To="ferchs17@gmail.com";
        String Subject="Asunto";
        String Mensage="Mensaje de prueba";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.user", Username);
        props.put("mail.password", PassWord);

        Session session = Session.getInstance(props, null);
 
  try {
   // Crear el cuerpo del mensaje
   MimeMessage mimeMessage = new MimeMessage(session);
 
   // Agregar quien envía el correo
   mimeMessage.setFrom(new InternetAddress(To, "WebSoft"));
    
   // Los destinatarios
   InternetAddress[] internetAddresses = {
     new InternetAddress("ferchs17@gmail.com")};
 
   // Agregar los destinatarios al mensaje
   mimeMessage.setRecipients(Message.RecipientType.TO,
     internetAddresses);
 
   // Agregar el asunto al correo
   mimeMessage.setSubject("Contraseña Admin WebSoft");
 
   // Creo la parte del mensaje
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setText("Su contraseña es: admin123");
 
   // Crear el multipart para agregar la parte del mensaje anterior
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
 
   // Agregar el multipart al cuerpo del mensaje
   mimeMessage.setContent(multipart);
 
   // Enviar el mensaje
   Transport transport = session.getTransport("smtp");
   transport.connect(Username, PassWord);
   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
   transport.close();
 
  } catch (Exception ex) {
   ex.printStackTrace();
  }
  System.out.println("Correo enviado");
*/
}
