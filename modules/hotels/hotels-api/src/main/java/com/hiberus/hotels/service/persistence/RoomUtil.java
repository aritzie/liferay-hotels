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

import com.hiberus.hotels.model.Room;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the room service. This utility wraps <code>com.hiberus.hotels.service.persistence.impl.RoomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomPersistence
 * @generated
 */
public class RoomUtil {

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
	public static void clearCache(Room room) {
		getPersistence().clearCache(room);
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
	public static Map<Serializable, Room> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Room> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Room> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Room> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Room update(Room room) {
		return getPersistence().update(room);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Room update(Room room, ServiceContext serviceContext) {
		return getPersistence().update(room, serviceContext);
	}

	/**
	 * Returns all the rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rooms
	 */
	public static List<Room> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of matching rooms
	 */
	public static List<Room> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByUuid_First(
			String uuid, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUuid_First(
		String uuid, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByUuid_Last(
			String uuid, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUuid_Last(
		String uuid, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the rooms before and after the current room in the ordered set where uuid = &#63;.
	 *
	 * @param roomId the primary key of the current room
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room[] findByUuid_PrevAndNext(
			long roomId, String uuid, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_PrevAndNext(
			roomId, uuid, orderByComparator);
	}

	/**
	 * Removes all the rooms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rooms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoomException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByUUID_G(String uuid, long groupId)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the room where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the room that was removed
	 */
	public static Room removeByUUID_G(String uuid, long groupId)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of rooms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rooms
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rooms
	 */
	public static List<Room> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of matching rooms
	 */
	public static List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the rooms before and after the current room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roomId the primary key of the current room
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room[] findByUuid_C_PrevAndNext(
			long roomId, String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByUuid_C_PrevAndNext(
			roomId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the rooms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rooms
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the rooms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rooms
	 */
	public static List<Room> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the rooms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of matching rooms
	 */
	public static List<Room> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the rooms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByGroupId_First(
			long groupId, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByGroupId_First(
		long groupId, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByGroupId_Last(
			long groupId, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByGroupId_Last(
		long groupId, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the rooms before and after the current room in the ordered set where groupId = &#63;.
	 *
	 * @param roomId the primary key of the current room
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room[] findByGroupId_PrevAndNext(
			long roomId, long groupId,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByGroupId_PrevAndNext(
			roomId, groupId, orderByComparator);
	}

	/**
	 * Removes all the rooms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of rooms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rooms
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the rooms where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @return the matching rooms
	 */
	public static List<Room> findByHotelId(long hotelId) {
		return getPersistence().findByHotelId(hotelId);
	}

	/**
	 * Returns a range of all the rooms where hotelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of matching rooms
	 */
	public static List<Room> findByHotelId(long hotelId, int start, int end) {
		return getPersistence().findByHotelId(hotelId, start, end);
	}

	/**
	 * Returns an ordered range of all the rooms where hotelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByHotelId(
		long hotelId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findByHotelId(
			hotelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms where hotelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByHotelId(
		long hotelId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByHotelId(
			hotelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByHotelId_First(
			long hotelId, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_First(hotelId, orderByComparator);
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByHotelId_First(
		long hotelId, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByHotelId_First(
			hotelId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByHotelId_Last(
			long hotelId, OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_Last(hotelId, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByHotelId_Last(
		long hotelId, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByHotelId_Last(hotelId, orderByComparator);
	}

	/**
	 * Returns the rooms before and after the current room in the ordered set where hotelId = &#63;.
	 *
	 * @param roomId the primary key of the current room
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room[] findByHotelId_PrevAndNext(
			long roomId, long hotelId,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_PrevAndNext(
			roomId, hotelId, orderByComparator);
	}

	/**
	 * Removes all the rooms where hotelId = &#63; from the database.
	 *
	 * @param hotelId the hotel ID
	 */
	public static void removeByHotelId(long hotelId) {
		getPersistence().removeByHotelId(hotelId);
	}

	/**
	 * Returns the number of rooms where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @return the number of matching rooms
	 */
	public static int countByHotelId(long hotelId) {
		return getPersistence().countByHotelId(hotelId);
	}

	/**
	 * Returns all the rooms where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @return the matching rooms
	 */
	public static List<Room> findByHotelId_Type(long hotelId, String type) {
		return getPersistence().findByHotelId_Type(hotelId, type);
	}

	/**
	 * Returns a range of all the rooms where hotelId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of matching rooms
	 */
	public static List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end) {

		return getPersistence().findByHotelId_Type(hotelId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the rooms where hotelId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return getPersistence().findByHotelId_Type(
			hotelId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms where hotelId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rooms
	 */
	public static List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByHotelId_Type(
			hotelId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByHotelId_Type_First(
			long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_Type_First(
			hotelId, type, orderByComparator);
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByHotelId_Type_First(
		long hotelId, String type, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByHotelId_Type_First(
			hotelId, type, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	public static Room findByHotelId_Type_Last(
			long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_Type_Last(
			hotelId, type, orderByComparator);
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	public static Room fetchByHotelId_Type_Last(
		long hotelId, String type, OrderByComparator<Room> orderByComparator) {

		return getPersistence().fetchByHotelId_Type_Last(
			hotelId, type, orderByComparator);
	}

	/**
	 * Returns the rooms before and after the current room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param roomId the primary key of the current room
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room[] findByHotelId_Type_PrevAndNext(
			long roomId, long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByHotelId_Type_PrevAndNext(
			roomId, hotelId, type, orderByComparator);
	}

	/**
	 * Removes all the rooms where hotelId = &#63; and type = &#63; from the database.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 */
	public static void removeByHotelId_Type(long hotelId, String type) {
		getPersistence().removeByHotelId_Type(hotelId, type);
	}

	/**
	 * Returns the number of rooms where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @return the number of matching rooms
	 */
	public static int countByHotelId_Type(long hotelId, String type) {
		return getPersistence().countByHotelId_Type(hotelId, type);
	}

	/**
	 * Caches the room in the entity cache if it is enabled.
	 *
	 * @param room the room
	 */
	public static void cacheResult(Room room) {
		getPersistence().cacheResult(room);
	}

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 *
	 * @param rooms the rooms
	 */
	public static void cacheResult(List<Room> rooms) {
		getPersistence().cacheResult(rooms);
	}

	/**
	 * Creates a new room with the primary key. Does not add the room to the database.
	 *
	 * @param roomId the primary key for the new room
	 * @return the new room
	 */
	public static Room create(long roomId) {
		return getPersistence().create(roomId);
	}

	/**
	 * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the room
	 * @return the room that was removed
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room remove(long roomId)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().remove(roomId);
	}

	public static Room updateImpl(Room room) {
		return getPersistence().updateImpl(room);
	}

	/**
	 * Returns the room with the primary key or throws a <code>NoSuchRoomException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the room
	 * @return the room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	public static Room findByPrimaryKey(long roomId)
		throws com.hiberus.hotels.exception.NoSuchRoomException {

		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	 * Returns the room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the room
	 * @return the room, or <code>null</code> if a room with the primary key could not be found
	 */
	public static Room fetchByPrimaryKey(long roomId) {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	/**
	 * Returns all the rooms.
	 *
	 * @return the rooms
	 */
	public static List<Room> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @return the range of rooms
	 */
	public static List<Room> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rooms
	 */
	public static List<Room> findAll(
		int start, int end, OrderByComparator<Room> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rooms
	 * @param end the upper bound of the range of rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rooms
	 */
	public static List<Room> findAll(
		int start, int end, OrderByComparator<Room> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rooms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rooms.
	 *
	 * @return the number of rooms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoomPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoomPersistence _persistence;

}