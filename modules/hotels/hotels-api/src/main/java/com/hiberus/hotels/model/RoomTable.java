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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;HOTELS_Room&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Room
 * @generated
 */
public class RoomTable extends BaseTable<RoomTable> {

	public static final RoomTable INSTANCE = new RoomTable();

	public final Column<RoomTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Long> roomId = createColumn(
		"roomId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RoomTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoomTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Long> hotelId = createColumn(
		"hotelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Integer> number = createColumn(
		"number_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<RoomTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Integer> size = createColumn(
		"size_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<RoomTable, Double> price = createColumn(
		"price", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private RoomTable() {
		super("HOTELS_Room", RoomTable::new);
	}

}