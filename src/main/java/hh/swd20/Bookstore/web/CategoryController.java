package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		
		return "categorylist"; // categorylist.html
	}
	
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory"; // addcategory.html
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		crepository.save(category);
		return "redirect:/categorylist"; // categorylist.html
	}
}
