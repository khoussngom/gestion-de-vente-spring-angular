package com.example.Produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Produits.repositery.produitRepositery;
import com.example.Produits.entities.Categorie;
import com.example.Produits.entities.Produits;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private produitRepositery produitRepositery;
	@Test
	public void testCreateProduit() {
	Produits prod = new Produits("PC HP",2000.,new Date());
	produitRepositery.save(prod);
	}
	
	@Test
	public void testFindProduit() {
	Produits p = produitRepositery.findById(1L).get();
	
	System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit() {
	Produits p = produitRepositery.findById(1L).get();
	
	p.setPrixProduit(1000.0);
	
	produitRepositery.save(p);
	}
	
	
	@Test
	public void testDeleteProduit() {
		

		produitRepositery.deleteById(1L);
		
      }
	
	@Test
	public void testFindProduitByNom() {
	List<Produits> prods = produitRepositery.findByNomProduit("PC Dell");
	
	for (Produits p:prods)
	    System.out.println(prods);
	}
	
	@Test
	public void testFindProduitByNomContains() {
	List<Produits> prods = produitRepositery.findByNomProduitContains("P");
	
	for (Produits p:prods)
	    System.out.println(prods);
	}
	
	@Test
	public void testfindByNomPrix()
	{
	
	   List<Produits> prods = produitRepositery.findByNomPrix("PC DELL", 2200.5);
	     
	   for (Produits p:prods)
	      
	        System.out.println(prods);
	     
	}
	
	@Test
	public void testfindByCategorie()
	{
	
	   Categorie cat = new Categorie();
	   cat.setIdCat(1L);
	   List<Produits> prods = produitRepositery.findByCategorie(cat);
	     for (Produits p : prods)
	       {
	         System.out.println(p);
	       }
	}

	
	@Test
	public void findByCategorieIdCat()
	{
	  List<Produits> prods = produitRepositery.findByCategorieIdCat(1L);
	  for (Produits p : prods)
	   {
	     System.out.println(p);
	   }
	}
	
	
}