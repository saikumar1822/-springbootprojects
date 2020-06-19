package com.example.hungerbox.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hungerbox.dto.VendorDto;
import com.example.hungerbox.exceptions.VendorNotFoundException;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.model.Vendor;
import com.example.hungerbox.repository.ItemRepository;
import com.example.hungerbox.repository.VendorRepository;
/**
 * 
 * @author WELCOME
 * @since 2020-06018
 * @version 1.0
 */
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorRepository vendorRepositroy;
	@Autowired
	ItemRepository itemRepositroy;
	/**
	 * return VenderDto
	 */
	@Override
	public VendorDto searchforVendorName(String vendorName) {
		final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		Item item = new Item();
		VendorDto vendordto = new VendorDto();
		Vendor vendor1 = new Vendor();
		LOGGER.info("-----getting the  vendor list-----");
		Optional<Vendor> vendor = vendorRepositroy.findByVendorName(vendorName);
		if (vendor.isPresent()) {
			BeanUtils.copyProperties(vendor1, vendordto);
			vendor1 = vendor.get();
			vendordto.setStallNumber(vendor1.getStallNumber());
			vendordto.setVendorDescription(vendor1.getVendorDescription());
			vendordto.setVendorId(vendor1.getVendorId());
			vendordto.setVendorName(vendor1.getVendorName());
			List<Item> items=itemRepositroy.findItemByVendor(vendor1);
			vendordto.setItems(items);
			return vendordto;

		} else {
			throw new VendorNotFoundException("vendor Not found");
		}

	}

}
