package tn.essat.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.ILivreDao;
import tn.essat.model.Livre;

@RestController
@RequestMapping("/rest")
public class AppController {
	
	@Autowired
	ILivreDao dao;
	
	public void setDao(ILivreDao dao) {
		this.dao = dao;
	}
	
	@GetMapping("/livres")
	public List<Livre> get1(){
		return dao.findAll();
	}
	
	@GetMapping("/livre/{id}")
	public Optional<Livre> get2(@PathVariable("id") int id){
		return dao.findById(id);
	}
	@PostMapping("/addLivre")
	public void get3(@RequestBody Livre lv){
		dao.save(lv);
	}
	
	@DeleteMapping("/deleteLivre/{id}")
	public void get4(@PathVariable("id") int id){
		dao.deleteById(id);
	}

}
