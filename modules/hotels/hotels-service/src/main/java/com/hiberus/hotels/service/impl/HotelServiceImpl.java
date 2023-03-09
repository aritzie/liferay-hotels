/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.hiberus.hotels.service.impl;

import com.hiberus.hotels.exception.HotelValidationException;
import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.service.base.HotelServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=hotels",
		"json.web.service.context.path=Hotel"
	},
	service = AopService.class
)
public class HotelServiceImpl extends HotelServiceBaseImpl {
	
	public Hotel addHotel(long groupId, String name, String email, String address, String location, Date foundationDate, ServiceContext serviceContext) throws HotelValidationException {	
		return hotelLocalService.addHotel(groupId, name, email, address, location, foundationDate, serviceContext);
	}
	
	public Hotel updateHotel(long hotelId, String name, String email, String address, String location, Date foundationDate, ServiceContext serviceContext) throws PortalException {
		return hotelLocalService.updateHotel(hotelId, name, email, address, location, foundationDate, serviceContext);
	}
	
	public Hotel deleteHotel(long hotelId) throws PortalException {
		return hotelLocalService.deleteHotel(hotelId);
	}
	
	public Hotel findHotel(long hotelId) {
		return hotelLocalService.fetchHotel(hotelId);
	}
	
	public List<Hotel> findAllHotels() {
		return hotelLocalService.findAllHotels();
	}
	
	public List<Hotel> findHotelByGroupId(long groupId) {
		return hotelLocalService.findByGroupId(groupId);
	}
	
	public List<Hotel> findHotelByLocation(String location){
		return hotelLocalService.findByLocation(location);
	}
	
	public List<Hotel> findByNameOrLocation(long groupId, String keywords, int start, int end, OrderByComparator<Hotel> orderByComparator){
		return hotelLocalService.findByNameOrLocation(groupId, keywords, start, end, orderByComparator);
	}
}