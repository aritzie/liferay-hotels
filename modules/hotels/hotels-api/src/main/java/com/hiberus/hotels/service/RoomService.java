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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Room. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RoomServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RoomService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.hiberus.hotels.service.impl.RoomServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the room remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RoomServiceUtil} if injection and service tracking are not available.
	 */
	public Room addRoom(
		long groupId, long hotelId, int number, String type, int size,
		double price, ServiceContext serviceContext);

	public Room deleteRoom(long roomId) throws PortalException;

	public List<Room> findByGroupId(long groupId);

	public List<Room> findByHotelId(long hotelId);

	public List<Room> findByNumerTypeOrSize(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Room> orderByComparator);

	public Room findRoom(long roomId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Room updateRoom(
			long roomId, long hotelId, int number, String type, int size,
			double price)
		throws PortalException;

}