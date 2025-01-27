package com.jrm.app.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.jrm.app.entity.Producto;
import com.jrm.app.repository.ProductRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/productos")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
    @GetMapping
    public String findAll(Model model) {
        
        List <Producto> products = productRepository.findAll();
        model.addAttribute("productos", products);

        List<Producto> expensiveProducts = productRepository.findAllByPrecioGreaterThan(50);
        model.addAttribute("expensiveProducts", expensiveProducts);

        List<Producto> betweenProducts = productRepository.findAllByPrecioBetween(20, 50);
        model.addAttribute("betweenProducts", betweenProducts);
        return "ListarProductos";

    }

  

    @GetMapping("/nuevo")
    public String newProduct(Model model) {
        
        
        model.addAttribute("producto", new Producto());

        return "product-form";
    }

    @PostMapping
    public String save(@ModelAttribute("producto") Producto producto) {
        // Si el id del producto no es null, intentamos actualizar
        if (producto.getId() != null ) {
           
            // Buscar el producto en la base de datos por su id
            Producto productoExistente = this.productRepository.findById(producto.getId()).orElse(null);
            
            if (productoExistente != null) {
                // Si el producto existe, se actualizan sus valores
                
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setDescripcion(producto.getDescripcion());
                productoExistente.setPrecio(producto.getPrecio());
                
                // Guardar el producto actualizado
                this.productRepository.save(productoExistente);
            
            } else {
                // Si el id es null, es un nuevo producto, se guarda directamente
                this.productRepository.save(producto);
            }
        }else{

            this.productRepository.save(producto);
        }
        // Redirigir a la lista de productos después de guardar
        return "redirect:/productos";
    }



    @GetMapping("view/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        
        Producto producto = productRepository.findById(id).get();
        model.addAttribute("producto", producto);

        return "product-show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        
        Producto producto = productRepository.findById(id).get();
        model.addAttribute("producto", producto);

        return "product-form";
    }

   

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") Long id) {
        
        this.productRepository.deleteById(id);
        return "redirect:/productos";
    }
       
   
    
    

}
