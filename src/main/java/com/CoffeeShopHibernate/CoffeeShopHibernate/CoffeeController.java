package com.CoffeeShopHibernate.CoffeeShopHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

	@Autowired
	CoffeeRepository coffeeDao;
	
//	@RequestMapping("/")
//	public ModelAndView home() {
//		return new ModelAndView("product-list");
//	}
	
	@RequestMapping("/")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("product-list");
		
		mv.addObject("products",coffeeDao.findAll());
		
		
		return mv;
	}
	
	@RequestMapping("/product/{id}/update")
	public ModelAndView updateProductForm(@PathVariable("id") Products id) {
		ModelAndView mv = new ModelAndView("product-form");
		mv.addObject("title", "Update Product");
		mv.addObject("product", id);
		
		return mv;
	}
	@PostMapping("/product/{id}/update")
	public ModelAndView updateProduct(Products p) {
		ModelAndView mv = new ModelAndView("redirect:/");
		//mv.addObject("title", "Update Product");
		//mv.addObject("product", id);
		coffeeDao.save(p);
		
		return mv;
	}
		
	@RequestMapping("/product/{id}/delete")
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		coffeeDao.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/product/add")
	public ModelAndView addForm() {
		ModelAndView mv = new ModelAndView("product-form");
		
		mv.addObject("title","Add Item");
		
		return mv;
		
	}
	@PostMapping("/product/add")
	public ModelAndView addProduct(Products p) {
		ModelAndView mv = new ModelAndView("redirect:/");
		//mv.addObject("title", "Update Product");
		//mv.addObject("product", id);
		coffeeDao.save(p);
		
		return mv;
	}
}
