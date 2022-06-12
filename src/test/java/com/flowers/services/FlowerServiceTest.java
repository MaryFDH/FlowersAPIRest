package com.flowers.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.API.flowers.models.Flower;
import com.API.flowers.services.FlowerService;

class FlowerServiceTest {
	
	@Autowired
	private FlowerService flowerSrv;

	@Test
	void setFlowerTest() {
		this.flowerSrv = new FlowerService();
		
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(new Flower("5","Clavel",14));
		flowers.add(new Flower("rgdf","Margarita",30.5f));
		flowers.add(new Flower("5wewe","Rosa",35));
		flowers.add(new Flower("qwewr","Dalia",10));
		
		this.flowerSrv.setFlowers(flowers);
		Assertions.assertEquals(flowers.toString(), FlowerService.flowers.toString());
	}
	
	@Test
	void getFlowerTest() {
		this.flowerSrv = new FlowerService();
		
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(new Flower("5","Clavel",14));
		flowers.add(new Flower("rgdf","Margarita",30.5f));
		flowers.add(new Flower("5wewe","Rosa",35));
		flowers.add(new Flower("qwewr","Dalia",10));		
		this.flowerSrv.setFlowers(flowers);
		
		ArrayList<Flower> answerExpected = new ArrayList<Flower>();
		answerExpected.add(new Flower("5wewe","Rosa-kometsales",35));
		answerExpected.add(new Flower("rgdf","Margarita-kometsales",30.5f));
		answerExpected.add(new Flower("qwewr","Dalia-kometsales",10));	
		answerExpected.add(new Flower("5","Clavel-kometsales",14));
		
		ArrayList<Flower> answerActual = this.flowerSrv.getFlowers();
		
		System.out.println(answerExpected.toString());
		System.out.println(answerActual.toString());
		
		Assertions.assertEquals(answerExpected.toString(), answerActual.toString());
	}
	
	@Test
	void getPriceGreaterThan20Test() {
		this.flowerSrv = new FlowerService();
		
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(new Flower("5","Clavel",14));
		flowers.add(new Flower("rgdf","Margarita",30.5f));
		flowers.add(new Flower("5wewe","Rosa",35));
		flowers.add(new Flower("qwewr","Dalia",10));		
		this.flowerSrv.setFlowers(flowers);
		
		ArrayList<Flower> answerExpected = new ArrayList<Flower>();
		answerExpected.add(new Flower("rgdf","Margarita",30.5f));
		answerExpected.add(new Flower("5wewe","Rosa",35));
		
		ArrayList<Flower> answerActual = this.flowerSrv.getPriceGreaterThan20();
		
		System.out.println(answerExpected.toString());
		System.out.println(answerActual.toString());
		
		Assertions.assertEquals(answerExpected.toString(), answerActual.toString());
	}
	
	@Test
	void deleteFlowerTest() {
		this.flowerSrv = new FlowerService();
		
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(new Flower("5","Clavel",14));
		flowers.add(new Flower("rgdf","Margarita",30.5f));
		flowers.add(new Flower("5wewe","Rosa",35));
		flowers.add(new Flower("qwewr","Dalia",10));		
		this.flowerSrv.setFlowers(flowers);
		
		
		String responseExpected = "Flower deleted ok";
		String responseExpected2 = "Flower not found";
		String responseActual = this.flowerSrv.deleateFlower("rgdf");
		String responseActual2 = this.flowerSrv.deleateFlower("2");
		
		System.out.println(responseExpected);
		System.out.println(responseActual);
		System.out.println(responseExpected2);
		System.out.println(responseActual2);
		
		Assertions.assertEquals(responseExpected, responseActual);
		Assertions.assertEquals(responseExpected2, responseActual2);
	}
	
	@Test
	void getFlowersByNameTest() {
		this.flowerSrv = new FlowerService();
		
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(new Flower("5","Clavel",14));
		flowers.add(new Flower("rgdf","Margarita",30.5f));
		flowers.add(new Flower("5wewe","Rosa",35));
		flowers.add(new Flower("qwewr","Dalia",10));		
		this.flowerSrv.setFlowers(flowers);
		
		ArrayList<Flower> answerExpected = new ArrayList<Flower>();
		answerExpected.add(new Flower("rgdf","Margarita",30.5f));
		
		ArrayList<Flower> answerActual = this.flowerSrv.getFlowersByName("Margarita");
		
		System.out.println(answerExpected.toString());
		System.out.println(answerActual.toString());
		
		Assertions.assertEquals(answerExpected.toString(), answerActual.toString());
	}

}
