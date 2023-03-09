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

import com.hiberus.hotels.service.HotelServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>HotelServiceUtil</code> service
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
public class HotelServiceHttp {

	public static com.hiberus.hotels.model.Hotel addHotel(
			HttpPrincipal httpPrincipal, long groupId, String name,
			String email, String address, String location,
			java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.hiberus.hotels.exception.HotelValidationException {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "addHotel", _addHotelParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, name, email, address, location,
				foundationDate, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.hiberus.hotels.exception.HotelValidationException) {

					throw (com.hiberus.hotels.exception.
						HotelValidationException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Hotel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Hotel updateHotel(
			HttpPrincipal httpPrincipal, long hotelId, String name,
			String email, String address, String location,
			java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "updateHotel",
				_updateHotelParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, hotelId, name, email, address, location,
				foundationDate, serviceContext);

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

			return (com.hiberus.hotels.model.Hotel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Hotel deleteHotel(
			HttpPrincipal httpPrincipal, long hotelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "deleteHotel",
				_deleteHotelParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, hotelId);

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

			return (com.hiberus.hotels.model.Hotel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hiberus.hotels.model.Hotel findHotel(
		HttpPrincipal httpPrincipal, long hotelId) {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "findHotel", _findHotelParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, hotelId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hiberus.hotels.model.Hotel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Hotel> findAllHotels(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "findAllHotels",
				_findAllHotelsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Hotel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Hotel>
		findHotelByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "findHotelByGroupId",
				_findHotelByGroupIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Hotel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Hotel>
		findHotelByLocation(HttpPrincipal httpPrincipal, String location) {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "findHotelByLocation",
				_findHotelByLocationParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, location);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hiberus.hotels.model.Hotel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hiberus.hotels.model.Hotel>
		findByNameOrLocation(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hiberus.hotels.model.Hotel> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				HotelServiceUtil.class, "findByNameOrLocation",
				_findByNameOrLocationParameterTypes7);

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

			return (java.util.List<com.hiberus.hotels.model.Hotel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(HotelServiceHttp.class);

	private static final Class<?>[] _addHotelParameterTypes0 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		java.util.Date.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateHotelParameterTypes1 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		java.util.Date.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteHotelParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findHotelParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findAllHotelsParameterTypes4 =
		new Class[] {};
	private static final Class<?>[] _findHotelByGroupIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _findHotelByLocationParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _findByNameOrLocationParameterTypes7 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};

}