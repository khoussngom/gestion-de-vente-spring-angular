package com.example.Produits;

import java.util.Date;
import java.util.List;
import java.util.Optional; // Import pour Optional

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.Produits.entities.Produits;
import com.example.Produits.entities.Categorie; // Import de la classe Categorie
import com.example.Produits.repositery.produitRepositery;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
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
		Optional<Produits> produitOpt = produitRepositery.findById(1L);
		if (produitOpt.isPresent()) {
			Produits produit = produitOpt.get();
			System.out.println(produit);
		} else {
			System.out.println("Aucun produit trouvé avec l'ID 1L");
		}
	}


	@Test
	public void testUpdateProduit() {
		// Ajouter un produit initial
		Produits produit = new Produits();
		produit.setNomProduit("Produit Test");
		produit.setPrixProduit(500.0);
		produit.setDateCreation(new Date());
		produitRepositery.save(produit);

		// Récupérer le produit et mettre à jour
		Produits produitToUpdate = produitRepositery.findById(produit.getIdPoduit()).orElseThrow();
		produitToUpdate.setPrixProduit(1000.0);
		produitRepositery.save(produitToUpdate);

		// Vérifier les modifications
		Produits updatedProduit = produitRepositery.findById(produit.getIdPoduit()).orElseThrow();
		assertEquals(1000.0, updatedProduit.getPrixProduit());
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

	@Test
	public void findByOrderByNomProduitAsc()
	{
	  List<Produits> prods = produitRepositery.findByOrderByNomProduitAsc();
	  for (Produits p : prods)
	   {
	     System.out.println(p);
	   }
	}

	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Produits> prods = produitRepositery.trierProduitsNomsPrix();
		for (Produits p : prods)
		{
			System.out.println(p);
		}

	}
}