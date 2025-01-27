package com.jrm.app.repository;

import com.jrm.app.entity.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {



    List<Producto> findAllByPrecioGreaterThan(double precio);

    List<Producto> findAllByPrecioBetween(double precioInicial, double precioFinal);

   

}
