package com.jrm.app;

import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jrm.app.entity.Producto;
import com.jrm.app.repository.ProductRepository;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {

		
		// ApplicationContext context = 
		SpringApplication.run(AppApplication.class, args);



		// var repository = context.getBean(ProductRepository.class);

		// List<Producto> productos = List.of(

		// 		new Producto(null,"Metal Gear Solid", "Descripcion 1", 10.0),
		// 		new Producto(null,"Splatoon 2", "Descripcion 2", 20.0),	
		// 		new Producto(null,"Mortal Kombat 1", "Descripcion 3", 30.0),
		// 		new Producto(null,"Elder Ring", "Descripcion 4", 40.0),
		// 		new Producto(null,"Booderlans 2", "Descripcion 5", 50.0),
		// 		new Producto(null,"Skyrim", "Descripcion 6", 60.0),
		// 		new Producto(null,"Silent Hill", "Descripcion 7", 70.0),
		// 		new Producto(null,"The Witcher 3", "Descripcion 8", 80.0),
		// 		new Producto(null,"Assassin's Creed", "Descripcion 9", 90.0),
		// 		new Producto(null,"Resident Evil", "Descripcion 10", 100.0)
					

		// );

		// repository.saveAll(productos);
		
	}

}
