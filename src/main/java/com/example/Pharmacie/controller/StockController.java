package com.example.Pharmacie.controller;

import com.example.Pharmacie.model.Medicament;
import com.example.Pharmacie.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicament")
public class StockController {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/ajouter")
    public String showAddMedicamentPage(Model model) {
        model.addAttribute("medicament", new Medicament());
        return "ajoutMedicamentPage";
    }

    @PostMapping("/save")
    public String saveMedicament(@ModelAttribute Medicament medicament, Model model) {
        medicamentRepository.save(medicament);
        Long id = medicament.getId();
        String message = "Record with id : '" + id + "' is saved successfully!";
        model.addAttribute("message", message);
        return "ajoutMedicamentPage";
    }

    @GetMapping("/getAllMedicaments")
    public String getAllMedicaments(@RequestParam(value = "message", required = false) String message, Model model) {
        List<Medicament> medicaments = medicamentRepository.findAll();
        model.addAttribute("list", medicaments);
        model.addAttribute("message", message);
        return "allMedicamentsPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, @RequestParam(name = "id") Long id) {
        String page = null;
        try {
            Medicament medicament = medicamentRepository.findById(id).orElse(null);
            if (medicament != null) {
                model.addAttribute("medicament", medicament);
                page = "editMedicamentPage";
            } else {
               
                return "redirect:getAllMedicaments";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:getAllMedicaments";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateMedicament(@ModelAttribute Medicament medicament) {
        medicamentRepository.save(medicament);
        Long id = medicament.getId();
        return "redirect:getAllMedicaments?message=Medicament with id: '" + id + "' is updated successfully!";
    }
    @GetMapping("/delete")
    public String deleteMedicament(@RequestParam(name = "id") Long id) {
        medicamentRepository.deleteById(id);
        return "redirect:getAllMedicaments";
    }
}

