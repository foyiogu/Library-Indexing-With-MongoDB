package com.francis.bottomfeeder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


//@Entity morphia
@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseModel{

    //@field is for customizing the field name
    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

//    for making unique elements
    @Indexed(unique = true)
    private String email;

//    @JsonIgnore
//    @Field("phone_number")
//    @Indexed(unique = true)
//    private String phoneNumber; //todo : for later

    @JsonIgnore
    @Field("isActive")
    private boolean isActive = true;

    @Reference
    @Field("address")
    private Address address;

    @JsonIgnore
    private String password;
//
//    @JsonIgnore
//    @JsonProperty("password_reset_token")
//    @Field("password_reset_token")
//    private String passwordResetToken;
//
//    @JsonIgnore
//    @Field("password_reset_expire_date")
//    private String passwordResetExpireDate;
//
    @JsonIgnore
    @Reference
    @Field("roles")
    private List<Role> roles;

    public UserEntity(String firstName, String lastName, String email, String password, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
