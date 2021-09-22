package com.mastercode.abs.service;

import java.util.List;

public interface IAddressBookService {
	public List<AddressBookEntity> getAllDetails();
	public AddressBookEntity getById(int id);
	public AddressBookEntity insertRecord(AddressBookDTO dto);
	public AddressBookEntity updateRecord(int id,AddressBookDTO dto);
	public AddressBookEntity deleteRecord(int id);
}
