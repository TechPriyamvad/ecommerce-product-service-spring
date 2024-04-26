package dev.priyamvad.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends baseModel{
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}
