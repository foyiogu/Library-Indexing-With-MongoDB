package com.francis.bottomfeeder.service;

import com.francis.bottomfeeder.model.enums.ERole;
import com.francis.bottomfeeder.payload.request.LoginRequest;
import com.francis.bottomfeeder.payload.request.RegistrationRequest;
import com.francis.bottomfeeder.payload.response.LoginResponse;
import com.francis.bottomfeeder.payload.response.RegistrationResponse;

public interface UserService {

    RegistrationResponse registration(RegistrationRequest userRegistrationRequest, ERole eRole);

    LoginResponse login(LoginRequest loginRequest);
}
