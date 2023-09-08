package com.incedo.graphql.poc.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "createNew")
@Entity(name = "customer")
public class Customer implements Serializable {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String city;
}
