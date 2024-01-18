package com.ismasurance.ismasurance.validations;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.repository.ClaimRepository;
import com.ismasurance.ismasurance.exception.IncidentDateGreaterThanCurrentDateException;
import com.ismasurance.ismasurance.exception.dto.PolicyNotExistException;
import com.ismasurance.ismasurance.policy.data.PolicyEntity;
import com.ismasurance.ismasurance.policy.repository.PolicyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class ClaimValidations {
    @Autowired
    PolicyRepository policyRepository;
    @Autowired
    ClaimRepository claimRepository;
    public void createClaimValidations(ClaimRequest request){
        policyExistValidation(request.getClaPolicy());
        incidentDateIsNotGreaterThanCurrentDate(request.getIncidenceDate());
    }

    private void incidentDateIsNotGreaterThanCurrentDate(Date incidentDate) {
        Date date = new Date();
        if( incidentDate.getTime() > date.getTime() ){
            throw new IncidentDateGreaterThanCurrentDateException("The incident date cannot be greater than the current date",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void policyExistValidation(String claPolicy) {
        PolicyEntity policyEntity = policyRepository.findByClaPolicy(claPolicy);
        if (null == policyEntity){
            throw new PolicyNotExistException("The policy doesn't exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
