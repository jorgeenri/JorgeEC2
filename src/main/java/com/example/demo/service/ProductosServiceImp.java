package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Productos;
import com.example.demo.repository.ProductosRepository;

@Service
public class ProductosServiceImp implements ProductosService{
	
	
	@Autowired
	private ProductosRepository repositorio;

	@Override
	public void guardar(Productos producto) {
		// TODO Auto-generated method stub
		repositorio.save(producto);
		
	}

	@Override
	public void actualizar(Productos producto) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(producto);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Productos> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Productos obtener(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}
	
 

}
