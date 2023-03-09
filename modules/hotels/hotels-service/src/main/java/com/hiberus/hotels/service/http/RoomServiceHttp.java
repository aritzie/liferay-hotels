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

package com.hiberus.hotels.service.http;

import com.hiberus.hotels.service.RoomServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>RoomServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoomServiceHttp {

	public static com.hiberus.hotels.model.Room addRoom(
		HttpPrincipal httpPrincipal, long groupId, long hotelId, int number,
		String type, int size, double price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "addRoom", _addRoomParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, hotelId, number, type, size, price,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Room)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Room updateRoom(
			HttpPrincipal httpPrincipal, long roomId, long hotelId, int number,
			String type, int size, double price)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "updateRoom",
				_updateRoomParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, roomId, hotelId, number, type, size, price);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Room)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Room deleteRoom(
			HttpPrincipal httpPrincipal, long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "deleteRoom",
				_deleteRoomParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, roomId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Room)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Room findRoom(
		HttpPrincipal httpPrincipal, long roomId) {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "findRoom", _findRoomParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, roomId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Room)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Room> findByGroupId(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "findByGroupId",
				_findByGroupIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Room>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Room> findByHotelId(
		HttpPrincipal httpPrincipal, long hotelId) {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "findByHotelId",
				_findByHotelIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, hotelId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Room>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Room>
		findByNumerTypeOrSize(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hiberus.hotels.model.Room> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				RoomServiceUtil.class, "findByNumerTypeOrSize",
				_findByNumerTypeOrSizeParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Room>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RoomServiceHttp.class);

	private static final Class<?>[] _addRoomParameterTypes0 = new Class[] {
		long.class, long.class, int.class, String.class, int.class,
		double.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateRoomParameterTypes1 = new Class[] {
		long.class, long.class, int.class, String.class, int.class, double.class
	};
	private static final Class<?>[] _deleteRoomParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findRoomParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByGroupIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _findByHotelIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _findByNumerTypeOrSizeParameterTypes6 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};

}