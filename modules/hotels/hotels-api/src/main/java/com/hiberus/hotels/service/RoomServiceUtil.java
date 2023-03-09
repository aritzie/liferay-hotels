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

import com.hiberus.hotels.model.Room;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Room. This utility wraps
 * <code>com.hiberus.hotels.service.impl.RoomServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RoomService
 * @generated
 */
public class RoomServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hiberus.hotels.service.impl.RoomServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Room addRoom(
		long groupId, long hotelId, int number, String type, int size,
		double price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addRoom(
			groupId, hotelId, number, type, size, price, serviceContext);
	}

	public static Room deleteRoom(long roomId) throws PortalException {
		return getService().deleteRoom(roomId);
	}

	public static List<Room> findByGroupId(long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static List<Room> findByHotelId(long hotelId) {
		return getService().findByHotelId(hotelId);
	}

	public static List<Room> findByNumerTypeOrSize(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getService().findByNumerTypeOrSize(
			groupId, keywords, start, end, orderByComparator);
	}

	public static Room findRoom(long roomId) {
		return getService().findRoom(roomId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Room updateRoom(
			long roomId, long hotelId, int number, String type, int size,
			double price)
		throws PortalException {

		return getService().updateRoom(
			roomId, hotelId, number, type, size, price);
	}

	public static RoomService getService() {
		return _service;
	}

	private static volatile RoomService _service;

}