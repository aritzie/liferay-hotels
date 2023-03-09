package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.service.RoomService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
				"mvc.command.name=" + MVCCommandsNames.SAVE_ROOM
		},
		service = MVCActionCommand.class
	)
public class SaveRoomMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Room.class.getName(), actionRequest);
			long roomId = ParamUtil.getLong(actionRequest, "roomId");
			long hotelId = ParamUtil.getLong(actionRequest, "hotelId");
			int number = ParamUtil.getInteger(actionRequest, "number");
			String type = ParamUtil.getString(actionRequest, "type");
			int size = ParamUtil.getInteger(actionRequest, "size");
			double price = ParamUtil.getDouble(actionRequest, "price");
			
			if(roomId==0) {
				_roomService.addRoom(themeDisplay.getScopeGroupId(), hotelId, number, type, size, price, serviceContext);
			} else {
				_roomService.updateRoom(roomId, hotelId, number, type, size, price);
			}
			
			sendRedirect(actionRequest, actionResponse);
			
		} catch (PortalException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Reference
	private RoomService _roomService;

}
