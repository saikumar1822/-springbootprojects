package com.example.employeeparking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeparking.dto.ResponseDto;
import com.example.employeeparking.exception.NoFreeSpotsFoundException;
import com.example.employeeparking.exception.RequestNotProcessedException;
import com.example.employeeparking.exception.SpotRequestNotFoundException;
import com.example.employeeparking.model.FreeSpot;
import com.example.employeeparking.model.SpotRequest;
import com.example.employeeparking.repository.FreeSpotRepository;
import com.example.employeeparking.repository.SpotRequestRepository;

/**
 * this SpotRequestService is for requestProcessing
 * 
 * @author sai kumar version 1-1
 * @since 2020-06-15
 *
 */
@Service
public class SpotRequestService {
	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);

	@Autowired
	FreeSpotRepository freeSpotRepository;

	@Autowired
	SpotRequestRepository spotRequestRepository;

	/**
	 * 
	 * @return ResponseDto as status msg
	 * @throws RequestNotProcessedException
	 * @throws SpotRequestNotFoundException
	 * @throws NoFreeSpotsFoundException
	 */
	public ResponseDto requestProcessing() throws SpotRequestNotFoundException, NoFreeSpotsFoundException {
		LocalDate date = LocalDate.now();
		List<SpotRequest> employeeReq = spotRequestRepository.findByDateGreaterThanAndStatus(date, "not assigned");
		if (employeeReq.isEmpty()) {
			throw new SpotRequestNotFoundException("no requests found for spots");
		}
		List<Long> spotrequestIds = employeeReq.stream().map(m -> m.getSpotRequesttId()).collect(Collectors.toList());

		List<FreeSpot> freeSpots = freeSpotRepository.findByDateGreaterThanAndStatus(date, "not assigned");
		if (freeSpots.isEmpty()) {
			throw new NoFreeSpotsFoundException("free spots not available");
		}
		List<Long> freeSpotIds = freeSpots.stream().map(m -> m.getFreeSpotId()).collect(Collectors.toList());

		for (int i = 0; i < freeSpotIds.size(); i++) {
			FreeSpot freeSpot = freeSpotRepository.findById(freeSpotIds.get(i)).get();

			for (int j = 0; j < spotrequestIds.size(); j++) {
				SpotRequest spotRequest = spotRequestRepository.findById(getRandomElement(spotrequestIds)).get();

				logger.info("checking the dates");
				if (freeSpot.getDate().equals(spotRequest.getDate())
						&& spotRequest.getStatus().equalsIgnoreCase("not assigned")) {

					freeSpot.setStatus("assigned");
					spotRequest.setFreeSpot(freeSpot);
					spotRequest.setStatus("assigned");
					freeSpotRepository.save(freeSpot);

					spotRequestRepository.save(spotRequest);
					break;
				}

			}

		}
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("requests for parking spots hass been done");
		return responseDto;

	}

	public Long getRandomElement(List<Long> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

}
