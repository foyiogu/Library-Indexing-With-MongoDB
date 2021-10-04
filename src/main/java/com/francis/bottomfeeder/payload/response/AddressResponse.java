package com.francis.bottomfeeder.payload.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {

    @ApiModelProperty(notes = "User's Address")
    private String address;
}
