package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Idol;
import com.example.demo.repository.IdolRepository;

@Controller
public class MainController {
@Autowired
IdolRepository idolRepository;
@RequestMapping("/")
private String index(Model model) {

	Iterable<Idol> list = repository.findAll();
	model.addAttribute("data",list);
}
}
