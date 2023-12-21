package com.example.Pharmacie.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicament")
public class Medicament {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;
	    private int quantite;
	    private String description;
	    private double price;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		 @ManyToMany(mappedBy = "medicaments")
		    private List<Order> orders;

		    // existing methods...

		    public List<Order> getOrders() {
		        return orders;
		    }

		    public void setOrders(List<Order> orders) {
		        this.orders = orders;
		    }
			public List<OrderMedicament> getOrderMedicaments() {
				// TODO Auto-generated method stub
				return null;
			}
			public void setOrderMedicaments(List<OrderMedicament> orderMedicamentList) {
				// TODO Auto-generated method stub
				
			}
		
	}

