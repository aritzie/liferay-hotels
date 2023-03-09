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

package com.hiberus.hotels.service.persistence;

import com.hiberus.hotels.exception.NoSuchHotelException;
import com.hiberus.hotels.model.Hotel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the hotel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HotelUtil
 * @generated
 */
@ProviderType
public interface HotelPersistence extends BasePersistence<Hotel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HotelUtil} to access the hotel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching hotels
	 */
	public java.util.List<Hotel> findByUuid(String uuid);

	/**
	 * Returns a range of all the hotels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the hotels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hotels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where uuid = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel[] findByUuid_PrevAndNext(
			long hotelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Removes all the hotels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching hotels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByUUID_G(String uuid, long groupId)
		throws NoSuchHotelException;

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the hotel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the hotel that was removed
	 */
	public Hotel removeByUUID_G(String uuid, long groupId)
		throws NoSuchHotelException;

	/**
	 * Returns the number of hotels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching hotels
	 */
	public java.util.List<Hotel> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel[] findByUuid_C_PrevAndNext(
			long hotelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Removes all the hotels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching hotels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels
	 */
	public java.util.List<Hotel> findByGroupId(long groupId);

	/**
	 * Returns a range of all the hotels where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of matching hotels
	 */
	public java.util.List<Hotel> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the hotels where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hotels where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where groupId = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel[] findByGroupId_PrevAndNext(
			long hotelId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns all the hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels that the user has permission to view
	 */
	public java.util.List<Hotel> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the hotels that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of matching hotels that the user has permission to view
	 */
	public java.util.List<Hotel> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the hotels that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hotels that the user has permission to view
	 */
	public java.util.List<Hotel> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the hotels before and after the current hotel in the ordered set of hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel[] filterFindByGroupId_PrevAndNext(
			long hotelId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Removes all the hotels where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching hotels
	 */
	public java.util.List<Hotel> findByLocation(String location);

	/**
	 * Returns a range of all the hotels where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of matching hotels
	 */
	public java.util.List<Hotel> findByLocation(
		String location, int start, int end);

	/**
	 * Returns an ordered range of all the hotels where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByLocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hotels where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hotels
	 */
	public java.util.List<Hotel> findByLocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByLocation_First(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByLocation_First(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public Hotel findByLocation_Last(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public Hotel fetchByLocation_Last(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where location = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel[] findByLocation_PrevAndNext(
			long hotelId, String location,
			com.liferay.portal.kernel.util.OrderByComparator<Hotel>
				orderByComparator)
		throws NoSuchHotelException;

	/**
	 * Removes all the hotels where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public void removeByLocation(String location);

	/**
	 * Returns the number of hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching hotels
	 */
	public int countByLocation(String location);

	/**
	 * Caches the hotel in the entity cache if it is enabled.
	 *
	 * @param hotel the hotel
	 */
	public void cacheResult(Hotel hotel);

	/**
	 * Caches the hotels in the entity cache if it is enabled.
	 *
	 * @param hotels the hotels
	 */
	public void cacheResult(java.util.List<Hotel> hotels);

	/**
	 * Creates a new hotel with the primary key. Does not add the hotel to the database.
	 *
	 * @param hotelId the primary key for the new hotel
	 * @return the new hotel
	 */
	public Hotel create(long hotelId);

	/**
	 * Removes the hotel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel that was removed
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel remove(long hotelId) throws NoSuchHotelException;

	public Hotel updateImpl(Hotel hotel);

	/**
	 * Returns the hotel with the primary key or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public Hotel findByPrimaryKey(long hotelId) throws NoSuchHotelException;

	/**
	 * Returns the hotel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel, or <code>null</code> if a hotel with the primary key could not be found
	 */
	public Hotel fetchByPrimaryKey(long hotelId);

	/**
	 * Returns all the hotels.
	 *
	 * @return the hotels
	 */
	public java.util.List<Hotel> findAll();

	/**
	 * Returns a range of all the hotels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of hotels
	 */
	public java.util.List<Hotel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the hotels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hotels
	 */
	public java.util.List<Hotel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hotels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HotelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hotels
	 */
	public java.util.List<Hotel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hotel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the hotels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hotels.
	 *
	 * @return the number of hotels
	 */
	public int countAll();

}