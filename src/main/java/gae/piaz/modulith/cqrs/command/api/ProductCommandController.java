package gae.piaz.modulith.cqrs.command.api;

import gae.piaz.modulith.cqrs.command.service.ProductCommandService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/api/products/commands")
@AllArgsConstructor
public class ProductCommandController {
    private final ProductCommandService commandService;

    // curl -X POST http://localhost:8080/api/products/commands \
    //   -H "Content-Type: application/json" \
    //   -d '{"name":"Product 1","description":"Description","price":99.99,"stock":100,"category":"Electronics"}'

    public record CreateProductRequest(String name, String description, BigDecimal price, Integer stock, String category) {}
    public record UpdateProductRequest(String name, String description, BigDecimal price, Integer stock, String category) {}

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody CreateProductRequest request) {
        Long id = commandService.createProduct(
            request.name(), 
            request.description(),
            request.price(),
            request.stock(),
            request.category()
        );
        return ResponseEntity.created(URI.create("/api/products/" + id)).body(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id,
                                             @RequestBody UpdateProductRequest request) {
        commandService.updateProduct(
            id,
            request.name(),
            request.description(),
            request.price(),
            request.stock(),
            request.category()
        );
        return ResponseEntity.noContent().build();
    }
    
    }