package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.service.RoomService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
				"mvc.command.name=" + MVCCommandsNames.DELETE_ROOM
		},
		service = MVCActionCommand.class
	)
public class DeleteRoomMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		long roomId = ParamUtil.getLong(actionRequest, "roomId");
		
		try {
			_roomService.deleteRoom(roomId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Reference
	private RoomService _roomService;
	
}
