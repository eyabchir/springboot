package com.example.Pharmacie.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pharmacie.model.Medicament;

public interface MedicamentRepository  extends JpaRepository<Medicament, Long> {


}
