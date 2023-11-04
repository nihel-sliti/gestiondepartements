package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Enseignants;
import net.javaguides.sms.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnseignantController {

    private EnseignantService enseignantService;


    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/enseignants")
    public String listEnseignants(Model model) {
        model.addAttribute("enseignants", enseignantService.getAllEnseignant());
        return "enseignants";
    }

    @GetMapping("/enseignants/new")
    public String createEnseignantForm(Model model) {
        Enseignants enseignant = new Enseignants();
        model.addAttribute("enseignant", enseignant);
        return "create_enseignant";
    }

    @PostMapping("/enseignants")
    public String saveEnseignant(@ModelAttribute("enseignant") Enseignants enseignant) {
        enseignantService.saveEnseignant(enseignant);
        return "redirect:/enseignants";
    }

    @GetMapping("/enseignants/edit/{id}")
    public String editEnseignantForm(@PathVariable Long id, Model model) {
        Enseignants enseignant = enseignantService.getEnseignantById(id);
        model.addAttribute("enseignant", enseignant);
        return "edit_enseignant";
    }

    @PostMapping("/enseignants/{id}")
    public String updateEnseignant(@PathVariable Long id,
                                   @ModelAttribute("enseignant") Enseignants enseignant) {
        Enseignants existingEnseignant = enseignantService.getEnseignantById(id);
        existingEnseignant.setId(id);
        existingEnseignant.setFirstName(enseignant.getFirstName());
        existingEnseignant.setLastName(enseignant.getLastName());
        existingEnseignant.setEmail(enseignant.getEmail());

        enseignantService.updateEnseignant(existingEnseignant);
        return "redirect:/enseignants";
    }

    @GetMapping("/enseignants/delete/{id}")
    public String deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignantById(id);
        return "redirect:/enseignants";
    }
}
