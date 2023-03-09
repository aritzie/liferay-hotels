package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.exception.HotelValidationException;
import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.service.HotelService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
				"mvc.command.name=" + MVCCommandsNames.SAVE_HOTEL
		},
		service = MVCActionCommand.class
)
public class SaveHotelMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Hotel.class.getName(), actionRequest);
			long hotelId = ParamUtil.getLong(actionRequest, "hotelId");
			String name = ParamUtil.getString(actionRequest, "name");
			String email = ParamUtil.getString(actionRequest, "email");
			String address = ParamUtil.getString(actionRequest, "address");
			String location = ParamUtil.getString(actionRequest, "location");
			Date foundationDate = ParamUtil.getDate(actionRequest, "foundationDate", null);
			
			if(hotelId==0) {
				_hotelService.addHotel(themeDisplay.getScopeGroupId(), name, email, address, location, foundationDate, serviceContext);
				SessionMessages.add(actionRequest, "hotelAdded");
			} else {
				_hotelService.updateHotel(hotelId, name, email, address, location, foundationDate, serviceContext);
				SessionMessages.add(actionRequest, "hotelUpdated");
			}
			
			sendRedirect(actionRequest, actionResponse);
			
		} catch (HotelValidationException e) {
			e.getErrors().forEach(error -> SessionErrors.add(actionRequest, error));
			e.printStackTrace();
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandsNames.EDIT_HOTEL);
			
		} catch (PortalException | IOException e) {
			SessionErrors.add(actionRequest, "serviceErrorDetails", e);
			e.printStackTrace();
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandsNames.EDIT_HOTEL);
		} 
		
	}
	
	@Reference
	private HotelService _hotelService;

}
