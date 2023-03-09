package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.service.HotelService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
				"mvc.command.name=" + MVCCommandsNames.DELETE_HOTEL
		},
		service = MVCActionCommand.class
)
public class DeleteHotelMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		long hotelId = ParamUtil.getLong(actionRequest, "hotelId");
		try {
			_hotelService.deleteHotel(hotelId);
			SessionMessages.add(actionRequest, "hotelDeleted");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Reference
	private HotelService _hotelService;

}
