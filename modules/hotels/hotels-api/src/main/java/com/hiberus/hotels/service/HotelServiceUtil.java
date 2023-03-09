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

import com.hiberus.hotels.model.Hotel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Hotel. This utility wraps
 * <code>com.hiberus.hotels.service.impl.HotelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see HotelService
 * @generated
 */
public class HotelServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hiberus.hotels.service.impl.HotelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Hotel addHotel(
			long groupId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.hiberus.hotels.exception.HotelValidationException {

		return getService().addHotel(
			groupId, name, email, address, location, foundationDate,
			serviceContext);
	}

	public static Hotel deleteHotel(long hotelId) throws PortalException {
		return getService().deleteHotel(hotelId);
	}

	public static List<Hotel> findAllHotels() {
		return getService().findAllHotels();
	}

	public static List<Hotel> findByNameOrLocation(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getService().findByNameOrLocation(
			groupId, keywords, start, end, orderByComparator);
	}

	public static Hotel findHotel(long hotelId) {
		return getService().findHotel(hotelId);
	}

	public static List<Hotel> findHotelByGroupId(long groupId) {
		return getService().findHotelByGroupId(groupId);
	}

	public static List<Hotel> findHotelByLocation(String location) {
		return getService().findHotelByLocation(location);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Hotel updateHotel(
			long hotelId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateHotel(
			hotelId, name, email, address, location, foundationDate,
			serviceContext);
	}

	public static HotelService getService() {
		return _service;
	}

	private static volatile HotelService _service;

}