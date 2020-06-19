package com.example.facility.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facility.dto.FacilityDto;
import com.example.facility.dto.ResponseFacilityDto;
import com.example.facility.exception.NoFacilityDataFoundException;
import com.example.facility.model.Facility;
import com.example.facility.repository.FacilityRepository;
@Service
public class FacilityService {
	@Autowired
	FacilityRepository facilityRepository;
	
	public ResponseFacilityDto saveFacility(Facility facility) {
		ResponseFacilityDto facilityDto = new ResponseFacilityDto();
		Facility facility1;
		if (facility != null) {
			facility1= facilityRepository.save(facility);
			BeanUtils.copyProperties(facility1, facilityDto);
			return facilityDto;
		} else {
			throw new NoFacilityDataFoundException();
		}

	}
	public FacilityDto updateFacility(Facility facility) {
		FacilityDto facilityDto = new FacilityDto();
		Facility facility1;
		if (facility != null) {
			facility1= facilityRepository.save(facility);
			BeanUtils.copyProperties(facility1, facilityDto);
			return facilityDto;
		} else {
			throw new NoFacilityDataFoundException();
		}

	}


	public FacilityDto getFacility(Long id) {
		FacilityDto facilityDto=new FacilityDto();
		Facility facility = facilityRepository.findById(id).orElseThrow(()->new NoFacilityDataFoundException());
		BeanUtils.copyProperties(facility, facilityDto);
		return facilityDto;
	}

	public void deleteFacility(Long id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(()->new NoFacilityDataFoundException());
		facilityRepository.deleteById(facility.getFacilityId());
	}
	public Facility getFacility1(Long id) {
	return  facilityRepository.findById(id).orElseThrow(()->new NoFacilityDataFoundException());
	}


}

