package com.ismasurance.ismasurance.claim.api.v1.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ClaimResponse {
    private String claimId;
    private String clnClaim;
    private String claClaim;
    private String claPolicy;
    private String handlerName;
    private String insuredName;
    private Date claimDate;
    private Date incidenceDate;
    private Date expirationDate;
}
