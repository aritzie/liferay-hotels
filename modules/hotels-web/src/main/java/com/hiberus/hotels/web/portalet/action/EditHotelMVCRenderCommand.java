package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.service.HotelService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB, 
				"mvc.command.name=" + MVCCommandsNames.EDIT_HOTEL
		},
		service = MVCRenderCommand.class
)
public class EditHotelMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse){
		Hotel hotel = null;
		long hotelId = ParamUtil.getLong(renderRequest, "hotelId", 0);
		
		if(hotelId>0) {
			hotel = _hotelService.findHotel(hotelId);
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = ParamUtil.getString(renderRequest, "redirect");
		portletDisplay.setURLBack(redirect);
		
		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("hotelId", hotelId);
		renderRequest.setAttribute("hotel", hotel);
		renderRequest.setAttribute("hotelClass", Hotel.class);
		
		return "/hotel/edit_hotel.jsp";
	}
	
	@Reference
	private HotelService _hotelService;

}
