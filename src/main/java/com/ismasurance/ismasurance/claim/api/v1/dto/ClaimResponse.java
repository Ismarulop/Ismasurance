package com.ismasurance.ismasurance.claim.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class ClaimResponse {
    private String id;
    private String claPolicy;
    private String handlerName;
    private String insuredName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date claimDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date incidenceDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date expirationDate;
}
