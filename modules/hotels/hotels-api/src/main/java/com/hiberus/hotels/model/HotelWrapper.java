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

package com.hiberus.hotels.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Hotel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Hotel
 * @generated
 */
public class HotelWrapper
	extends BaseModelWrapper<Hotel> implements Hotel, ModelWrapper<Hotel> {

	public HotelWrapper(Hotel hotel) {
		super(hotel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hotelId", getHotelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("location", getLocation());
		attributes.put("foundationDate", getFoundationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hotelId = (Long)attributes.get("hotelId");

		if (hotelId != null) {
			setHotelId(hotelId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Date foundationDate = (Date)attributes.get("foundationDate");

		if (foundationDate != null) {
			setFoundationDate(foundationDate);
		}
	}

	@Override
	public Hotel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this hotel.
	 *
	 * @return the address of this hotel
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this hotel.
	 *
	 * @return the company ID of this hotel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this hotel.
	 *
	 * @return the create date of this hotel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this hotel.
	 *
	 * @return the email of this hotel
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the foundation date of this hotel.
	 *
	 * @return the foundation date of this hotel
	 */
	@Override
	public Date getFoundationDate() {
		return model.getFoundationDate();
	}

	/**
	 * Returns the group ID of this hotel.
	 *
	 * @return the group ID of this hotel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hotel ID of this hotel.
	 *
	 * @return the hotel ID of this hotel
	 */
	@Override
	public long getHotelId() {
		return model.getHotelId();
	}

	/**
	 * Returns the location of this hotel.
	 *
	 * @return the location of this hotel
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this hotel.
	 *
	 * @return the modified date of this hotel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this hotel.
	 *
	 * @return the name of this hotel
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this hotel.
	 *
	 * @return the primary key of this hotel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this hotel.
	 *
	 * @return the user ID of this hotel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this hotel.
	 *
	 * @return the user name of this hotel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this hotel.
	 *
	 * @return the user uuid of this hotel
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this hotel.
	 *
	 * @return the uuid of this hotel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this hotel.
	 *
	 * @param address the address of this hotel
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this hotel.
	 *
	 * @param companyId the company ID of this hotel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this hotel.
	 *
	 * @param createDate the create date of this hotel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this hotel.
	 *
	 * @param email the email of this hotel
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the foundation date of this hotel.
	 *
	 * @param foundationDate the foundation date of this hotel
	 */
	@Override
	public void setFoundationDate(Date foundationDate) {
		model.setFoundationDate(foundationDate);
	}

	/**
	 * Sets the group ID of this hotel.
	 *
	 * @param groupId the group ID of this hotel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hotel ID of this hotel.
	 *
	 * @param hotelId the hotel ID of this hotel
	 */
	@Override
	public void setHotelId(long hotelId) {
		model.setHotelId(hotelId);
	}

	/**
	 * Sets the location of this hotel.
	 *
	 * @param location the location of this hotel
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this hotel.
	 *
	 * @param modifiedDate the modified date of this hotel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this hotel.
	 *
	 * @param name the name of this hotel
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this hotel.
	 *
	 * @param primaryKey the primary key of this hotel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this hotel.
	 *
	 * @param userId the user ID of this hotel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this hotel.
	 *
	 * @param userName the user name of this hotel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this hotel.
	 *
	 * @param userUuid the user uuid of this hotel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this hotel.
	 *
	 * @param uuid the uuid of this hotel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected HotelWrapper wrap(Hotel hotel) {
		return new HotelWrapper(hotel);
	}

}