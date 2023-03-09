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
import com.hiberus.hotels.service.base.HotelLocalServiceBaseImpl;
import com.hiberus.hotels.validator.HotelValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hiberus.hotels.model.Hotel",
	service = AopService.class
)
public class HotelLocalServiceImpl extends HotelLocalServiceBaseImpl {

	Log _log = LogFactoryUtil.getLog(HotelLocalServiceImpl.class);
	
	public Hotel addHotel (long groupId, String name, String email, String address, String location, Date foundationDate, ServiceContext serviceContext) throws HotelValidationException {
		
		_hotelValidator.validate(email);
		
		Hotel hotel = hotelPersistence.create(counterLocalService.increment());
		
		hotel.setUuid(serviceContext.getUuid());
		hotel.setGroupId(groupId);
		hotel.setCompanyId(serviceContext.getCompanyId());
		hotel.setUserId(serviceContext.getUserId());
		
		hotel.setName(name);
		hotel.setEmail(email);
		hotel.setAddress(address);
		hotel.setLocation(location);
		hotel.setFoundationDate(foundationDate);
		
		hotel = hotelPersistence.update(hotel);
		
		return hotel;
	}
	
	public Hotel updateHotel(long hotelId, String name, String email, String address, String location, Date foundationDate, ServiceContext serviceContext) throws PortalException {
		
		_hotelValidator.validate(email);
		
		Hotel hotel = getHotel(hotelId);
		
		hotel.setName(name);
		hotel.setName(name);
		hotel.setEmail(email);
		hotel.setAddress(address);
		hotel.setLocation(location);
		hotel.setFoundationDate(foundationDate);
		
		hotel = hotelPersistence.update(hotel);
		
		return hotel;
	}
	
	public Hotel deleteHotel(long hotelId) throws PortalException {
		return hotelPersistence.remove(hotelId);
	}
	
	public List<Hotel> findAllHotels(){
		return hotelPersistence.findAll();
	}
	
	public List<Hotel> findByGroupId(long groupId){
		return hotelPersistence.findByGroupId(groupId);
	}
	
	public List<Hotel> findByLocation(String location){
		return hotelPersistence.findByLocation(location);
	}
	
	public DynamicQuery dynamicQueryByKeywords(long groupId, String keywords) {
		DynamicQuery query = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(RestrictionsFactoryUtil.like("name", "%" + keywords + "%"));
		disjunction.add(RestrictionsFactoryUtil.like("location", "%" + keywords + "%"));
		
		return query.add(disjunction);
	}
	
	public List<Hotel> findByNameOrLocation(long groupId, String keywords, int start, int end, OrderByComparator<Hotel> orderByComparator){
		return dynamicQuery(dynamicQueryByKeywords(groupId, keywords), start, end, orderByComparator);
	}
	
	@Reference
	HotelValidator _hotelValidator;
}