package com.example.Produits.service;


import java.util.List;

import com.example.Produits.entities.Produits;

public interface ProduitService {
	Produits saveProduit(Produits p);
	Produits updateProduit(Produits p);
	void deleteProduit(Produits p);
	void deleteProduitById(Long id);
	Produits getProduit(Long id);
	List<Produits> getAllProduits();

}
