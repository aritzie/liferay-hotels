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

import com.hiberus.hotels.model.Hotel;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the hotel service. This utility wraps <code>com.hiberus.hotels.service.persistence.impl.HotelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HotelPersistence
 * @generated
 */
public class HotelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Hotel hotel) {
		getPersistence().clearCache(hotel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Hotel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Hotel> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Hotel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Hotel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Hotel update(Hotel hotel) {
		return getPersistence().update(hotel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Hotel update(Hotel hotel, ServiceContext serviceContext) {
		return getPersistence().update(hotel, serviceContext);
	}

	/**
	 * Returns all the hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching hotels
	 */
	public static List<Hotel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Hotel> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Hotel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Hotel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByUuid_First(
			String uuid, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUuid_First(
		String uuid, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByUuid_Last(
			String uuid, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUuid_Last(
		String uuid, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where uuid = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel[] findByUuid_PrevAndNext(
			long hotelId, String uuid,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_PrevAndNext(
			hotelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the hotels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching hotels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByUUID_G(String uuid, long groupId)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the hotel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the hotel that was removed
	 */
	public static Hotel removeByUUID_G(String uuid, long groupId)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of hotels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching hotels
	 */
	public static List<Hotel> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Hotel[] findByUuid_C_PrevAndNext(
			long hotelId, String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			hotelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the hotels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching hotels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels
	 */
	public static List<Hotel> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<Hotel> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<Hotel> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<Hotel> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByGroupId_First(
			long groupId, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByGroupId_First(
		long groupId, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByGroupId_Last(
			long groupId, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByGroupId_Last(
		long groupId, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where groupId = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel[] findByGroupId_PrevAndNext(
			long hotelId, long groupId,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByGroupId_PrevAndNext(
			hotelId, groupId, orderByComparator);
	}

	/**
	 * Returns all the hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels that the user has permission to view
	 */
	public static List<Hotel> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static List<Hotel> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static List<Hotel> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the hotels before and after the current hotel in the ordered set of hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel[] filterFindByGroupId_PrevAndNext(
			long hotelId, long groupId,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			hotelId, groupId, orderByComparator);
	}

	/**
	 * Removes all the hotels where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching hotels
	 */
	public static List<Hotel> findByLocation(String location) {
		return getPersistence().findByLocation(location);
	}

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
	public static List<Hotel> findByLocation(
		String location, int start, int end) {

		return getPersistence().findByLocation(location, start, end);
	}

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
	public static List<Hotel> findByLocation(
		String location, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findByLocation(
			location, start, end, orderByComparator);
	}

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
	public static List<Hotel> findByLocation(
		String location, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLocation(
			location, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByLocation_First(
			String location, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByLocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByLocation_First(
		String location, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByLocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	public static Hotel findByLocation_Last(
			String location, OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByLocation_Last(
			location, orderByComparator);
	}

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchByLocation_Last(
		String location, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().fetchByLocation_Last(
			location, orderByComparator);
	}

	/**
	 * Returns the hotels before and after the current hotel in the ordered set where location = &#63;.
	 *
	 * @param hotelId the primary key of the current hotel
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel[] findByLocation_PrevAndNext(
			long hotelId, String location,
			OrderByComparator<Hotel> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByLocation_PrevAndNext(
			hotelId, location, orderByComparator);
	}

	/**
	 * Removes all the hotels where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public static void removeByLocation(String location) {
		getPersistence().removeByLocation(location);
	}

	/**
	 * Returns the number of hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching hotels
	 */
	public static int countByLocation(String location) {
		return getPersistence().countByLocation(location);
	}

	/**
	 * Caches the hotel in the entity cache if it is enabled.
	 *
	 * @param hotel the hotel
	 */
	public static void cacheResult(Hotel hotel) {
		getPersistence().cacheResult(hotel);
	}

	/**
	 * Caches the hotels in the entity cache if it is enabled.
	 *
	 * @param hotels the hotels
	 */
	public static void cacheResult(List<Hotel> hotels) {
		getPersistence().cacheResult(hotels);
	}

	/**
	 * Creates a new hotel with the primary key. Does not add the hotel to the database.
	 *
	 * @param hotelId the primary key for the new hotel
	 * @return the new hotel
	 */
	public static Hotel create(long hotelId) {
		return getPersistence().create(hotelId);
	}

	/**
	 * Removes the hotel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel that was removed
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel remove(long hotelId)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().remove(hotelId);
	}

	public static Hotel updateImpl(Hotel hotel) {
		return getPersistence().updateImpl(hotel);
	}

	/**
	 * Returns the hotel with the primary key or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	public static Hotel findByPrimaryKey(long hotelId)
		throws com.hiberus.hotels.exception.NoSuchHotelException {

		return getPersistence().findByPrimaryKey(hotelId);
	}

	/**
	 * Returns the hotel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel, or <code>null</code> if a hotel with the primary key could not be found
	 */
	public static Hotel fetchByPrimaryKey(long hotelId) {
		return getPersistence().fetchByPrimaryKey(hotelId);
	}

	/**
	 * Returns all the hotels.
	 *
	 * @return the hotels
	 */
	public static List<Hotel> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Hotel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Hotel> findAll(
		int start, int end, OrderByComparator<Hotel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Hotel> findAll(
		int start, int end, OrderByComparator<Hotel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the hotels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of hotels.
	 *
	 * @return the number of hotels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HotelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HotelPersistence _persistence;

}