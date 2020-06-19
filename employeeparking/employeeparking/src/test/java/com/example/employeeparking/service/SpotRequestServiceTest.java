package com.example.employeeparking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.employeeparking.dto.ResponseDto;
import com.example.employeeparking.exception.NoFreeSpotsFoundException;
import com.example.employeeparking.exception.RequestNotProcessedException;
import com.example.employeeparking.exception.SpotRequestNotFoundException;
import com.example.employeeparking.model.Employee;
import com.example.employeeparking.model.FreeSpot;
import com.example.employeeparking.model.ParkingLot;
import com.example.employeeparking.model.SpotRequest;
import com.example.employeeparking.repository.FreeSpotRepository;
import com.example.employeeparking.repository.SpotRequestRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SpotRequestServiceTest {
	@Mock
	SpotRequestRepository spotRequestRepository;

	@Mock
	FreeSpotRepository freeSpotRepository;

	@InjectMocks
	SpotRequestService spotRequestService;

	ResponseDto responseDto = new ResponseDto();
	SpotRequest spotRequest = new SpotRequest();
	List<SpotRequest> spotrequests = new ArrayList<SpotRequest>();
	List<FreeSpot> freeSpots = new ArrayList<FreeSpot>();
	LocalDate date = LocalDate.now();
	FreeSpot freeSpot = new FreeSpot();
	ParkingLot parkingLot = new ParkingLot();
	Employee employee = new Employee();

	@Test(expected = NoSuchElementException.class)
	public void testCreateUserForPositive() throws Exception {
		employee.setIsVip(true);
		employee.setEmail("@gmail.com");
		employee.setEmployeeId(1l);
		employee.setEmployeeName("kumar");
		employee.setPassword("yerg");
		employee.setPhone("123456789");
		parkingLot.setParkingLotId(1l);
		parkingLot.setDescription("well and good");
		parkingLot.setSpot("11-lk-20");
		freeSpot.setDate(date);
		freeSpot.setFreeSpotId(1l);
		freeSpot.setStatus("not assigned");
		freeSpot.setParkingLot(parkingLot);
		freeSpot.setEmployee(employee);
		freeSpots.add(freeSpot);

		spotRequest.setDate(date);
		spotRequest.setSpotRequesttId(1l);
		spotRequest.setStatus("not assigned");
		spotRequest.setFreeSpot(freeSpot);
		spotRequest.setEmployee(employee);
		spotrequests.add(spotRequest);
		responseDto.setMessage("sucessful");
		responseDto.getMessage();

		Mockito.when(spotRequestRepository.findByDateGreaterThanAndStatus(date, "not assigned"))
				.thenReturn(spotrequests);
		if (spotrequests.isEmpty()) {
			throw new SpotRequestNotFoundException("no requests found for spots");
		}
		List<Long> spotrequestIds = spotrequests.stream().map(m -> m.getSpotRequesttId()).collect(Collectors.toList());
		Long spotRequestId = getRandomElement(spotrequestIds);
		Mockito.when(spotRequestRepository.findById(spotRequestId).get()).thenReturn(spotRequest);

		Mockito.when(freeSpotRepository.findByDateGreaterThanAndStatus(date, "not assigned")).thenReturn(freeSpots);
		if (freeSpots.isEmpty()) {
			throw new NoFreeSpotsFoundException("free spots not available");
		}
		List<Long> freeSpotIds = freeSpots.stream().map(m -> m.getFreeSpotId()).collect(Collectors.toList());
		Long freeSpotId = getRandomElement(freeSpotIds);
		Mockito.when(freeSpotRepository.findById(freeSpotId).get()).thenReturn(freeSpot);
		if (freeSpot.getDate().equals(spotRequest.getDate())) {

			freeSpot.setStatus("assigned");
			spotRequest.setFreeSpot(freeSpot);
			spotRequest.setStatus("assigned");
			freeSpotRepository.save(freeSpot);
			spotRequestRepository.save(spotRequest);

		} else {
			throw new RequestNotProcessedException("request not processed");
		}
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("requests for parking spots hass been done");
		ResponseDto responseDto1 = spotRequestService.requestProcessing();
	}

	public Long getRandomElement(List<Long> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

}
