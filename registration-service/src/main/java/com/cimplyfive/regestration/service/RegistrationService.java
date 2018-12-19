package com.cimplyfive.regestration.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimplyfive.regestration.controller.RegistrationController;
import com.cimplyfive.regestration.model.RegistrationModel;
import com.mongodb.MongoClient;

/**
 * @author shashank
 *
 */
@Service("registrationService")
@Transactional
public class RegistrationService {

	private static final String DATABASE = "registrationDb";

	private static final String FROM_ADDRESS = "XXX@XXX.com";
	
	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	public void sendCOnfirmationMail(RegistrationModel registrationModel) {
		logger.debug("sendCOnfirmationMail() : {}", registrationModel);
		String[] to = { registrationModel.getEmailId() };
		String from = FROM_ADDRESS;
		final String username = "XXXXXXXXX";// change accordingly
		final String password = "*********";// change accordingly
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[0]));
			message.setSubject("Registration Successful");
			message.setText("Hi, Thank you for registering with us. Regards");
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			logger.debug("sendCOnfirmationMail() : {} RuntimeException", e);
			throw new RuntimeException(e);
		}
	}

	public void createCollection() {
		try {
			MongoOperations mongoOps = new MongoTemplate(new MongoClient(), DATABASE);
			if (!(mongoOps.collectionExists(RegistrationModel.class))) {
				mongoOps.createCollection(RegistrationModel.class);
				logger.debug("createCollection() : {}", "Collection created");
			} else {
				logger.debug("createCollection() : {}", "Collection already exists");
			}
		} catch (Exception ex) {
			logger.debug("An error occurred while creating a collection", ex);
		}
	}

	public boolean saveRegistrationData(RegistrationModel registrationModel) {
		try {
			MongoOperations mongoOps = new MongoTemplate(new MongoClient(), DATABASE);
			mongoOps.insert(registrationModel);
			logger.debug("Inserted data is: ", mongoOps.findOne(new Query(Criteria.where("firstName").is(registrationModel.getFirstName())),
					RegistrationModel.class));
			return true;
		} catch (Exception ex) {
			logger.debug("An error occurred while saving the data", ex);
			return false;
		}
	}
}
