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

package com.hiberus.hotels.service.persistence.impl;

import com.hiberus.hotels.exception.NoSuchRoomException;
import com.hiberus.hotels.model.Room;
import com.hiberus.hotels.model.RoomTable;
import com.hiberus.hotels.model.impl.RoomImpl;
import com.hiberus.hotels.model.impl.RoomModelImpl;
import com.hiberus.hotels.service.persistence.RoomPersistence;
import com.hiberus.hotels.service.persistence.RoomUtil;
import com.hiberus.hotels.service.persistence.impl.constants.HOTELSPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {RoomPersistence.class, BasePersistence.class})
public class RoomPersistenceImpl
	extends BasePersistenceImpl<Room> implements RoomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RoomUtil</code> to access the room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RoomImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rooms
	 */
	@Override
	public List<Room> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Room> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Room> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Room room : list) {
					if (!uuid.equals(room.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByUuid_First(
			String uuid, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByUuid_First(uuid, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUuid_First(
		String uuid, OrderByComparator<Room> orderByComparator) {

		List<Room> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByUuid_Last(
			String uuid, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByUuid_Last(uuid, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUuid_Last(
		String uuid, OrderByComparator<Room> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Room> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room[] findByUuid_PrevAndNext(
			long roomId, String uuid, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		uuid = Objects.toString(uuid, "");

		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, room, uuid, orderByComparator, true);

			array[1] = room;

			array[2] = getByUuid_PrevAndNext(
				session, room, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Room getByUuid_PrevAndNext(
		Session session, Room room, String uuid,
		OrderByComparator<Room> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROOM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(room)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Room> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rooms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Room room :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(room);
		}
	}

	/**
	 * Returns the number of rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rooms
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "room.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(room.uuid IS NULL OR room.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoomException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByUUID_G(String uuid, long groupId)
		throws NoSuchRoomException {

		Room room = fetchByUUID_G(uuid, groupId);

		if (room == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRoomException(sb.toString());
		}

		return room;
	}

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Room) {
			Room room = (Room)result;

			if (!Objects.equals(uuid, room.getUuid()) ||
				(groupId != room.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Room> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Room room = list.get(0);

					result = room;

					cacheResult(room);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Room)result;
		}
	}

	/**
	 * Removes the room where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the room that was removed
	 */
	@Override
	public Room removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoomException {

		Room room = findByUUID_G(uuid, groupId);

		return remove(room);
	}

	/**
	 * Returns the number of rooms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rooms
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"room.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(room.uuid IS NULL OR room.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"room.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rooms
	 */
	@Override
	public List<Room> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Room> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Room room : list) {
					if (!uuid.equals(room.getUuid()) ||
						(companyId != room.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Room findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Room> orderByComparator) {

		List<Room> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Room> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Room> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room[] findByUuid_C_PrevAndNext(
			long roomId, String uuid, long companyId,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		uuid = Objects.toString(uuid, "");

		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, room, uuid, companyId, orderByComparator, true);

			array[1] = room;

			array[2] = getByUuid_C_PrevAndNext(
				session, room, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Room getByUuid_C_PrevAndNext(
		Session session, Room room, String uuid, long companyId,
		OrderByComparator<Room> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ROOM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(room)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Room> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rooms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Room room :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(room);
		}
	}

	/**
	 * Returns the number of rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rooms
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"room.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(room.uuid IS NULL OR room.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"room.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the rooms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rooms
	 */
	@Override
	public List<Room> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Room> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Room> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Room room : list) {
					if (groupId != room.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByGroupId_First(
			long groupId, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByGroupId_First(groupId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the first room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByGroupId_First(
		long groupId, OrderByComparator<Room> orderByComparator) {

		List<Room> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByGroupId_Last(
			long groupId, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByGroupId_Last(groupId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the last room in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByGroupId_Last(
		long groupId, OrderByComparator<Room> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Room> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room[] findByGroupId_PrevAndNext(
			long roomId, long groupId,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, room, groupId, orderByComparator, true);

			array[1] = room;

			array[2] = getByGroupId_PrevAndNext(
				session, room, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Room getByGroupId_PrevAndNext(
		Session session, Room room, long groupId,
		OrderByComparator<Room> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROOM_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(room)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Room> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rooms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Room room :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(room);
		}
	}

	/**
	 * Returns the number of rooms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rooms
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"room.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByHotelId;
	private FinderPath _finderPathWithoutPaginationFindByHotelId;
	private FinderPath _finderPathCountByHotelId;

	/**
	 * Returns all the rooms where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @return the matching rooms
	 */
	@Override
	public List<Room> findByHotelId(long hotelId) {
		return findByHotelId(
			hotelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findByHotelId(long hotelId, int start, int end) {
		return findByHotelId(hotelId, start, end, null);
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
	@Override
	public List<Room> findByHotelId(
		long hotelId, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return findByHotelId(hotelId, start, end, orderByComparator, true);
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
	@Override
	public List<Room> findByHotelId(
		long hotelId, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByHotelId;
				finderArgs = new Object[] {hotelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByHotelId;
			finderArgs = new Object[] {hotelId, start, end, orderByComparator};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Room room : list) {
					if (hotelId != room.getHotelId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_HOTELID_HOTELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hotelId);

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByHotelId_First(
			long hotelId, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByHotelId_First(hotelId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hotelId=");
		sb.append(hotelId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByHotelId_First(
		long hotelId, OrderByComparator<Room> orderByComparator) {

		List<Room> list = findByHotelId(hotelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room
	 * @throws NoSuchRoomException if a matching room could not be found
	 */
	@Override
	public Room findByHotelId_Last(
			long hotelId, OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByHotelId_Last(hotelId, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hotelId=");
		sb.append(hotelId);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByHotelId_Last(
		long hotelId, OrderByComparator<Room> orderByComparator) {

		int count = countByHotelId(hotelId);

		if (count == 0) {
			return null;
		}

		List<Room> list = findByHotelId(
			hotelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room[] findByHotelId_PrevAndNext(
			long roomId, long hotelId,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByHotelId_PrevAndNext(
				session, room, hotelId, orderByComparator, true);

			array[1] = room;

			array[2] = getByHotelId_PrevAndNext(
				session, room, hotelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Room getByHotelId_PrevAndNext(
		Session session, Room room, long hotelId,
		OrderByComparator<Room> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROOM_WHERE);

		sb.append(_FINDER_COLUMN_HOTELID_HOTELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(hotelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(room)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Room> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rooms where hotelId = &#63; from the database.
	 *
	 * @param hotelId the hotel ID
	 */
	@Override
	public void removeByHotelId(long hotelId) {
		for (Room room :
				findByHotelId(
					hotelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(room);
		}
	}

	/**
	 * Returns the number of rooms where hotelId = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @return the number of matching rooms
	 */
	@Override
	public int countByHotelId(long hotelId) {
		FinderPath finderPath = _finderPathCountByHotelId;

		Object[] finderArgs = new Object[] {hotelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_HOTELID_HOTELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hotelId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_HOTELID_HOTELID_2 =
		"room.hotelId = ?";

	private FinderPath _finderPathWithPaginationFindByHotelId_Type;
	private FinderPath _finderPathWithoutPaginationFindByHotelId_Type;
	private FinderPath _finderPathCountByHotelId_Type;

	/**
	 * Returns all the rooms where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @return the matching rooms
	 */
	@Override
	public List<Room> findByHotelId_Type(long hotelId, String type) {
		return findByHotelId_Type(
			hotelId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end) {

		return findByHotelId_Type(hotelId, type, start, end, null);
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
	@Override
	public List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end,
		OrderByComparator<Room> orderByComparator) {

		return findByHotelId_Type(
			hotelId, type, start, end, orderByComparator, true);
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
	@Override
	public List<Room> findByHotelId_Type(
		long hotelId, String type, int start, int end,
		OrderByComparator<Room> orderByComparator, boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByHotelId_Type;
				finderArgs = new Object[] {hotelId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByHotelId_Type;
			finderArgs = new Object[] {
				hotelId, type, start, end, orderByComparator
			};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Room room : list) {
					if ((hotelId != room.getHotelId()) ||
						!type.equals(room.getType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_HOTELID_TYPE_HOTELID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hotelId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Room findByHotelId_Type_First(
			long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByHotelId_Type_First(hotelId, type, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hotelId=");
		sb.append(hotelId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the first room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByHotelId_Type_First(
		long hotelId, String type, OrderByComparator<Room> orderByComparator) {

		List<Room> list = findByHotelId_Type(
			hotelId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room findByHotelId_Type_Last(
			long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		Room room = fetchByHotelId_Type_Last(hotelId, type, orderByComparator);

		if (room != null) {
			return room;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hotelId=");
		sb.append(hotelId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchRoomException(sb.toString());
	}

	/**
	 * Returns the last room in the ordered set where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room, or <code>null</code> if a matching room could not be found
	 */
	@Override
	public Room fetchByHotelId_Type_Last(
		long hotelId, String type, OrderByComparator<Room> orderByComparator) {

		int count = countByHotelId_Type(hotelId, type);

		if (count == 0) {
			return null;
		}

		List<Room> list = findByHotelId_Type(
			hotelId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Room[] findByHotelId_Type_PrevAndNext(
			long roomId, long hotelId, String type,
			OrderByComparator<Room> orderByComparator)
		throws NoSuchRoomException {

		type = Objects.toString(type, "");

		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByHotelId_Type_PrevAndNext(
				session, room, hotelId, type, orderByComparator, true);

			array[1] = room;

			array[2] = getByHotelId_Type_PrevAndNext(
				session, room, hotelId, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Room getByHotelId_Type_PrevAndNext(
		Session session, Room room, long hotelId, String type,
		OrderByComparator<Room> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ROOM_WHERE);

		sb.append(_FINDER_COLUMN_HOTELID_TYPE_HOTELID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(hotelId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(room)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Room> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rooms where hotelId = &#63; and type = &#63; from the database.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 */
	@Override
	public void removeByHotelId_Type(long hotelId, String type) {
		for (Room room :
				findByHotelId_Type(
					hotelId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(room);
		}
	}

	/**
	 * Returns the number of rooms where hotelId = &#63; and type = &#63;.
	 *
	 * @param hotelId the hotel ID
	 * @param type the type
	 * @return the number of matching rooms
	 */
	@Override
	public int countByHotelId_Type(long hotelId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByHotelId_Type;

		Object[] finderArgs = new Object[] {hotelId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROOM_WHERE);

			sb.append(_FINDER_COLUMN_HOTELID_TYPE_HOTELID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_HOTELID_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hotelId);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_HOTELID_TYPE_HOTELID_2 =
		"room.hotelId = ? AND ";

	private static final String _FINDER_COLUMN_HOTELID_TYPE_TYPE_2 =
		"room.type = ?";

	private static final String _FINDER_COLUMN_HOTELID_TYPE_TYPE_3 =
		"(room.type IS NULL OR room.type = '')";

	public RoomPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("number", "number_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("size", "size_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Room.class);

		setModelImplClass(RoomImpl.class);
		setModelPKClass(long.class);

		setTable(RoomTable.INSTANCE);
	}

	/**
	 * Caches the room in the entity cache if it is enabled.
	 *
	 * @param room the room
	 */
	@Override
	public void cacheResult(Room room) {
		entityCache.putResult(RoomImpl.class, room.getPrimaryKey(), room);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {room.getUuid(), room.getGroupId()}, room);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 *
	 * @param rooms the rooms
	 */
	@Override
	public void cacheResult(List<Room> rooms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rooms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Room room : rooms) {
			if (entityCache.getResult(RoomImpl.class, room.getPrimaryKey()) ==
					null) {

				cacheResult(room);
			}
		}
	}

	/**
	 * Clears the cache for all rooms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RoomImpl.class);

		finderCache.clearCache(RoomImpl.class);
	}

	/**
	 * Clears the cache for the room.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Room room) {
		entityCache.removeResult(RoomImpl.class, room);
	}

	@Override
	public void clearCache(List<Room> rooms) {
		for (Room room : rooms) {
			entityCache.removeResult(RoomImpl.class, room);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RoomImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RoomImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(RoomModelImpl roomModelImpl) {
		Object[] args = new Object[] {
			roomModelImpl.getUuid(), roomModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, roomModelImpl);
	}

	/**
	 * Creates a new room with the primary key. Does not add the room to the database.
	 *
	 * @param roomId the primary key for the new room
	 * @return the new room
	 */
	@Override
	public Room create(long roomId) {
		Room room = new RoomImpl();

		room.setNew(true);
		room.setPrimaryKey(roomId);

		String uuid = _portalUUID.generate();

		room.setUuid(uuid);

		room.setCompanyId(CompanyThreadLocal.getCompanyId());

		return room;
	}

	/**
	 * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the room
	 * @return the room that was removed
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	@Override
	public Room remove(long roomId) throws NoSuchRoomException {
		return remove((Serializable)roomId);
	}

	/**
	 * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the room
	 * @return the room that was removed
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	@Override
	public Room remove(Serializable primaryKey) throws NoSuchRoomException {
		Session session = null;

		try {
			session = openSession();

			Room room = (Room)session.get(RoomImpl.class, primaryKey);

			if (room == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(room);
		}
		catch (NoSuchRoomException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Room removeImpl(Room room) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(room)) {
				room = (Room)session.get(
					RoomImpl.class, room.getPrimaryKeyObj());
			}

			if (room != null) {
				session.delete(room);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (room != null) {
			clearCache(room);
		}

		return room;
	}

	@Override
	public Room updateImpl(Room room) {
		boolean isNew = room.isNew();

		if (!(room instanceof RoomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(room.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(room);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in room proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Room implementation " +
					room.getClass());
		}

		RoomModelImpl roomModelImpl = (RoomModelImpl)room;

		if (Validator.isNull(room.getUuid())) {
			String uuid = _portalUUID.generate();

			room.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (room.getCreateDate() == null)) {
			if (serviceContext == null) {
				room.setCreateDate(date);
			}
			else {
				room.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!roomModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				room.setModifiedDate(date);
			}
			else {
				room.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(room);
			}
			else {
				room = (Room)session.merge(room);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(RoomImpl.class, roomModelImpl, false, true);

		cacheUniqueFindersCache(roomModelImpl);

		if (isNew) {
			room.setNew(false);
		}

		room.resetOriginalValues();

		return room;
	}

	/**
	 * Returns the room with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the room
	 * @return the room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	@Override
	public Room findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoomException {

		Room room = fetchByPrimaryKey(primaryKey);

		if (room == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return room;
	}

	/**
	 * Returns the room with the primary key or throws a <code>NoSuchRoomException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the room
	 * @return the room
	 * @throws NoSuchRoomException if a room with the primary key could not be found
	 */
	@Override
	public Room findByPrimaryKey(long roomId) throws NoSuchRoomException {
		return findByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns the room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the room
	 * @return the room, or <code>null</code> if a room with the primary key could not be found
	 */
	@Override
	public Room fetchByPrimaryKey(long roomId) {
		return fetchByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns all the rooms.
	 *
	 * @return the rooms
	 */
	@Override
	public List<Room> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Room> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Room> findAll(
		int start, int end, OrderByComparator<Room> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Room> findAll(
		int start, int end, OrderByComparator<Room> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Room> list = null;

		if (useFinderCache) {
			list = (List<Room>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROOM;

				sql = sql.concat(RoomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Room>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rooms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Room room : findAll()) {
			remove(room);
		}
	}

	/**
	 * Returns the number of rooms.
	 *
	 * @return the number of rooms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROOM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "roomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RoomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the room persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByHotelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHotelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"hotelId"}, true);

		_finderPathWithoutPaginationFindByHotelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHotelId",
			new String[] {Long.class.getName()}, new String[] {"hotelId"},
			true);

		_finderPathCountByHotelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHotelId",
			new String[] {Long.class.getName()}, new String[] {"hotelId"},
			false);

		_finderPathWithPaginationFindByHotelId_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHotelId_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"hotelId", "type_"}, true);

		_finderPathWithoutPaginationFindByHotelId_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHotelId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"hotelId", "type_"}, true);

		_finderPathCountByHotelId_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHotelId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"hotelId", "type_"}, false);

		_setRoomUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRoomUtilPersistence(null);

		entityCache.removeCache(RoomImpl.class.getName());
	}

	private void _setRoomUtilPersistence(RoomPersistence roomPersistence) {
		try {
			Field field = RoomUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, roomPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = HOTELSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = HOTELSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HOTELSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ROOM = "SELECT room FROM Room room";

	private static final String _SQL_SELECT_ROOM_WHERE =
		"SELECT room FROM Room room WHERE ";

	private static final String _SQL_COUNT_ROOM =
		"SELECT COUNT(room) FROM Room room";

	private static final String _SQL_COUNT_ROOM_WHERE =
		"SELECT COUNT(room) FROM Room room WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "room.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Room exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Room exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RoomPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "number", "type", "size"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}