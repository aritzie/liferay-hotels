package com.hiberus.hotels.web.display.context;

import com.hiberus.hotels.web.constants.HotelsWebPortletKeys;
import com.hiberus.hotels.web.constants.MVCCommandsNames;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class HotelManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext{

	public HotelManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) {
		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	@Override
	public CreationMenu getCreationMenu() {
		return new CreationMenu() {
			{
				addDropdownItem(dropdownItem -> {
					dropdownItem.setHref(liferayPortletResponse.createRenderURL(), 
							"mvcRenderCommandName",
							MVCCommandsNames.EDIT_HOTEL, 
							"redirect", 
							currentURLObj.toString());
					dropdownItem.setLabel("add-hotel");
				});
			}
		};
	}
	
	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}
	
	@Override
	public String getDisplayStyle() {
		String displayStyle = ParamUtil.getString(request, "displayStyle");
		if(Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(HotelsWebPortletKeys.HOTELSWEB, "hotel-display-style", "descriptive");
		} else {
			_portalPreferences.setValue(HotelsWebPortletKeys.HOTELSWEB, "hotel-display-style", displayStyle);
			request.setAttribute(WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}
		return displayStyle;
	}
	
	@Override
	protected String getOrderByCol() {
		return ParamUtil.getString(request, "orderByCol", "name");
	}
	
	@Override
	protected String getOrderByType() {
		return ParamUtil.getString(request, "orderByType", "asc");
	}
	
	@Override
	public String getSearchActionURL() {
		PortletURL searchUrl = liferayPortletResponse.createActionURL();
		searchUrl.setProperty("mvcRenderCommandName", MVCCommandsNames.VIEW_HOTELS);
		
		String navigation = ParamUtil.getString(request, "navigation", "entries");
		searchUrl.setParameter("navigation", navigation);
		searchUrl.setParameter("orderByCol", getOrderByCol());
		searchUrl.setParameter("orderByType", getOrderByType());
		
		
		return searchUrl.toString();
	}
	
	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcRenderCommandName", MVCCommandsNames.VIEW_HOTELS);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		if(delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}
		String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
		String orderByType = ParamUtil.getString(request, "orderByType", "asc");
		portletURL.setParameter("orderByCol", orderByCol);
		portletURL.setParameter("orderByType", orderByType);
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);
		if(cur > 0) {
			portletURL.setParameter("cur", String.valueOf(cur));
		}
		return new ViewTypeItemList(portletURL, getDisplayStyle()) {
			{
				addCardViewTypeItem();
				addListViewTypeItem();
				addTableViewTypeItem();
			}
		};
	}
	
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(dropdownItem -> {
					dropdownItem.setActive("name".equals(getOrderByCol()));
					dropdownItem.setHref(_getCurrentSortingURL());
					dropdownItem.setLabel(LanguageUtil.get(request, "name"));
				});
			}
		};
	}
	
	private PortletURL _getCurrentSortingURL() throws PortletException {
		PortletURL sortingUrl = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
		sortingUrl.setParameter("mvcRenderCommand", MVCCommandsNames.VIEW_HOTEL);
		
		sortingUrl.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
		String keywords = ParamUtil.getString(request, "keywords");
		if(Validator.isNotNull(keywords)) {
			sortingUrl.setParameter("keywords", keywords);
		}
		return sortingUrl;
	}
	
	private final PortalPreferences _portalPreferences;
	private final ThemeDisplay _themeDisplay;

}
