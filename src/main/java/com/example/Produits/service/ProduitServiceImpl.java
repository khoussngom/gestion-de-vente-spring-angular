package com.example.Produits.service;

import java.util.List;

import com.example.Produits.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Produits.entities.Produits;

import com.example.Produits.repositery.produitRepositery;



@Service
public class ProduitServiceImpl implements ProduitService{
	
	
	@Autowired
	produitRepositery produitRepositery;

	@Override
	public Produits saveProduit(Produits p) {
		
		return produitRepositery.save(p);
	}

	@Override
	public Produits updateProduit(Produits p) {
		// TODO Auto-generated method stub
		return produitRepositery.save(p);
	}

	@Override
	public void deleteProduit(Produits p) {
		// TODO Auto-generated method stub
		 produitRepositery.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
	      produitRepositery.deleteById(id);
		
	}

	@Override
	public Produits getProduit(Long id) {
		// TODO Auto-generated method stub
	    return produitRepositery.findById(id).get();
	}

	@Override
	public List<Produits> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepositery.findAll();
	}

	@Override
	public List<Produits> findByNomProduit(String nom) {
		return produitRepositery.findByNomProduit(nom);
	}

	@Override
	public List<Produits> findByNomProduitContains(String nom) {
		return produitRepositery.findByNomProduitContains(nom);
	}

	@Override
	public List<Produits> findByNomPrix(String nom, Double prix) {
		return produitRepositery.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produits> findByCategorie(Categorie categorie) {
		return produitRepositery.findByCategorie(categorie);
	}

	@Override
	public List<Produits> findByCategorieIdCat(Long id) {
		return produitRepositery.findByCategorieIdCat(id);
	}

	@Override
	public List<Produits> findByOrderByNomProduitAsc() {
		return produitRepositery.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produits> trierProduitsNomsPrix() {
		return produitRepositery.trierProduitsNomsPrix();
	}

}
