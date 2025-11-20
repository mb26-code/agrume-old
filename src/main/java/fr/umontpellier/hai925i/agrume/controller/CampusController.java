package fr.umontpellier.hai925i.agrume.controller;

import fr.umontpellier.hai925i.agrume.model.Campus;
import fr.umontpellier.hai925i.agrume.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campus")
public class CampusController {

    @Autowired
    private CampusService campusService;


    @GetMapping
    public String listCampus(Model model) {
        model.addAttribute("listeDesCampus", campusService.getAllCampus());
        return "campus/liste";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("campus", new Campus());
        return "campus/formulaire";
    }

    @PostMapping("/save")
    public String saveCampus(@ModelAttribute("campus") Campus campus) {
        campusService.saveCampus(campus);
        return "redirect:/campus";
    }


    @GetMapping("/delete/{nom}")
    public String deleteCampus(@PathVariable("nom") String nom) {
        campusService.deleteCampus(nom);
        return "redirect:/campus";
    }
}