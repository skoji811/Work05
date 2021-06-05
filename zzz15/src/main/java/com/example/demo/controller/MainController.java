package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Idol;
import com.example.demo.repository.IdolRepository;

@Controller
public class MainController {

@Autowired
IdolRepository repository;

@GetMapping
public String index(Model model) {
Iterable<Idol> list = repository.findAll();
model.addAttribute("data", list);
return "index";
}

@GetMapping("/new")
public String newSet(Model model) {
	return "new";
}

@GetMapping("/update")
public String update(Model model) {
	Iterable<Idol> list = repository.findAll();
	model.addAttribute("data", list);
	return "update";
}
@GetMapping("/delete")
public String delete(Model model) {
	Iterable<Idol> list = repository.findAll();
	model.addAttribute("data", list);
	return "delete";
}

@PostMapping("/insert")
@Transactional(readOnly = false)
private String insert(@ModelAttribute("formInsert") Idol idol, Model model) {
repository.saveAndFlush(idol);
return "redirect:/";
}
@PostMapping("/update")
public String setUpdate(@ModelAttribute("updateInsert")Idol idol,Model model) {
	repository.saveAndFlush(idol);
	return "redirect:/";
	}


@PostMapping("/delete")
public String setDelete(@ModelAttribute("deleteInsert")Idol idol,Model model) {
	repository.delete(idol);
	return "redirect:/";
}
}
