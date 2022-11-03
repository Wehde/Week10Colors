/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 30, 2022
 */
package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.HexColor;
import dmacc.beans.Palette;
import dmacc.repository.ColorRepository;
import dmacc.repository.PaletteRepository;

@Controller
public class WebController {
	@Autowired
	PaletteRepository repoP;
	@Autowired
	ColorRepository repoC;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllPalettes(Model model) {
		if(repoP.findAll().isEmpty()) {
			System.out.println("EMPTY");
			return addNewPalette(model);
		}
		model.addAttribute("palettes", repoP.findAll());
		return "results";
	}
	
	@GetMapping("/viewColors")
	public String viewAllColors(Model model) {
		if(repoC.findAll().isEmpty()) {
			return addNewColor(model);
		}
		model.addAttribute("colors", repoC.findAll());
		return "colors";
	}
	
	@GetMapping("/inputPalette")
	public String addNewPalette(Model model) {
		Palette p = new Palette();
		model.addAttribute("newPalette", p);
		
		List<HexColor> colors = repoC.findAll();
		
		model.addAttribute("allColors", colors);
		return "paletteInput";
	}
	
	@PostMapping("/inputPalette")
	public String addNewPalette(@ModelAttribute Palette p, Model model) {
		repoP.save(p);
		return viewAllPalettes(model);
	}
	
	@GetMapping("/inputColor")
	public String addNewColor(Model model) {
		HexColor c = new HexColor();
		model.addAttribute("newColor", c);
		return "colorInput";
	}
	
	@PostMapping("/inputColor")
	public String addNewColor(@ModelAttribute HexColor c, Model model) {
		repoC.save(c);
		return viewAllColors(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePalette(@PathVariable("id") long id, Model model) {
		Palette p = repoP.findById(id).orElse(null);
		model.addAttribute("newPalette", p);
		List<HexColor> colors = repoC.findAll();
		
		model.addAttribute("allColors", colors);
		return "paletteInput";
	}
	
	@PostMapping("/update/{id}")
	public String revisePalette(Palette p, Model model) {
		repoP .save(p);
		return viewAllPalettes(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePalette(@PathVariable("id") long id, Model model) {
		Palette p = repoP.findById(id).orElse(null);
		repoP.delete(p);
		return viewAllPalettes(model);
	}
}
