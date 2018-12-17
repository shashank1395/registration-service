package com.cimplyfive.regestration.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cimplyfive.regestration.factory.RegistrationMongoFactory;
import com.cimplyfive.regestration.model.RegistrationModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

/**
 * @author shashank
 *
 */
@Service("registrationService")
@Transactional
public class RegistrationService {

	private static Logger log = Logger.getLogger(RegistrationService.class);

	private String databaseName = "registrationDb"; 
	private String collectionName = "registrationCollection";
	
	public Boolean saveRegistration(RegistrationModel registrationModel) {
		boolean result = false;
		try {
			DBCollection collection = RegistrationMongoFactory.getCollection(databaseName, collectionName);
			BasicDBObject doc = new BasicDBObject();
			doc.put("firstName", registrationModel.getFirstName());
			if(!StringUtils.isEmpty(registrationModel.getMiddleName())) {
				doc.put("middleName", registrationModel.getMiddleName());
			}			
			doc.put("lastName", registrationModel.getLastName());
			doc.put("emailId", registrationModel.getEmailId());
			if(!StringUtils.isEmpty(registrationModel.getMobileNumber())) {
				doc.put("mobileNumber", registrationModel.getMobileNumber());
			}
			doc.put("organizationName", registrationModel.getOrganizationName());
			doc.put("designation", registrationModel.getDesignation());
			doc.put("officeNumber", registrationModel.getOfficeNumber());
			doc.put("addressOne", registrationModel.getAddressOne());
			if(!StringUtils.isEmpty(registrationModel.getAddressTwo())) {
				doc.put("addressTwo", registrationModel.getAddressTwo());
			}
			if(!StringUtils.isEmpty(registrationModel.getLandmark())) {
				doc.put("landmark", registrationModel.getLandmark());
			}
			doc.put("pincode", registrationModel.getPincode());
			doc.put("city", registrationModel.getCity());
			doc.put("state", registrationModel.getState());
			doc.put("country", registrationModel.getCountry());
			doc.put("emailFrequency", registrationModel.getEmailFrequency());
			collection.insert(doc);
			result = true;
		}catch (Exception exception) {
			result = false;
			log.error("An error occurred while saving data to the mongo database", exception);
		}
		return result;
	}

	public void sendCOnfirmationMail(RegistrationModel registrationModel) {
	      String[] to = {registrationModel.getEmailId()};
	      String from = "XXX@XXX.com";
	      final String username = "XXXXXXXXX";//change accordingly
	      final String password = "*********";//change accordingly
	      String host = "smtp.gmail.com";
	      Properties props = System.getProperties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      Session mailSession = Session.getDefaultInstance(props, null);
	      try {
	   	   Message message = new MimeMessage(mailSession);
	   	   message.setFrom(new InternetAddress(from));
	   	   message.setRecipients(Message.RecipientType.TO,
	                  InternetAddress.parse(to[0]));
	   	   message.setSubject("Registration Successful");
	   	   message.setText("Hi, Thank you for registering with us. Regards");
	   	   Transport transport = mailSession.getTransport("smtp");
	   	   transport.connect(host, username, password);
	   	   transport.sendMessage(message, message.getAllRecipients());
	   	   transport.close();
	         } catch (MessagingException e) {
	            throw new RuntimeException(e);
	         }
	      }
}
