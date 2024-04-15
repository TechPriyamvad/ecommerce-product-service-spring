package dev.priyamvad.productservice.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateProductDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
