package com.jrm.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrm.app.entity.Producto;
import com.jrm.app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/producto")

public class ApiProductoController {

    private final ProductRepository productRepository;

    public ApiProductoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // @GetMapping("/{id}")
    // public Producto getProducto(@PathVariable("id") Long id) {
        
    //     Optional<Producto> product = productRepository.findById(id);

    //     return product.get();
        
    // }

    // @GetMapping("/lista")
    // public List<Producto> getLista() {

    //     List<Producto>p=productRepository.findAll();

    //     return p;
    // }

    

    // @GetMapping("/mas/{num}")
    // public List<Producto> getListaMas(@PathVariable("num") double num) {

    //     List<Producto> p=productRepository.findAllByPrecioGreaterThan(num);

    //     return p;
    // }
    
    // @GetMapping("/error")
    // public String error() {

    //     throw new RuntimeException("Error en el servidor");
        

    // }

    @GetMapping
    public List<Producto> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getById(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    
    @PostMapping("/")
    public Producto crear(@RequestBody Producto producto) {
        // Aquí recibimos todo el objeto Producto, y lo guardamos en el repositorio
        return productRepository.save(producto);
    }

    // Actualizar un producto con @PutMapping
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable("id") Long id, @RequestBody Producto producto) {
        // Verifica si el producto existe
        Optional<Producto> existingProduct = productRepository.findById(id);
        
        if (existingProduct.isPresent()) {
            Producto updatedProduct = existingProduct.get();
            updatedProduct.setNombre(producto.getNombre());
            updatedProduct.setDescripcion(producto.getDescripcion());
            updatedProduct.setPrecio(producto.getPrecio());
            
            // Guardamos el producto actualizado
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    //eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    
    


    
    

}
