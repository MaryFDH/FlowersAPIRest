package com.API.flowers.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.API.flowers.models.Flower;

@Service
public class FlowerService {
	
	public static ArrayList<Flower> flowers;
	
	
	FlowerService(){
		FlowerService.flowers = new ArrayList<Flower>();
	}
	
	
	
	public void setFlowers(ArrayList<Flower> flowers){
		FlowerService.flowers = flowers;
	}
	
	
	
	public ArrayList<Flower> getFlowers(){
		
		ArrayList<Flower> flowersCopy = this.copyFlowers();
		
		Collections.sort(flowersCopy, (f1,f2)-> f2.getName().compareTo(f1.getName()));
		
		flowersCopy.forEach(flower ->{
			flower.setName(flower.getName()+"-kometsales");
		});
	
		return flowersCopy; 
	}
	
	
	public ArrayList<Flower> getPriceGreaterThan20(){
		
		ArrayList<Flower> filteredFlowers = new ArrayList<Flower>();
		
		FlowerService.flowers.forEach(flower ->{
			if(flower.getPrice()> 20){
				filteredFlowers.add(flower);
			}
		});
		
		return filteredFlowers;
	}
	
	public String deleateFlower(String id) {
		int index = -1;
		
		for(int i=0 ; i<FlowerService.flowers.size(); i++) {
			if(FlowerService.flowers.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		if(index > -1 ) {
			FlowerService.flowers.remove(index);
			return "Flower deleted ok";
		}else {
			return "Flower not found";
		}
	}
	
	
	public ArrayList<Flower> getFlowersByName(String name){
		
		ArrayList<Flower> filteredFlowers = new ArrayList<Flower>();
		
		FlowerService.flowers.forEach(flower ->{
			if(flower.getName().equals(name)) {
				filteredFlowers.add(flower);
			}
		});
		
		return filteredFlowers;
	}
	
	private ArrayList<Flower> copyFlowers(){
		ArrayList<Flower> flowersCopy = new ArrayList<Flower>();
		Iterator<Flower> iterator = FlowerService.flowers.iterator();
		 
		while(iterator.hasNext()){
			flowersCopy.add((Flower)iterator.next().clone());
		}
		
		return flowersCopy;
	}
}
