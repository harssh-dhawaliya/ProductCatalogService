package com.psc.productcatalogservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private String name;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}

