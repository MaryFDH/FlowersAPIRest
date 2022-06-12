package com.API.flowers.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.flowers.models.Flower;
import com.API.flowers.services.FlowerService;

@RestController
@RequestMapping("flowers")
public class FlowerController {
	

	@Autowired
	private FlowerService flowerSrv;
	
	@Autowired
	private FlowerMapper flowerMpr;
	
	
	@PostMapping()
	public String create(@RequestBody ArrayList<Flower> flowers){
		this.flowerSrv.setFlowers(flowers);
		return "The save is correct";
	}
	
	@GetMapping()
	public ArrayList<FlowerDTO> getFlowers() {
		return this.flowerMpr.domainToDTOs(this.flowerSrv.getFlowers());
	}
	
	@GetMapping("/price-filter")
	public ArrayList<Flower> getFlowersFiltered() {
		return this.flowerSrv.getPriceGreaterThan20();
	}
	
	@DeleteMapping("/{id}")
	public String deleteFlower(@PathVariable("id") String id) {
		return this.flowerSrv.deleateFlower(id);
	}
	
	@GetMapping("/name-search/{name}")
	public ArrayList<Flower> getFlowersFilteredName( @PathVariable("name") String name) {
		return this.flowerSrv.getFlowersByName(name);
	}
	
	
	
	
	
	
	
	
	
}
