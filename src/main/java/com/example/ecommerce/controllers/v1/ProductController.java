package com.example.ecommerce.controllers.v1;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.utils.constants.Endpoints;
import java.util.List;
import java.util.UUID;
import com.example.ecommerce.utils.constants.Paths;
import com.example.ecommerce.validations.responses.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "${react.origin.url}")
@RequestMapping(Endpoints.PRODUCT_ENDPOINT)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse<List<ProductDTO>>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();

        DataResponse<List<ProductDTO>> response = new DataResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(products);

        return ResponseEntity.ok(response);
    }

    @GetMapping(Paths.Products.GET_PRODUCT_BY_ID)
    public ResponseEntity<DataResponse<ProductDTO>> getProductById(@PathVariable UUID productId) {
        ProductDTO product = productService.getProductById(productId);

        DataResponse<ProductDTO> response = new DataResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(product);

        return ResponseEntity.ok(response);
    }

    @GetMapping(Paths.Products.GET_PRODUCT_BY_CATEGORY)
    public ResponseEntity<DataResponse<List<ProductDTO>>> getAllProductsByCategory(
            @PathVariable UUID categoryId) {
        List<ProductDTO> products = productService.getAllProductsByCategoryId(categoryId);

        DataResponse<List<ProductDTO>> response = new DataResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(products);

        return ResponseEntity.ok(response);
    }
}
