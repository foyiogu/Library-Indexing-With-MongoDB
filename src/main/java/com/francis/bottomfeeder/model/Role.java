package com.francis.bottomfeeder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.francis.bottomfeeder.model.enums.ERole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "roles")
public class Role {

    @Id
    private String id;

    @JsonProperty("ERole")
    @Field("ERole")
    private ERole name;
}
