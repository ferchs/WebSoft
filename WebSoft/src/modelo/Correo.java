/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ferchs
 */
public class Correo {
    
    private Properties propiedadesSesion;
    private String firmaRemitente;
    private String remitente;
    private Session sesion;
    private Multipart multipart;
    private Transport transport;

    public Correo(Properties propiedadesSesion) {
        this.propiedadesSesion = propiedadesSesion;
    }
    
    public boolean enviarCorreo(String emailRemitente, String firmaRemitente, String emailDestinatario, String Asunto, String Mensaje){
        boolean enviado=true;
        try {
            this.remitente = emailRemitente;
            this.firmaRemitente = firmaRemitente;
            sesion = Session.getInstance(propiedadesSesion, null);
            MimeMessage mimeMessage = new MimeMessage(sesion);
            mimeMessage.setFrom(new InternetAddress(remitente,firmaRemitente));
            InternetAddress destinatario=new InternetAddress(emailDestinatario);
            mimeMessage.setRecipient(Message.RecipientType.TO, destinatario);
            mimeMessage.setSubject(Asunto);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(Mensaje);
            multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            mimeMessage.setContent(multipart);
            transport = sesion.getTransport("smtp");
            transport.connect(propiedadesSesion.getProperty("mail.user"), propiedadesSesion.getProperty("mail.password"));
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        }catch (Exception ex) {
            enviado=false;
        }
        return enviado;
    }
    
    public boolean comprobarCredencialesSesion(){
        boolean inicioSesion=true;
        try {
            sesion = Session.getInstance(propiedadesSesion, null);
            transport = sesion.getTransport("smtp");
            transport.connect(propiedadesSesion.getProperty("mail.user"), propiedadesSesion.getProperty("mail.password"));
        } catch (MessagingException ex) {
            inicioSesion=false;
        }
        return inicioSesion;
    }
}
