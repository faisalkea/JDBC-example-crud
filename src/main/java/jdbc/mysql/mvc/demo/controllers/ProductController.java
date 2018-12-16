package jdbc.mysql.mvc.demo.controllers;

import jdbc.mysql.mvc.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    List<Product> products = new ArrayList<>();

    public ProductController() {
        //(int productId, String name, String title, String price, Boolean inStock, Boolean isActive, String category, String imageUrl) {
        Product p = new Product(1, "Name", "Title", "Price",
                true, true, "Breathing", "bt.dk");
        Product p2 = new Product(2, "Name2", "Title2", "Price",
                true, true, "Breathing", "bt.dk");
        Product p3 = new Product(3, "Name3", "Title3", "Price",
                true, true, "Breathing", "bt.dk");
        products.add(p);
        products.add(p2);
        products.add(p3);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> listAll() {

        try {

            return new ResponseEntity<>(products, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
