package com.example.cabbooking.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.CabDto;
import com.example.cabbooking.dto.CabServiceDto;
import com.example.cabbooking.dto.SearchDto;
import com.example.cabbooking.exceptions.NoCabsFoundException;
import com.example.cabbooking.model.Cab;
import com.example.cabbooking.repository.CabRepository;

@Service
public class CabService {
	
	@Autowired
	CabRepository cabRepository;
	
	public  CabServiceDto getCabs(SearchDto timestamp) throws NoCabsFoundException, ParseException {
	  Date d=new Date();
	  List< Cab> cabs;
	  int d1=timestamp.getTimeStamp().getDate();
	  if(d.getDate()==d1) {
		  cabs=  cabRepository.findByTimeStampGreaterThan(d);
	  }else {
	  
	 cabs= cabRepository.findByTimeStampGreaterThan(timestamp.getTimeStamp());
	  }
	
		if(cabs.isEmpty()) {
			throw new NoCabsFoundException("no cabs found");
		}
	CabServiceDto cabDto=new CabServiceDto();
	cabDto.setCabs(cabs);
	return cabDto;
	}
	
	public void cabSave(CabDto cabDto) {
		Cab c=new Cab();
		c.setAvialbleStatus(cabDto.getAvialbleStatus());
		c.setCabName(cabDto.getCabName());
		c.setRegistrationNumber(cabDto.getRegistrationNumber());
		c.setTimeStamp(cabDto.getTimeStamp());	
		cabRepository.save(c);
	}

}
