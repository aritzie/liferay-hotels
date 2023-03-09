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
 * Provides a wrapper for {@link HotelService}.
 *
 * @author Brian Wing Shun Chan
 * @see HotelService
 * @generated
 */
public class HotelServiceWrapper
	implements HotelService, ServiceWrapper<HotelService> {

	public HotelServiceWrapper() {
		this(null);
	}

	public HotelServiceWrapper(HotelService hotelService) {
		_hotelService = hotelService;
	}

	@Override
	public com.hiberus.hotels.model.Hotel addHotel(
			long groupId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.hiberus.hotels.exception.HotelValidationException {

		return _hotelService.addHotel(
			groupId, name, email, address, location, foundationDate,
			serviceContext);
	}

	@Override
	public com.hiberus.hotels.model.Hotel deleteHotel(long hotelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelService.deleteHotel(hotelId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findAllHotels() {
		return _hotelService.findAllHotels();
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findByNameOrLocation(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hiberus.hotels.model.Hotel> orderByComparator) {

		return _hotelService.findByNameOrLocation(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public com.hiberus.hotels.model.Hotel findHotel(long hotelId) {
		return _hotelService.findHotel(hotelId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findHotelByGroupId(
		long groupId) {

		return _hotelService.findHotelByGroupId(groupId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findHotelByLocation(
		String location) {

		return _hotelService.findHotelByLocation(location);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hotelService.getOSGiServiceIdentifier();
	}

	@Override
	public com.hiberus.hotels.model.Hotel updateHotel(
			long hotelId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelService.updateHotel(
			hotelId, name, email, address, location, foundationDate,
			serviceContext);
	}

	@Override
	public HotelService getWrappedService() {
		return _hotelService;
	}

	@Override
	public void setWrappedService(HotelService hotelService) {
		_hotelService = hotelService;
	}

	private HotelService _hotelService;

}