package com.reusable.component.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PropsUtil;
import com.reusable.component.constants.CommonComponentConsts;
import com.reusable.component.constants.ReusableComponentPortletKeys;
import com.reusable.component.helper.SoapApiHelper;
import com.reusable.component.pojo.Envelope;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.bind.JAXBException;

import org.osgi.service.component.annotations.Component;

/**
 * @author tarun.patel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ReusableComponent",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ReusableComponentPortletKeys.REUSABLECOMPONENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ReusableComponentPortlet extends MVCPortlet {
	
	Log log = LogFactoryUtil.getLog(getClass());
	
	@ProcessAction(name = "nameForTheDoSomethingMoreMethod")
	public void doSomethingMore(
		ActionRequest actionRequest, ActionResponse actionResponse) {
		
		log.info("we are inside action method");
		Envelope envelope = SoapApiHelper.generateEnvelope();
		log.info("we are inside action method envelope ::"+envelope);
		URL url;
		try {
			url = new URL(PropsUtil.get(CommonComponentConsts.LOGIN_API_URL_KEY));
			log.info("we are inside action method url ::"+url);
			String response = SoapApiHelper.soapApi(envelope, url);
			log.info("Soap api rerponse ::"+response);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.info("Soap api MalformedURLException catch ::"+e.getMessage());
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			log.info("Soap api JAXBException catch ::"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info("Soap api IOException catch ::"+e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}

	

}
	
	
	
