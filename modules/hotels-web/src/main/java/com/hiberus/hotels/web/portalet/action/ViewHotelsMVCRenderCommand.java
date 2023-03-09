package com.hiberus.hotels.web.portalet.action;

import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.service.HotelService;
import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.hiberus.hotels.web.display.context.HotelManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

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
			"mvc.command.name=/",
			"mvc.command.name=" + MVCCommandsNames.VIEW_HOTELS
	},
	service = MVCRenderCommand.class
)
public class ViewHotelsMVCRenderCommand implements MVCRenderCommand {

	Log _log = LogFactoryUtil.getLog(ViewHotelsMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		addHotelListAttributes(renderRequest);
		
		addHotelToolbarAttributes(renderRequest, renderResponse);
		
		return "/hotel/view.jsp";
	}
	
	private void addHotelListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		String orderByCol = ParamUtil.getString(renderRequest, "orederByCol", "name");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		
		OrderByComparator<Hotel> comparator = OrderByComparatorFactoryUtil.create("Hotel", orderByCol, !("asc").equals(orderByType));
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		List<Hotel> hotels = _hotelService.findByNameOrLocation(themeDisplay.getScopeGroupId(), keywords, start, end, comparator);
		
		renderRequest.setAttribute("hotels", hotels);
		renderRequest.setAttribute("hotelsCount", hotels.size());
	}
	
	private void addHotelToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		HotelManagementToolbarDisplayContext hotelManagementToolbarDisplayContext = new HotelManagementToolbarDisplayContext(
				_portal.getHttpServletRequest(renderRequest), liferayPortletRequest, liferayPortletResponse);
		
		renderRequest.setAttribute("hotelManagementToolbarDisplayContext", hotelManagementToolbarDisplayContext);
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private HotelService _hotelService;
	
}
