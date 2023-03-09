package com.hiberus.hotels.web.portlet;

import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author airibarren
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=HotelsWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/hotel/view.jsp",
		"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-para.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class HotelsWebPortlet extends MVCPortlet {
}