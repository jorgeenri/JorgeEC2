package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Productos;
import com.example.demo.service.ProductosService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductosService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>>listar(){
		return new ResponseEntity<List<Productos>>(service.listar(), HttpStatus.OK);
	}
	
	
	//guardar
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void>guardar(@RequestBody Productos productos){
		service.guardar(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//por id
	@RequestMapping(path = "/listar/{ïd}",method = RequestMethod.GET)
	public ResponseEntity<Productos> obtenerPorId(@PathVariable Integer id){
		Productos productos = service.obtener(id);
		
		if(productos != null) {
			return new ResponseEntity<Productos>(productos, HttpStatus.OK);
		}else {
			return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//actualizar
	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Productos productos){
		Productos p = service.obtener(productos.getIdProducto());
		
		if(p != null) {
			service.actualizar(productos);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//eliminar
	@RequestMapping(path = "/eliminar/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Productos productos = service.obtener(id);
		
		if(productos != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
