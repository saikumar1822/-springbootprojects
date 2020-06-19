package com.hcl.service;



import com.hcl.dto.TrasnsctionDto;
import com.hcl.model.Tranfer;
import com.hcl.model.Trasnsction;


public interface TransacService {

	TrasnsctionDto transaction(Trasnsction trasnsction);

	Tranfer createTransac(Tranfer t1);

	

}
