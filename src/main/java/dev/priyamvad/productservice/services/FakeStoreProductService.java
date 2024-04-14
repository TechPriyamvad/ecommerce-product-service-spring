package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.dtos.RequestBodySingleProductDto;
import dev.priyamvad.productservice.dtos.ResponseBodySingleProductDto;
import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// Service to interact with fakestore api's
@Service("fakestore")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        ResponseBodySingleProductDto fakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products/"+productId, ResponseBodySingleProductDto.class);
        return fakeStoreProductResponse.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, double price, String description, String image, String category) {
        RequestBodySingleProductDto requestBodyDto = new RequestBodySingleProductDto();
        requestBodyDto.setTitle(title);
        requestBodyDto.setPrice(price);
        requestBodyDto.setDescription(description);
        requestBodyDto.setImage(image);
        requestBodyDto.setCategory(category);
        ResponseBodySingleProductDto responseBodySingleProductDto = restTemplate.postForObject("https://fakestoreapi.com/products",requestBodyDto, ResponseBodySingleProductDto.class);
        return responseBodySingleProductDto.toProduct();
    }
}
/*
/products/1

Rest Template(like a utility) - help you allow sending http requests to external apis and get response
 Inversion of Control(IoC)
 */