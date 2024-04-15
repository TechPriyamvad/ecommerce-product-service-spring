package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.dtos.CategoriesResponseDto;
import dev.priyamvad.productservice.dtos.RequestBodySingleProductDto;
import dev.priyamvad.productservice.dtos.ResponseBodySingleProductDto;
import dev.priyamvad.productservice.dtos.UpdateProductDto;
import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
        return fakeStoreProductResponse != null ? fakeStoreProductResponse.toProduct() : null;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseBodySingleProductDto[] responseBodySingleProductDtoList = restTemplate.getForObject("https://fakestoreapi.com/products",ResponseBodySingleProductDto[].class);
        ArrayList<Product> productsList = new ArrayList<>();
        if(responseBodySingleProductDtoList != null){
            for (ResponseBodySingleProductDto responseBodySingleProductDto : responseBodySingleProductDtoList) {
                Product product = responseBodySingleProductDto.toProduct();
                productsList.add(product);
            }
        }
        return productsList;
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
        return responseBodySingleProductDto != null ? responseBodySingleProductDto.toProduct():null;
    }

    @Override
    public List<Category> getAllCategories() {
        CategoriesResponseDto[] categoriesResponseDtoList = restTemplate.getForObject("https://fakestoreapi.com/products/categories",CategoriesResponseDto[].class);
        List<Category> categoriesList = new ArrayList<>();
        if(categoriesResponseDtoList != null){
            for (CategoriesResponseDto categoriesResponseDto : categoriesResponseDtoList) {
                Category category  = new Category();
                category.setTitle(categoriesResponseDto.getCategoryTitle());
                categoriesList.add(category);
            }
        }
        return categoriesList;
    }

    @Override
    public Product updateProduct(Long id, String title, double price, String description, String image, String category) {
        UpdateProductDto updateProductDto = new UpdateProductDto();
        updateProductDto.setTitle(title);
        updateProductDto.setPrice(price);
        updateProductDto.setDescription(description);
        updateProductDto.setImage(image);
        updateProductDto.setCategory(category);

        HttpEntity<UpdateProductDto> requestEntity = new HttpEntity<>(updateProductDto);

        ResponseEntity<ResponseBodySingleProductDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/"+id,HttpMethod.PUT,requestEntity, ResponseBodySingleProductDto.class);
        if(responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()){
            ResponseBodySingleProductDto responseBodySingleProductDto = responseEntity.getBody();
            return  responseBodySingleProductDto.toProduct();
        }
        else{
            return null;
        }


    }

    @Override
    public Product deleteProduct(Long productId) {

        ResponseEntity<ResponseBodySingleProductDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/"+productId,HttpMethod.DELETE,null,ResponseBodySingleProductDto.class);
        if(responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()){
            ResponseBodySingleProductDto responseBodySingleProductDto = responseEntity.getBody();
            return responseBodySingleProductDto.toProduct();
        }
        else{
            return null;
        }

    }

    @Override
    public List<Product> getProductsOfCategory(String category) {
        ResponseBodySingleProductDto[] responseBodySingleProductDtoList = restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category+"?sort=desc&limit=2",ResponseBodySingleProductDto[].class);
        List<Product> productsList = new ArrayList<>();
        if(responseBodySingleProductDtoList != null){
            for (ResponseBodySingleProductDto responseBodySingleProductDto : responseBodySingleProductDtoList) {
                Product product = responseBodySingleProductDto.toProduct();
                productsList.add(product);
            }
        }
        return productsList;
    }
}
/*
/products/1

Rest Template(like a utility) - help you allow sending http requests to external apis and get response
 Inversion of Control(IoC)
 */