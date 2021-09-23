package com.mastercode.abs.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercode.abs.dto.AddressBookDTO;
import com.mastercode.abs.entity.AddressBookEntity;

public interface IAddressBookRespository extends JpaRepository<AddressBookEntity, Integer>{

}
