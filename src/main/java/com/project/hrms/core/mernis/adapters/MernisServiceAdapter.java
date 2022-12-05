package com.project.hrms.core.mernis.adapters;

import org.springframework.stereotype.Service;

import com.project.hrms.core.mernis.business.abstracts.UserCheckService;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService{
	
	@Override
	public Result checkIfRealPerson (JobSeeker jobSeeker) throws Exception{
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		
			boolean result =  kpsPublicSoapProxy.TCKimlikNoDogrula(
					Long.parseLong(jobSeeker.getIdentification()), jobSeeker.getName(), jobSeeker.getLastName(), 
					Integer.parseInt(jobSeeker.getDateOfYear()));
			
			if (!result) {
				return new ErrorResult("Böyle bir kişi yaşamıyor");
			}
			
			return new SuccessResult();
			
		
		
		
	}

	
}
