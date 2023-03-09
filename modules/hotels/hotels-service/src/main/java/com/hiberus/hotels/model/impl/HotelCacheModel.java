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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Hotel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HotelCacheModel implements CacheModel<Hotel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HotelCacheModel)) {
			return false;
		}

		HotelCacheModel hotelCacheModel = (HotelCacheModel)object;

		if (hotelId == hotelCacheModel.hotelId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, hotelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", hotelId=");
		sb.append(hotelId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", location=");
		sb.append(location);
		sb.append(", foundationDate=");
		sb.append(foundationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Hotel toEntityModel() {
		HotelImpl hotelImpl = new HotelImpl();

		if (uuid == null) {
			hotelImpl.setUuid("");
		}
		else {
			hotelImpl.setUuid(uuid);
		}

		hotelImpl.setHotelId(hotelId);
		hotelImpl.setGroupId(groupId);
		hotelImpl.setCompanyId(companyId);
		hotelImpl.setUserId(userId);

		if (userName == null) {
			hotelImpl.setUserName("");
		}
		else {
			hotelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hotelImpl.setCreateDate(null);
		}
		else {
			hotelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hotelImpl.setModifiedDate(null);
		}
		else {
			hotelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			hotelImpl.setName("");
		}
		else {
			hotelImpl.setName(name);
		}

		if (email == null) {
			hotelImpl.setEmail("");
		}
		else {
			hotelImpl.setEmail(email);
		}

		if (address == null) {
			hotelImpl.setAddress("");
		}
		else {
			hotelImpl.setAddress(address);
		}

		if (location == null) {
			hotelImpl.setLocation("");
		}
		else {
			hotelImpl.setLocation(location);
		}

		if (foundationDate == Long.MIN_VALUE) {
			hotelImpl.setFoundationDate(null);
		}
		else {
			hotelImpl.setFoundationDate(new Date(foundationDate));
		}

		hotelImpl.resetOriginalValues();

		return hotelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		hotelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		location = objectInput.readUTF();
		foundationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(hotelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeLong(foundationDate);
	}

	public String uuid;
	public long hotelId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String email;
	public String address;
	public String location;
	public long foundationDate;

}