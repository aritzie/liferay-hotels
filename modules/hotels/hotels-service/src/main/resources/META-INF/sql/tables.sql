create table HOTELS_Hotel (
	uuid_ VARCHAR(75) null,
	hotelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	location VARCHAR(75) null,
	foundationDate DATE null
);

create table HOTELS_Room (
	uuid_ VARCHAR(75) null,
	roomId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	hotelId LONG,
	number_ INTEGER,
	type_ VARCHAR(75) null,
	size_ INTEGER,
	price DOUBLE
);