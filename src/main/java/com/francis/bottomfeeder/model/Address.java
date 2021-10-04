package com.francis.bottomfeeder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Document(collection = "addresses")
public class Address extends BaseModel{

    @Field("addresss")
    private String addresss;

    //    @Field("city")
//    private String city;

//    private UserEntity user;
}
