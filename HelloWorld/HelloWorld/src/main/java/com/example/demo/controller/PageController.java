package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index()
	{
		return "hello";
	}
	
//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value="name", required=false, 
//	defaultValue="dunia") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}
	
	@RequestMapping(value= {"/greeting","/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "apap");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value="a", required = false, defaultValue="0") int a, 
			                @RequestParam(value="b", required = false, defaultValue="0") int b, Model model) {
		//int hasil =0;
//		if(a.isPresent()) {
//			bila = a.get();
//		}
//		if(b.isPresent()) {
//			bilb = b.get();
//		}
//		hasil = bila * bilb;
		
//		if(a.isPresent()) {
//			hasil = a.get();
//		}
//		if(b.isPresent()) {
//			hasil = b.get();
//		}
//		hasil = a.get() * b.get();
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("hasil",a * b);
		return "perkalian";
	}
}
