create index IX_32E43890 on HOTELS_Hotel (groupId);
create index IX_3A565A43 on HOTELS_Hotel (location[$COLUMN_LENGTH:75$]);
create index IX_6502C0CE on HOTELS_Hotel (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2A4122D0 on HOTELS_Hotel (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_38E660C9 on HOTELS_Room (groupId);
create index IX_E48BD697 on HOTELS_Room (hotelId, type_[$COLUMN_LENGTH:75$]);
create index IX_DF47C8B5 on HOTELS_Room (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E24F877 on HOTELS_Room (uuid_[$COLUMN_LENGTH:75$], groupId);