package com.example.hungerbox.service;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;

import com.example.hungerbox.dto.VendorDto;
import com.example.hungerbox.exceptions.VendorNotFoundException;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.model.Vendor;
import com.example.hungerbox.repository.ItemRepository;
import com.example.hungerbox.repository.VendorRepository;
@RunWith(Silent.class)
public class VendorServiceImplTest {
	private static final String vendorName = null;
	@InjectMocks
	VendorServiceImpl vendorServiceImpl;
	@Mock
	VendorRepository VendorRepositroy;
	@Mock
	ItemRepository itemRepositroy;
	static Vendor vendor = null;
	Item items = new Item();

	@BeforeClass
	public static void setUp() {
		vendor = new Vendor();
	}
	@Test(expected = VendorNotFoundException.class)
	public void testForSearchBus() {
		VendorDto vendorDto = new VendorDto();
		
		vendorDto.setStallNumber(12);
		vendorDto.setVendorDescription("good");
		vendorDto.setVendorId(12L);
		vendorDto.setVendorName("divya");
		Vendor vendor1 = new Vendor();
		List<Item> items=itemRepositroy.findItemByVendor(vendor1);
		vendorDto.setItems(items);
		Optional<Vendor> vendordto1=VendorRepositroy.findByVendorName("divya");
		Mockito.when(VendorRepositroy.findByVendorName("divya")).thenReturn(vendordto1);
		vendorServiceImpl.searchforVendorName("divya");
		Assert.assertEquals("divya", vendorDto.getVendorName());

		
	}
	@Test(expected = VendorNotFoundException.class)
	public void testForSearchBusPostiv() {
		VendorDto vendorDto = new VendorDto();
		Item item=new Item();
		vendorDto.setStallNumber(12);
		vendorDto.setVendorDescription("good");
		vendorDto.setVendorId(12L);
		vendorDto.setVendorName("divya");
		Vendor vendor1 = new Vendor();
		List<Item> items=itemRepositroy.findItemByVendor(vendor1);
		items.add(item);
		vendorDto.setItems(items);
		Optional<Vendor> vendordto1=VendorRepositroy.findByVendorName("divya");
		Mockito.when(VendorRepositroy.findByVendorName(Mockito.anyString())).thenReturn(vendordto1);
		vendorServiceImpl.searchforVendorName("divya");
		Assert.assertNotNull(items);
	}
}
