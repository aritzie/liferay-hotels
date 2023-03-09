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

import com.hiberus.hotels.exception.NoSuchHotelException;
import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.model.HotelTable;
import com.hiberus.hotels.model.impl.HotelImpl;
import com.hiberus.hotels.model.impl.HotelModelImpl;
import com.hiberus.hotels.service.persistence.HotelPersistence;
import com.hiberus.hotels.service.persistence.HotelUtil;
import com.hiberus.hotels.service.persistence.impl.constants.HOTELSPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
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
 * The persistence implementation for the hotel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {HotelPersistence.class, BasePersistence.class})
public class HotelPersistenceImpl
	extends BasePersistenceImpl<Hotel> implements HotelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HotelUtil</code> to access the hotel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HotelImpl.class.getName();

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
	 * Returns all the hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching hotels
	 */
	@Override
	public List<Hotel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Hotel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Hotel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

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

		List<Hotel> list = null;

		if (useFinderCache) {
			list = (List<Hotel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Hotel hotel : list) {
					if (!uuid.equals(hotel.getUuid())) {
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

			sb.append(_SQL_SELECT_HOTEL_WHERE);

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
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
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

				list = (List<Hotel>)QueryUtil.list(
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
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByUuid_First(
			String uuid, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByUuid_First(uuid, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUuid_First(
		String uuid, OrderByComparator<Hotel> orderByComparator) {

		List<Hotel> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByUuid_Last(
			String uuid, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByUuid_Last(uuid, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUuid_Last(
		String uuid, OrderByComparator<Hotel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Hotel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Hotel[] findByUuid_PrevAndNext(
			long hotelId, String uuid,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		uuid = Objects.toString(uuid, "");

		Hotel hotel = findByPrimaryKey(hotelId);

		Session session = null;

		try {
			session = openSession();

			Hotel[] array = new HotelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, hotel, uuid, orderByComparator, true);

			array[1] = hotel;

			array[2] = getByUuid_PrevAndNext(
				session, hotel, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hotel getByUuid_PrevAndNext(
		Session session, Hotel hotel, String uuid,
		OrderByComparator<Hotel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HOTEL_WHERE);

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
			sb.append(HotelModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(hotel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hotel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hotels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Hotel hotel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hotel);
		}
	}

	/**
	 * Returns the number of hotels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching hotels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOTEL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "hotel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(hotel.uuid IS NULL OR hotel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByUUID_G(String uuid, long groupId)
		throws NoSuchHotelException {

		Hotel hotel = fetchByUUID_G(uuid, groupId);

		if (hotel == null) {
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

			throw new NoSuchHotelException(sb.toString());
		}

		return hotel;
	}

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the hotel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUUID_G(
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

		if (result instanceof Hotel) {
			Hotel hotel = (Hotel)result;

			if (!Objects.equals(uuid, hotel.getUuid()) ||
				(groupId != hotel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_HOTEL_WHERE);

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

				List<Hotel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Hotel hotel = list.get(0);

					result = hotel;

					cacheResult(hotel);
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
			return (Hotel)result;
		}
	}

	/**
	 * Removes the hotel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the hotel that was removed
	 */
	@Override
	public Hotel removeByUUID_G(String uuid, long groupId)
		throws NoSuchHotelException {

		Hotel hotel = findByUUID_G(uuid, groupId);

		return remove(hotel);
	}

	/**
	 * Returns the number of hotels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HOTEL_WHERE);

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
		"hotel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(hotel.uuid IS NULL OR hotel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"hotel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching hotels
	 */
	@Override
	public List<Hotel> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Hotel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

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

		List<Hotel> list = null;

		if (useFinderCache) {
			list = (List<Hotel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Hotel hotel : list) {
					if (!uuid.equals(hotel.getUuid()) ||
						(companyId != hotel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_HOTEL_WHERE);

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
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
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

				list = (List<Hotel>)QueryUtil.list(
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
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the first hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Hotel> orderByComparator) {

		List<Hotel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Hotel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the last hotel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Hotel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Hotel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Hotel[] findByUuid_C_PrevAndNext(
			long hotelId, String uuid, long companyId,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		uuid = Objects.toString(uuid, "");

		Hotel hotel = findByPrimaryKey(hotelId);

		Session session = null;

		try {
			session = openSession();

			Hotel[] array = new HotelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, hotel, uuid, companyId, orderByComparator, true);

			array[1] = hotel;

			array[2] = getByUuid_C_PrevAndNext(
				session, hotel, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hotel getByUuid_C_PrevAndNext(
		Session session, Hotel hotel, String uuid, long companyId,
		OrderByComparator<Hotel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_HOTEL_WHERE);

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
			sb.append(HotelModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(hotel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hotel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hotels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Hotel hotel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(hotel);
		}
	}

	/**
	 * Returns the number of hotels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching hotels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HOTEL_WHERE);

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
		"hotel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(hotel.uuid IS NULL OR hotel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"hotel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels
	 */
	@Override
	public List<Hotel> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Hotel> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Hotel> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

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

		List<Hotel> list = null;

		if (useFinderCache) {
			list = (List<Hotel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Hotel hotel : list) {
					if (groupId != hotel.getGroupId()) {
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

			sb.append(_SQL_SELECT_HOTEL_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Hotel>)QueryUtil.list(
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
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByGroupId_First(
			long groupId, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByGroupId_First(groupId, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the first hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByGroupId_First(
		long groupId, OrderByComparator<Hotel> orderByComparator) {

		List<Hotel> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByGroupId_Last(
			long groupId, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByGroupId_Last(groupId, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the last hotel in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByGroupId_Last(
		long groupId, OrderByComparator<Hotel> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Hotel> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Hotel[] findByGroupId_PrevAndNext(
			long hotelId, long groupId,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = findByPrimaryKey(hotelId);

		Session session = null;

		try {
			session = openSession();

			Hotel[] array = new HotelImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, hotel, groupId, orderByComparator, true);

			array[1] = hotel;

			array[2] = getByGroupId_PrevAndNext(
				session, hotel, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hotel getByGroupId_PrevAndNext(
		Session session, Hotel hotel, long groupId,
		OrderByComparator<Hotel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HOTEL_WHERE);

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
			sb.append(HotelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hotel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hotel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hotels that the user has permission to view
	 */
	@Override
	public List<Hotel> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> filterFindByGroupId(long groupId, int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<Hotel> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_HOTEL_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(HotelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Hotel.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, HotelImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, HotelImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<Hotel>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Hotel[] filterFindByGroupId_PrevAndNext(
			long hotelId, long groupId,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				hotelId, groupId, orderByComparator);
		}

		Hotel hotel = findByPrimaryKey(hotelId);

		Session session = null;

		try {
			session = openSession();

			Hotel[] array = new HotelImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, hotel, groupId, orderByComparator, true);

			array[1] = hotel;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, hotel, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hotel filterGetByGroupId_PrevAndNext(
		Session session, Hotel hotel, long groupId,
		OrderByComparator<Hotel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_HOTEL_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(HotelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Hotel.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, HotelImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, HotelImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hotel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hotel> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hotels where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Hotel hotel :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hotel);
		}
	}

	/**
	 * Returns the number of hotels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOTEL_WHERE);

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

	/**
	 * Returns the number of hotels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hotels that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_HOTEL_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Hotel.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"hotel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByLocation;
	private FinderPath _finderPathWithoutPaginationFindByLocation;
	private FinderPath _finderPathCountByLocation;

	/**
	 * Returns all the hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching hotels
	 */
	@Override
	public List<Hotel> findByLocation(String location) {
		return findByLocation(
			location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> findByLocation(String location, int start, int end) {
		return findByLocation(location, start, end, null);
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
	@Override
	public List<Hotel> findByLocation(
		String location, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return findByLocation(location, start, end, orderByComparator, true);
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
	@Override
	public List<Hotel> findByLocation(
		String location, int start, int end,
		OrderByComparator<Hotel> orderByComparator, boolean useFinderCache) {

		location = Objects.toString(location, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLocation;
				finderArgs = new Object[] {location};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLocation;
			finderArgs = new Object[] {location, start, end, orderByComparator};
		}

		List<Hotel> list = null;

		if (useFinderCache) {
			list = (List<Hotel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Hotel hotel : list) {
					if (!location.equals(hotel.getLocation())) {
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

			sb.append(_SQL_SELECT_HOTEL_WHERE);

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HotelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLocation) {
					queryPos.add(location);
				}

				list = (List<Hotel>)QueryUtil.list(
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
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByLocation_First(
			String location, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByLocation_First(location, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the first hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByLocation_First(
		String location, OrderByComparator<Hotel> orderByComparator) {

		List<Hotel> list = findByLocation(location, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel
	 * @throws NoSuchHotelException if a matching hotel could not be found
	 */
	@Override
	public Hotel findByLocation_Last(
			String location, OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		Hotel hotel = fetchByLocation_Last(location, orderByComparator);

		if (hotel != null) {
			return hotel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchHotelException(sb.toString());
	}

	/**
	 * Returns the last hotel in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public Hotel fetchByLocation_Last(
		String location, OrderByComparator<Hotel> orderByComparator) {

		int count = countByLocation(location);

		if (count == 0) {
			return null;
		}

		List<Hotel> list = findByLocation(
			location, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Hotel[] findByLocation_PrevAndNext(
			long hotelId, String location,
			OrderByComparator<Hotel> orderByComparator)
		throws NoSuchHotelException {

		location = Objects.toString(location, "");

		Hotel hotel = findByPrimaryKey(hotelId);

		Session session = null;

		try {
			session = openSession();

			Hotel[] array = new HotelImpl[3];

			array[0] = getByLocation_PrevAndNext(
				session, hotel, location, orderByComparator, true);

			array[1] = hotel;

			array[2] = getByLocation_PrevAndNext(
				session, hotel, location, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hotel getByLocation_PrevAndNext(
		Session session, Hotel hotel, String location,
		OrderByComparator<Hotel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HOTEL_WHERE);

		boolean bindLocation = false;

		if (location.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
		}
		else {
			bindLocation = true;

			sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
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
			sb.append(HotelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLocation) {
			queryPos.add(location);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hotel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hotel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hotels where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	@Override
	public void removeByLocation(String location) {
		for (Hotel hotel :
				findByLocation(
					location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hotel);
		}
	}

	/**
	 * Returns the number of hotels where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching hotels
	 */
	@Override
	public int countByLocation(String location) {
		location = Objects.toString(location, "");

		FinderPath finderPath = _finderPathCountByLocation;

		Object[] finderArgs = new Object[] {location};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOTEL_WHERE);

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLocation) {
					queryPos.add(location);
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

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_2 =
		"hotel.location = ?";

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_3 =
		"(hotel.location IS NULL OR hotel.location = '')";

	public HotelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Hotel.class);

		setModelImplClass(HotelImpl.class);
		setModelPKClass(long.class);

		setTable(HotelTable.INSTANCE);
	}

	/**
	 * Caches the hotel in the entity cache if it is enabled.
	 *
	 * @param hotel the hotel
	 */
	@Override
	public void cacheResult(Hotel hotel) {
		entityCache.putResult(HotelImpl.class, hotel.getPrimaryKey(), hotel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {hotel.getUuid(), hotel.getGroupId()}, hotel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the hotels in the entity cache if it is enabled.
	 *
	 * @param hotels the hotels
	 */
	@Override
	public void cacheResult(List<Hotel> hotels) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (hotels.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Hotel hotel : hotels) {
			if (entityCache.getResult(HotelImpl.class, hotel.getPrimaryKey()) ==
					null) {

				cacheResult(hotel);
			}
		}
	}

	/**
	 * Clears the cache for all hotels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HotelImpl.class);

		finderCache.clearCache(HotelImpl.class);
	}

	/**
	 * Clears the cache for the hotel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Hotel hotel) {
		entityCache.removeResult(HotelImpl.class, hotel);
	}

	@Override
	public void clearCache(List<Hotel> hotels) {
		for (Hotel hotel : hotels) {
			entityCache.removeResult(HotelImpl.class, hotel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(HotelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HotelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(HotelModelImpl hotelModelImpl) {
		Object[] args = new Object[] {
			hotelModelImpl.getUuid(), hotelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, hotelModelImpl);
	}

	/**
	 * Creates a new hotel with the primary key. Does not add the hotel to the database.
	 *
	 * @param hotelId the primary key for the new hotel
	 * @return the new hotel
	 */
	@Override
	public Hotel create(long hotelId) {
		Hotel hotel = new HotelImpl();

		hotel.setNew(true);
		hotel.setPrimaryKey(hotelId);

		String uuid = _portalUUID.generate();

		hotel.setUuid(uuid);

		hotel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return hotel;
	}

	/**
	 * Removes the hotel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel that was removed
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	@Override
	public Hotel remove(long hotelId) throws NoSuchHotelException {
		return remove((Serializable)hotelId);
	}

	/**
	 * Removes the hotel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hotel
	 * @return the hotel that was removed
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	@Override
	public Hotel remove(Serializable primaryKey) throws NoSuchHotelException {
		Session session = null;

		try {
			session = openSession();

			Hotel hotel = (Hotel)session.get(HotelImpl.class, primaryKey);

			if (hotel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHotelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(hotel);
		}
		catch (NoSuchHotelException noSuchEntityException) {
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
	protected Hotel removeImpl(Hotel hotel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hotel)) {
				hotel = (Hotel)session.get(
					HotelImpl.class, hotel.getPrimaryKeyObj());
			}

			if (hotel != null) {
				session.delete(hotel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (hotel != null) {
			clearCache(hotel);
		}

		return hotel;
	}

	@Override
	public Hotel updateImpl(Hotel hotel) {
		boolean isNew = hotel.isNew();

		if (!(hotel instanceof HotelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(hotel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(hotel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in hotel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Hotel implementation " +
					hotel.getClass());
		}

		HotelModelImpl hotelModelImpl = (HotelModelImpl)hotel;

		if (Validator.isNull(hotel.getUuid())) {
			String uuid = _portalUUID.generate();

			hotel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (hotel.getCreateDate() == null)) {
			if (serviceContext == null) {
				hotel.setCreateDate(date);
			}
			else {
				hotel.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!hotelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				hotel.setModifiedDate(date);
			}
			else {
				hotel.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(hotel);
			}
			else {
				hotel = (Hotel)session.merge(hotel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HotelImpl.class, hotelModelImpl, false, true);

		cacheUniqueFindersCache(hotelModelImpl);

		if (isNew) {
			hotel.setNew(false);
		}

		hotel.resetOriginalValues();

		return hotel;
	}

	/**
	 * Returns the hotel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hotel
	 * @return the hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	@Override
	public Hotel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHotelException {

		Hotel hotel = fetchByPrimaryKey(primaryKey);

		if (hotel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHotelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return hotel;
	}

	/**
	 * Returns the hotel with the primary key or throws a <code>NoSuchHotelException</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel
	 * @throws NoSuchHotelException if a hotel with the primary key could not be found
	 */
	@Override
	public Hotel findByPrimaryKey(long hotelId) throws NoSuchHotelException {
		return findByPrimaryKey((Serializable)hotelId);
	}

	/**
	 * Returns the hotel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel, or <code>null</code> if a hotel with the primary key could not be found
	 */
	@Override
	public Hotel fetchByPrimaryKey(long hotelId) {
		return fetchByPrimaryKey((Serializable)hotelId);
	}

	/**
	 * Returns all the hotels.
	 *
	 * @return the hotels
	 */
	@Override
	public List<Hotel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Hotel> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Hotel> findAll(
		int start, int end, OrderByComparator<Hotel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Hotel> findAll(
		int start, int end, OrderByComparator<Hotel> orderByComparator,
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

		List<Hotel> list = null;

		if (useFinderCache) {
			list = (List<Hotel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HOTEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HOTEL;

				sql = sql.concat(HotelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Hotel>)QueryUtil.list(
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
	 * Removes all the hotels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Hotel hotel : findAll()) {
			remove(hotel);
		}
	}

	/**
	 * Returns the number of hotels.
	 *
	 * @return the number of hotels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HOTEL);

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
		return "hotelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HOTEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HotelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hotel persistence.
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

		_finderPathWithPaginationFindByLocation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocation",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"location"}, true);

		_finderPathWithoutPaginationFindByLocation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocation",
			new String[] {String.class.getName()}, new String[] {"location"},
			true);

		_finderPathCountByLocation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocation",
			new String[] {String.class.getName()}, new String[] {"location"},
			false);

		_setHotelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHotelUtilPersistence(null);

		entityCache.removeCache(HotelImpl.class.getName());
	}

	private void _setHotelUtilPersistence(HotelPersistence hotelPersistence) {
		try {
			Field field = HotelUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, hotelPersistence);
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

	private static final String _SQL_SELECT_HOTEL =
		"SELECT hotel FROM Hotel hotel";

	private static final String _SQL_SELECT_HOTEL_WHERE =
		"SELECT hotel FROM Hotel hotel WHERE ";

	private static final String _SQL_COUNT_HOTEL =
		"SELECT COUNT(hotel) FROM Hotel hotel";

	private static final String _SQL_COUNT_HOTEL_WHERE =
		"SELECT COUNT(hotel) FROM Hotel hotel WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"hotel.hotelId";

	private static final String _FILTER_SQL_SELECT_HOTEL_WHERE =
		"SELECT DISTINCT {hotel.*} FROM HOTELS_Hotel hotel WHERE ";

	private static final String
		_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {HOTELS_Hotel.*} FROM (SELECT DISTINCT hotel.hotelId FROM HOTELS_Hotel hotel WHERE ";

	private static final String
		_FILTER_SQL_SELECT_HOTEL_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN HOTELS_Hotel ON TEMP_TABLE.hotelId = HOTELS_Hotel.hotelId";

	private static final String _FILTER_SQL_COUNT_HOTEL_WHERE =
		"SELECT COUNT(DISTINCT hotel.hotelId) AS COUNT_VALUE FROM HOTELS_Hotel hotel WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "hotel";

	private static final String _FILTER_ENTITY_TABLE = "HOTELS_Hotel";

	private static final String _ORDER_BY_ENTITY_ALIAS = "hotel.";

	private static final String _ORDER_BY_ENTITY_TABLE = "HOTELS_Hotel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Hotel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Hotel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HotelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}