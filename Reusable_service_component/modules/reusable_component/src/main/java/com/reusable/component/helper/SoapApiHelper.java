package com.reusable.component.helper;

import com.liferay.portal.kernel.util.PropsUtil;
import com.reusable.component.constants.CommonComponentConsts;
import com.reusable.component.pojo.Body;
import com.reusable.component.pojo.Envelope;
import com.reusable.component.pojo.Header;
import com.reusable.component.pojo.LogOn;
import com.reusable.component.pojo.LogOnRequest;
import com.reusable.component.pojo.ReplyTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class SoapApiHelper {
	
	
	
	/**
	 * It will the call the soap api
	 * 
	 * @param object
	 * @return
	 * @throws JAXBException
	 * @throws IOException 
	 */
	public static String soapApi(Object object, URL url) throws JAXBException, IOException {
		String soapXML = generateXML(object);
		HttpURLConnection connection = generateConnectionRequest(url);
		String reponse = callSOAPAPI(connection, soapXML);
		return reponse;
	}
	
	
	/**
	 * It will the generate the request for login api in XML format
	 * 
	 * @param object
	 * @return
	 * @throws JAXBException
	 */
	public static String generateXML(Object object) throws JAXBException {	
		StringWriter stringWriter = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(object, stringWriter);
		return stringWriter.toString();
	}
	
	
	/**
	 * It will the generate the connection for SOAP api request 
	 * 
	 * @param object
	 * @return
	 * @throws IOException 
	 */
	public static HttpURLConnection generateConnectionRequest(URL url) throws IOException {	
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(CommonComponentConsts.POST_KEY);
		connection.setRequestProperty(CommonComponentConsts.CONTENT_TYPE_KEY, CommonComponentConsts.CONTENT_TYPE_VALUE);
		connection.setRequestProperty(CommonComponentConsts.AUTHORIZATION_KEY, CommonComponentConsts.AUTHORIZATION_VALUE);
		connection.setDoOutput(true);
		return connection;
	}

	
	/**
	 * Common Method to call the SOAP API
	 * 
	 * @param connection
	 * @param soapXML
	 * @return
	 * @throws IOException
	 */
	public static String callSOAPAPI(HttpURLConnection connection, String soapXML) throws IOException {
		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = soapXML.getBytes(CommonComponentConsts.UTF_EIGHT);
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(connection.getInputStream(), CommonComponentConsts.UTF_EIGHT))) {
			StringBuilder response = new StringBuilder();
			String responseLine;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			return response.toString();
		}
	}
	
	
	/**
	 * This method will map the request to the pojo and send back.
	 * 
	 * @return
	 */
	public static Envelope generateEnvelope() {
		LogOnRequest logOnRequest = new LogOnRequest();
		logOnRequest.setUserName(PropsUtil.get(CommonComponentConsts.USERNAME_KEY));
		logOnRequest.setPassword(PropsUtil.get(CommonComponentConsts.PASSWORD_KEY));
		logOnRequest.setClientAccessKey(PropsUtil.get(CommonComponentConsts.ACCESSKEY_KEY));
		logOnRequest.setUserAccessKey(PropsUtil.get(CommonComponentConsts.CLIENTKEY_KEY));

		LogOn logOn = new LogOn();
		logOn.setLogOnRequest(logOnRequest);

		Body body = new Body();
		body.setLogOn(logOn);

		Header header = new Header();
		header.setAction("http://www.ultipro.com/dataservices/bidata/2/IBIDataService/LogOn");
		ReplyTo replyTo = new ReplyTo();
		replyTo.setAddress("http://www.w3.org/2005/08/addressing/anonymous");
		header.setReplyTo(replyTo);
		header.setTo("https://service4.ultipro.com/services/BIDataService");
		Envelope envelope = new Envelope();
		envelope.setHeader(header);
		envelope.setBody(body);

		return envelope;
	}
	
	
	

}
