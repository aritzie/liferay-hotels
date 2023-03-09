package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.service.RoomService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
				"mvc.command.name=" + MVCCommandsNames.EDIT_ROOM
		},
		service = MVCRenderCommand.class
	)
public class EditRoomMVCRenderCommand implements MVCRenderCommand {
	
	private Log _log = LogFactoryUtil.getLog(EditRoomMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Room room = null;
		long roomId = ParamUtil.getLong(renderRequest, "roomId", 0);
		long hotelId = ParamUtil.getLong(renderRequest, "hotelId");
		
		_log.info(roomId);
		
		if(roomId>0) {
			room = _roomService.findRoom(roomId);
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = ParamUtil.getString(renderRequest, "redirect");
		portletDisplay.setURLBack(redirect);
		
		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("roomId", roomId);
		renderRequest.setAttribute("hotelId", hotelId);
		renderRequest.setAttribute("room", room);
		renderRequest.setAttribute("roomClass", Room.class);
		
		return "/room/edit_room.jsp";
	}
	
	@Reference
	private RoomService _roomService;

}
