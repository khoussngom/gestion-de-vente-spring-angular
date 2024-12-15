package com.example.Produits.service;


import java.util.List;

import com.example.Produits.entities.Categorie;
import com.example.Produits.entities.Produits;

public interface ProduitService {
	Produits saveProduit(Produits p);
	Produits updateProduit(Produits p);
	void deleteProduit(Produits p);
	void deleteProduitById(Long id);
	Produits getProduit(Long id);
	List<Produits> getAllProduits();
	List<Produits> findByNomProduit(String nom);
	List<Produits> findByNomProduitContains(String nom);
	List<Produits> findByNomPrix (String nom, Double prix);
	List<Produits> findByCategorie (Categorie categorie);
	List<Produits> findByCategorieIdCat(Long id);
	List<Produits> findByOrderByNomProduitAsc();
	List<Produits> trierProduitsNomsPrix();

}
