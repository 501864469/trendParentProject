package org.springcloud.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springcloud.pojo.Product;
import org.springcloud.client.ProductClientRibbon;
@Service
public class ProductService {
    @Autowired ProductClientRibbon productClientRibbon;
    public List<Product> listProducts(){
        return productClientRibbon.listProducts();
    }
}
