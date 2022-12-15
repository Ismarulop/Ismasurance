package com.ismasurance.ismasurance.claim.api.v1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ClaimRequest {
    @NotBlank(message= "claPolicy")
    private String claPolicy;
    private String handlerName;
    private String insuredName;
    private Date claimDate;
    private Date incidenceDate;
    private Date expirationDate;

}
