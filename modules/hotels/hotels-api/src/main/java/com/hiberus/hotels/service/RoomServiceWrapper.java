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

package com.hiberus.hotels.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoomService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoomService
 * @generated
 */
public class RoomServiceWrapper
	implements RoomService, ServiceWrapper<RoomService> {

	public RoomServiceWrapper() {
		this(null);
	}

	public RoomServiceWrapper(RoomService roomService) {
		_roomService = roomService;
	}

	@Override
	public com.hiberus.hotels.model.Room addRoom(
		long groupId, long hotelId, int number, String type, int size,
		double price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _roomService.addRoom(
			groupId, hotelId, number, type, size, price, serviceContext);
	}

	@Override
	public com.hiberus.hotels.model.Room deleteRoom(long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomService.deleteRoom(roomId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Room> findByGroupId(
		long groupId) {

		return _roomService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Room> findByHotelId(
		long hotelId) {

		return _roomService.findByHotelId(hotelId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Room> findByNumerTypeOrSize(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hiberus.hotels.model.Room> orderByComparator) {

		return _roomService.findByNumerTypeOrSize(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public com.hiberus.hotels.model.Room findRoom(long roomId) {
		return _roomService.findRoom(roomId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roomService.getOSGiServiceIdentifier();
	}

	@Override
	public com.hiberus.hotels.model.Room updateRoom(
			long roomId, long hotelId, int number, String type, int size,
			double price)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomService.updateRoom(
			roomId, hotelId, number, type, size, price);
	}

	@Override
	public RoomService getWrappedService() {
		return _roomService;
	}

	@Override
	public void setWrappedService(RoomService roomService) {
		_roomService = roomService;
	}

	private RoomService _roomService;

}