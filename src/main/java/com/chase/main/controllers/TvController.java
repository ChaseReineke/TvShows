package com.chase.main.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chase.main.models.Tv;
import com.chase.main.services.TvService;

@Controller
public class TvController {
	private final TvService tvService;
	
	public TvController(TvService tvService) {
		this.tvService = tvService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("tv") Tv tv) {
		List<Tv> show = tvService.allShows();
		model.addAttribute("show", show);
		return "/dashboard.jsp";
	}
	
	@RequestMapping("/shows/new")
	public String newShow(@ModelAttribute("show") Tv show) {
		return "/new.jsp";
	}
	
	@RequestMapping(value="/shows/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("show") Tv show, BindingResult result) {
		if(result.hasErrors()) {
			return "/new.jsp";
		}else {
			tvService.createShow(show);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/shows/{id}", method=RequestMethod.GET)
	public String showShows(@PathVariable("id") Long id, Model model) {
		Tv shows = tvService.findShow(id);
		model.addAttribute("shows", shows);
		return "/display_show.jsp";
	}
	
	@RequestMapping(value="/shows/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		tvService.destroyLanguage(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/shows/edit/{id}")
	public String editShow(@PathVariable("id") Long id, Model model) {
		Tv show = tvService.findById(id); 
		model.addAttribute("show", show); 
		return "/edit.jsp"; 
	}
	
	@RequestMapping(value="/shows/edit/{id}", method=RequestMethod.PUT)
	public String updateShow(@PathVariable("id") Long id, @Valid @ModelAttribute("show") Tv tv, BindingResult result) {
		if(result.hasErrors()) {
			return "/edit.jsp";
		}
		tvService.saveShow(tv); 
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("network") String network, Model model) {
		List<Tv> shows = tvService.showsContainingNetwork(network);
		model.addAttribute("network", network);
		model.addAttribute("shows", shows);
		return "/search.jsp";
	}
	
	@RequestMapping(value="/search/topTen", method=RequestMethod.GET)
	public String topTen(Model model) {
		List<Tv> shows = tvService.topTenShows();
		model.addAttribute("shows", shows);
		return "/topTen.jsp";
	}
}