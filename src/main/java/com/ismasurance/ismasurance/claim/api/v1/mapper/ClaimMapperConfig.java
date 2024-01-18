package com.ismasurance.ismasurance.claim.api.v1.mapper;


import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClaimMapperConfig {

    @Bean
    public ClaimMapper claimMapper() {
        return new ClaimMapper() {
            @Override
            public ClaimEntity claimRequestToClaimEntity(ClaimRequest request) {
                ClaimEntity entity = new ClaimEntity();
                entity.setClaPolicy(request.getClaPolicy());
                entity.setHandlerName(request.getHandlerName());
                entity.setInsuredName(request.getInsuredName());
                entity.setClaimDate(request.getClaimDate());
                entity.setIncidenceDate(request.getIncidenceDate());
                entity.setExpirationDate(request.getExpirationDate());

                return entity;
            }

            @Override
            public ClaimResponse claimEntityToClaimResponse(ClaimEntity claimEntity) {
                ClaimResponse response = new ClaimResponse();
                response.setId(claimEntity.getId().toHexString());
                response.setClaPolicy(claimEntity.getClaPolicy());
                response.setHandlerName(claimEntity.getHandlerName());
                response.setInsuredName(claimEntity.getInsuredName());
                response.setClaimDate(claimEntity.getClaimDate());
                response.setIncidenceDate(claimEntity.getIncidenceDate());
                response.setExpirationDate(claimEntity.getExpirationDate());

                return response;

            }
        };
    }
}
