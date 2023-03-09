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

package com.hiberus.hotels.model.impl;

import com.hiberus.hotels.model.Hotel;
import com.hiberus.hotels.model.HotelModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Hotel service. Represents a row in the &quot;HOTELS_Hotel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>HotelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HotelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HotelImpl
 * @generated
 */
@JSON(strict = true)
public class HotelModelImpl extends BaseModelImpl<Hotel> implements HotelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a hotel model instance should use the <code>Hotel</code> interface instead.
	 */
	public static final String TABLE_NAME = "HOTELS_Hotel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"hotelId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"location", Types.VARCHAR},
		{"foundationDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hotelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("location", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("foundationDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table HOTELS_Hotel (uuid_ VARCHAR(75) null,hotelId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,email VARCHAR(75) null,address VARCHAR(75) null,location VARCHAR(75) null,foundationDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table HOTELS_Hotel";

	public static final String ORDER_BY_JPQL = " ORDER BY hotel.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY HOTELS_Hotel.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LOCATION_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public HotelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _hotelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHotelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hotelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Hotel.class;
	}

	@Override
	public String getModelClassName() {
		return Hotel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Hotel, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Hotel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Hotel, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Hotel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Hotel, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Hotel, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Hotel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Hotel, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Hotel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Hotel, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Hotel, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Hotel, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Hotel, Object>>();
		Map<String, BiConsumer<Hotel, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Hotel, ?>>();

		attributeGetterFunctions.put("uuid", Hotel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Hotel, String>)Hotel::setUuid);
		attributeGetterFunctions.put("hotelId", Hotel::getHotelId);
		attributeSetterBiConsumers.put(
			"hotelId", (BiConsumer<Hotel, Long>)Hotel::setHotelId);
		attributeGetterFunctions.put("groupId", Hotel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Hotel, Long>)Hotel::setGroupId);
		attributeGetterFunctions.put("companyId", Hotel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Hotel, Long>)Hotel::setCompanyId);
		attributeGetterFunctions.put("userId", Hotel::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Hotel, Long>)Hotel::setUserId);
		attributeGetterFunctions.put("userName", Hotel::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Hotel, String>)Hotel::setUserName);
		attributeGetterFunctions.put("createDate", Hotel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Hotel, Date>)Hotel::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Hotel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Hotel, Date>)Hotel::setModifiedDate);
		attributeGetterFunctions.put("name", Hotel::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Hotel, String>)Hotel::setName);
		attributeGetterFunctions.put("email", Hotel::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Hotel, String>)Hotel::setEmail);
		attributeGetterFunctions.put("address", Hotel::getAddress);
		attributeSetterBiConsumers.put(
			"address", (BiConsumer<Hotel, String>)Hotel::setAddress);
		attributeGetterFunctions.put("location", Hotel::getLocation);
		attributeSetterBiConsumers.put(
			"location", (BiConsumer<Hotel, String>)Hotel::setLocation);
		attributeGetterFunctions.put(
			"foundationDate", Hotel::getFoundationDate);
		attributeSetterBiConsumers.put(
			"foundationDate",
			(BiConsumer<Hotel, Date>)Hotel::setFoundationDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getHotelId() {
		return _hotelId;
	}

	@Override
	public void setHotelId(long hotelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_hotelId = hotelId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@JSON
	@Override
	public String getLocation() {
		if (_location == null) {
			return "";
		}
		else {
			return _location;
		}
	}

	@Override
	public void setLocation(String location) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_location = location;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLocation() {
		return getColumnOriginalValue("location");
	}

	@JSON
	@Override
	public Date getFoundationDate() {
		return _foundationDate;
	}

	@Override
	public void setFoundationDate(Date foundationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_foundationDate = foundationDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Hotel.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Hotel.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Hotel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Hotel>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HotelImpl hotelImpl = new HotelImpl();

		hotelImpl.setUuid(getUuid());
		hotelImpl.setHotelId(getHotelId());
		hotelImpl.setGroupId(getGroupId());
		hotelImpl.setCompanyId(getCompanyId());
		hotelImpl.setUserId(getUserId());
		hotelImpl.setUserName(getUserName());
		hotelImpl.setCreateDate(getCreateDate());
		hotelImpl.setModifiedDate(getModifiedDate());
		hotelImpl.setName(getName());
		hotelImpl.setEmail(getEmail());
		hotelImpl.setAddress(getAddress());
		hotelImpl.setLocation(getLocation());
		hotelImpl.setFoundationDate(getFoundationDate());

		hotelImpl.resetOriginalValues();

		return hotelImpl;
	}

	@Override
	public Hotel cloneWithOriginalValues() {
		HotelImpl hotelImpl = new HotelImpl();

		hotelImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		hotelImpl.setHotelId(this.<Long>getColumnOriginalValue("hotelId"));
		hotelImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		hotelImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		hotelImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		hotelImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		hotelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		hotelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		hotelImpl.setName(this.<String>getColumnOriginalValue("name"));
		hotelImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		hotelImpl.setAddress(this.<String>getColumnOriginalValue("address"));
		hotelImpl.setLocation(this.<String>getColumnOriginalValue("location"));
		hotelImpl.setFoundationDate(
			this.<Date>getColumnOriginalValue("foundationDate"));

		return hotelImpl;
	}

	@Override
	public int compareTo(Hotel hotel) {
		int value = 0;

		value = getName().compareTo(hotel.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Hotel)) {
			return false;
		}

		Hotel hotel = (Hotel)object;

		long primaryKey = hotel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Hotel> toCacheModel() {
		HotelCacheModel hotelCacheModel = new HotelCacheModel();

		hotelCacheModel.uuid = getUuid();

		String uuid = hotelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			hotelCacheModel.uuid = null;
		}

		hotelCacheModel.hotelId = getHotelId();

		hotelCacheModel.groupId = getGroupId();

		hotelCacheModel.companyId = getCompanyId();

		hotelCacheModel.userId = getUserId();

		hotelCacheModel.userName = getUserName();

		String userName = hotelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			hotelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			hotelCacheModel.createDate = createDate.getTime();
		}
		else {
			hotelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			hotelCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			hotelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		hotelCacheModel.name = getName();

		String name = hotelCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			hotelCacheModel.name = null;
		}

		hotelCacheModel.email = getEmail();

		String email = hotelCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			hotelCacheModel.email = null;
		}

		hotelCacheModel.address = getAddress();

		String address = hotelCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			hotelCacheModel.address = null;
		}

		hotelCacheModel.location = getLocation();

		String location = hotelCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			hotelCacheModel.location = null;
		}

		Date foundationDate = getFoundationDate();

		if (foundationDate != null) {
			hotelCacheModel.foundationDate = foundationDate.getTime();
		}
		else {
			hotelCacheModel.foundationDate = Long.MIN_VALUE;
		}

		return hotelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Hotel, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Hotel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Hotel, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Hotel)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Hotel>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Hotel.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _hotelId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _email;
	private String _address;
	private String _location;
	private Date _foundationDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Hotel, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Hotel)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("hotelId", _hotelId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("location", _location);
		_columnOriginalValues.put("foundationDate", _foundationDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("hotelId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("email", 512L);

		columnBitmasks.put("address", 1024L);

		columnBitmasks.put("location", 2048L);

		columnBitmasks.put("foundationDate", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Hotel _escapedModel;

}