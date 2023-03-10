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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Hotel. This utility wraps
 * <code>com.hiberus.hotels.service.impl.HotelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HotelLocalService
 * @generated
 */
public class HotelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hiberus.hotels.service.impl.HotelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the hotel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HotelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hotel the hotel
	 * @return the hotel that was added
	 */
	public static Hotel addHotel(Hotel hotel) {
		return getService().addHotel(hotel);
	}

	public static Hotel addHotel(
			long groupId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.hiberus.hotels.exception.HotelValidationException {

		return getService().addHotel(
			groupId, name, email, address, location, foundationDate,
			serviceContext);
	}

	/**
	 * Creates a new hotel with the primary key. Does not add the hotel to the database.
	 *
	 * @param hotelId the primary key for the new hotel
	 * @return the new hotel
	 */
	public static Hotel createHotel(long hotelId) {
		return getService().createHotel(hotelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the hotel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HotelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hotel the hotel
	 * @return the hotel that was removed
	 */
	public static Hotel deleteHotel(Hotel hotel) {
		return getService().deleteHotel(hotel);
	}

	/**
	 * Deletes the hotel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HotelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel that was removed
	 * @throws PortalException if a hotel with the primary key could not be found
	 */
	public static Hotel deleteHotel(long hotelId) throws PortalException {
		return getService().deleteHotel(hotelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hiberus.hotels.model.impl.HotelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hiberus.hotels.model.impl.HotelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	public static DynamicQuery dynamicQueryByKeywords(
		long groupId, String keywords) {

		return getService().dynamicQueryByKeywords(groupId, keywords);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Hotel fetchHotel(long hotelId) {
		return getService().fetchHotel(hotelId);
	}

	/**
	 * Returns the hotel matching the UUID and group.
	 *
	 * @param uuid the hotel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	public static Hotel fetchHotelByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchHotelByUuidAndGroupId(uuid, groupId);
	}

	public static List<Hotel> findAllHotels() {
		return getService().findAllHotels();
	}

	public static List<Hotel> findByGroupId(long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static List<Hotel> findByLocation(String location) {
		return getService().findByLocation(location);
	}

	public static List<Hotel> findByNameOrLocation(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getService().findByNameOrLocation(
			groupId, keywords, start, end, orderByComparator);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the hotel with the primary key.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel
	 * @throws PortalException if a hotel with the primary key could not be found
	 */
	public static Hotel getHotel(long hotelId) throws PortalException {
		return getService().getHotel(hotelId);
	}

	/**
	 * Returns the hotel matching the UUID and group.
	 *
	 * @param uuid the hotel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hotel
	 * @throws PortalException if a matching hotel could not be found
	 */
	public static Hotel getHotelByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getHotelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the hotels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hiberus.hotels.model.impl.HotelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @return the range of hotels
	 */
	public static List<Hotel> getHotels(int start, int end) {
		return getService().getHotels(start, end);
	}

	/**
	 * Returns all the hotels matching the UUID and company.
	 *
	 * @param uuid the UUID of the hotels
	 * @param companyId the primary key of the company
	 * @return the matching hotels, or an empty list if no matches were found
	 */
	public static List<Hotel> getHotelsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getHotelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of hotels matching the UUID and company.
	 *
	 * @param uuid the UUID of the hotels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of hotels
	 * @param end the upper bound of the range of hotels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching hotels, or an empty list if no matches were found
	 */
	public static List<Hotel> getHotelsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hotel> orderByComparator) {

		return getService().getHotelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of hotels.
	 *
	 * @return the number of hotels
	 */
	public static int getHotelsCount() {
		return getService().getHotelsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the hotel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HotelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hotel the hotel
	 * @return the hotel that was updated
	 */
	public static Hotel updateHotel(Hotel hotel) {
		return getService().updateHotel(hotel);
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

	public static HotelLocalService getService() {
		return _service;
	}

	private static volatile HotelLocalService _service;

}