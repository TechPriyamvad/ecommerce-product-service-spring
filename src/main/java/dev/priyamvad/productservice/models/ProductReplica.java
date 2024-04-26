package dev.priyamvad.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductReplica extends baseModel{
    private String name;
    private int age;
}
