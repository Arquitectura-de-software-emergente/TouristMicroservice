package com.exactech.TouristMicroservice.tourist.resource;

import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private boolean success;
    private String message;
    private String token;
    private Tourist tourist;

    public LoginResponse(boolean success, String message, Tourist tourist, String token) {
        this.success = success;
        this.message = message;
        this.tourist = tourist;
        this.token = token;
    }
}
