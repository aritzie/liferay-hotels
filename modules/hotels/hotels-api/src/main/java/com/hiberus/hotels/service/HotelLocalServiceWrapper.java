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
 * Provides a wrapper for {@link HotelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HotelLocalService
 * @generated
 */
public class HotelLocalServiceWrapper
	implements HotelLocalService, ServiceWrapper<HotelLocalService> {

	public HotelLocalServiceWrapper() {
		this(null);
	}

	public HotelLocalServiceWrapper(HotelLocalService hotelLocalService) {
		_hotelLocalService = hotelLocalService;
	}

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
	@Override
	public com.hiberus.hotels.model.Hotel addHotel(
		com.hiberus.hotels.model.Hotel hotel) {

		return _hotelLocalService.addHotel(hotel);
	}

	@Override
	public com.hiberus.hotels.model.Hotel addHotel(
			long groupId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.hiberus.hotels.exception.HotelValidationException {

		return _hotelLocalService.addHotel(
			groupId, name, email, address, location, foundationDate,
			serviceContext);
	}

	/**
	 * Creates a new hotel with the primary key. Does not add the hotel to the database.
	 *
	 * @param hotelId the primary key for the new hotel
	 * @return the new hotel
	 */
	@Override
	public com.hiberus.hotels.model.Hotel createHotel(long hotelId) {
		return _hotelLocalService.createHotel(hotelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.hiberus.hotels.model.Hotel deleteHotel(
		com.hiberus.hotels.model.Hotel hotel) {

		return _hotelLocalService.deleteHotel(hotel);
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
	@Override
	public com.hiberus.hotels.model.Hotel deleteHotel(long hotelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.deleteHotel(hotelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _hotelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _hotelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hotelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _hotelLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _hotelLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _hotelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQueryByKeywords(long groupId, String keywords) {

		return _hotelLocalService.dynamicQueryByKeywords(groupId, keywords);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _hotelLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _hotelLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.hiberus.hotels.model.Hotel fetchHotel(long hotelId) {
		return _hotelLocalService.fetchHotel(hotelId);
	}

	/**
	 * Returns the hotel matching the UUID and group.
	 *
	 * @param uuid the hotel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hotel, or <code>null</code> if a matching hotel could not be found
	 */
	@Override
	public com.hiberus.hotels.model.Hotel fetchHotelByUuidAndGroupId(
		String uuid, long groupId) {

		return _hotelLocalService.fetchHotelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findAllHotels() {
		return _hotelLocalService.findAllHotels();
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findByGroupId(
		long groupId) {

		return _hotelLocalService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findByLocation(
		String location) {

		return _hotelLocalService.findByLocation(location);
	}

	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> findByNameOrLocation(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hiberus.hotels.model.Hotel> orderByComparator) {

		return _hotelLocalService.findByNameOrLocation(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hotelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _hotelLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the hotel with the primary key.
	 *
	 * @param hotelId the primary key of the hotel
	 * @return the hotel
	 * @throws PortalException if a hotel with the primary key could not be found
	 */
	@Override
	public com.hiberus.hotels.model.Hotel getHotel(long hotelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.getHotel(hotelId);
	}

	/**
	 * Returns the hotel matching the UUID and group.
	 *
	 * @param uuid the hotel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hotel
	 * @throws PortalException if a matching hotel could not be found
	 */
	@Override
	public com.hiberus.hotels.model.Hotel getHotelByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.getHotelByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel> getHotels(
		int start, int end) {

		return _hotelLocalService.getHotels(start, end);
	}

	/**
	 * Returns all the hotels matching the UUID and company.
	 *
	 * @param uuid the UUID of the hotels
	 * @param companyId the primary key of the company
	 * @return the matching hotels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel>
		getHotelsByUuidAndCompanyId(String uuid, long companyId) {

		return _hotelLocalService.getHotelsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.hiberus.hotels.model.Hotel>
		getHotelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hiberus.hotels.model.Hotel> orderByComparator) {

		return _hotelLocalService.getHotelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of hotels.
	 *
	 * @return the number of hotels
	 */
	@Override
	public int getHotelsCount() {
		return _hotelLocalService.getHotelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hotelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hotelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.hiberus.hotels.model.Hotel updateHotel(
		com.hiberus.hotels.model.Hotel hotel) {

		return _hotelLocalService.updateHotel(hotel);
	}

	@Override
	public com.hiberus.hotels.model.Hotel updateHotel(
			long hotelId, String name, String email, String address,
			String location, java.util.Date foundationDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hotelLocalService.updateHotel(
			hotelId, name, email, address, location, foundationDate,
			serviceContext);
	}

	@Override
	public HotelLocalService getWrappedService() {
		return _hotelLocalService;
	}

	@Override
	public void setWrappedService(HotelLocalService hotelLocalService) {
		_hotelLocalService = hotelLocalService;
	}

	private HotelLocalService _hotelLocalService;

}