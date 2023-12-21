package com.example.Pharmacie.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public String getClient() {
		return client;
	}




	public void setClient(String client) {
		this.client = client;
	}




	public Date getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@ManyToMany
    @JoinTable(
        name = "order_medicament",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "medicament_id")
    )
    private List<Medicament> medicaments;



    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}




