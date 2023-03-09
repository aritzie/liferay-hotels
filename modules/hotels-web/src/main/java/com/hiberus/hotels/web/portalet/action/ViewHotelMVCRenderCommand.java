package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.service.HotelService;
import com.hiberus.hotels.service.RoomService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.hiberus.hotels.web.display.context.RoomManagementToolbarDisplayContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + HotelsWebPortletKeys.HOTELSWEB,
				"mvc.command.name=" + MVCCommandsNames.VIEW_HOTEL
		},
		service = MVCRenderCommand.class
)
public class ViewHotelMVCRenderCommand implements MVCRenderCommand{
	
	private Log _log = LogFactoryUtil.getLog(ViewHotelMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long hotelId = ParamUtil.getLong(renderRequest, "hotelId");
		
		addHotelAttributes(renderRequest, hotelId);
		
		addRoomListAttributes(renderRequest, hotelId);
		
		addRoomToolbarAttributes(renderRequest, renderResponse);
		
		return "/hotel/hotel_view.jsp";
	}
	
	private void addHotelAttributes(RenderRequest renderRequest, long hotelId) {
		Hotel hotel = _hotelService.findHotel(hotelId);
		renderRequest.setAttribute("hotel", hotel);
	}
	
	private void addRoomListAttributes(RenderRequest renderRequest, long hotelId) {
		List<Room> rooms = _roomService.findByHotelId(hotelId);
		renderRequest.setAttribute("rooms", rooms);
		_log.info(rooms.size());
		renderRequest.setAttribute("roomsCount", rooms.size());
	}
	
	private void addRoomToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		RoomManagementToolbarDisplayContext roomManagementToolbarDisplayContext = 
				new RoomManagementToolbarDisplayContext(_portal.getHttpServletRequest(renderRequest), liferayPortletRequest, liferayPortletResponse);
		
		renderRequest.setAttribute("roomManagementToolbarDisplayContext", roomManagementToolbarDisplayContext);
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private HotelService _hotelService;
	
	@Reference
	private RoomService _roomService;

}
