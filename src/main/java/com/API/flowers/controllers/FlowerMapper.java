package com.API.flowers.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.API.flowers.models.Flower;

@Component
public class FlowerMapper {

	
	public ArrayList<FlowerDTO> domainToDTOs(ArrayList<Flower> flowers) {
		
		ArrayList<FlowerDTO> flowersDTO = new ArrayList<FlowerDTO>();
		
		flowers.forEach(flower ->{
			
			FlowerDTO fDTO = new FlowerDTO(flower.getName(), flower.getPrice());
			
			flowersDTO.add(fDTO);
		});
		
		return flowersDTO;
	}
	
	
}
