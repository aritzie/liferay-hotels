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

import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.service.base.RoomLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hiberus.hotels.model.Room",
	service = AopService.class
)
public class RoomLocalServiceImpl extends RoomLocalServiceBaseImpl {
	
	public Room addRoom(long groupId, long hotelId, int number, String type, int size, double price, ServiceContext serviceContext) {
		Room room = roomPersistence.create(counterLocalService.increment());
		
		room.setUserUuid(serviceContext.getUuid());
		room.setGroupId(groupId);
		room.setCompanyId(serviceContext.getCompanyId());
		room.setUserId(serviceContext.getUserId());
		
		room.setHotelId(hotelId);
		room.setNumber(number);
		room.setType(type);
		room.setSize(size);
		
		room = roomPersistence.update(room);
		
		return room;
	}
	
	public Room updateRoom(long roomId, long hotelId, int number, String type, int size, double price) throws PortalException {
		
		Room room = getRoom(roomId);
		
		room.setHotelId(hotelId);
		room.setNumber(number);
		room.setType(type);
		room.setPrice(price);
		
		return room;
	}
	
	public Room deleteRoom(long roomId) throws PortalException {
		return roomPersistence.remove(roomId);
	}
	
	public List<Room> findByGroupId(long groupId){
		return roomPersistence.findByGroupId(groupId);
	}
	
	public List<Room> findByHotelId(long hotelId){
		return roomPersistence.findByHotelId(hotelId);
	}
	
	public DynamicQuery dynamicQueryByKeywords(long groupId, String keywords) {
		DynamicQuery query = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(RestrictionsFactoryUtil.like("number", "%" + keywords + "%"));
		disjunction.add(RestrictionsFactoryUtil.like("type", "%" + keywords + "%"));
		disjunction.add(RestrictionsFactoryUtil.like("size", "%" + keywords + "%"));
		
		return query.add(disjunction);
	}
	
	public List<Room> findByNumberTypeOrSize(long groupId, String keywords, int start, int end, OrderByComparator<Room> orderByComparator){
		return dynamicQuery(dynamicQueryByKeywords(groupId, keywords), start, end, orderByComparator);
	}
}