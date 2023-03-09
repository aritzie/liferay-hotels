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
import com.hiberus.hotels.service.base.RoomServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=hotels",
		"json.web.service.context.path=Room"
	},
	service = AopService.class
)
public class RoomServiceImpl extends RoomServiceBaseImpl {
	
	public Room addRoom(long groupId, long hotelId, int number, String type, int size, double price, ServiceContext serviceContext) {
		return roomLocalService.addRoom(groupId, hotelId, number, type, size, price, serviceContext);
	}
	
	public Room updateRoom(long roomId, long hotelId, int number, String type, int size, double price) throws PortalException {
		return roomLocalService.updateRoom(roomId, hotelId, number, type, size, price);
	}
	
	public Room deleteRoom(long roomId) throws PortalException {
		return roomLocalService.deleteRoom(roomId);
	}
	
	public Room findRoom(long roomId) {
		return roomLocalService.fetchRoom(roomId);
	}
	
	public List<Room> findByGroupId(long groupId){
		return roomLocalService.findByGroupId(groupId);
	}
	
	public List<Room> findByHotelId(long hotelId){
		return roomLocalService.findByHotelId(hotelId);
	}
	
	public List<Room> findByNumerTypeOrSize(long groupId, String keywords, int start, int end, OrderByComparator<Room> orderByComparator){
		return roomLocalService.findByNumberTypeOrSize(groupId, keywords, start, end, orderByComparator);
	}
}