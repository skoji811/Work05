package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Idol;
import com.example.demo.repository.IdolRepository;

@Controller
public class MainController {
@Autowired
IdolRepository repository;
@RequestMapping("/")
private ModelAndView index(ModelAndView mav) {
mav.setViewName("index");
Iterable<Idol> list = repository.findAll();
mav.addObject("data", list);
return mav;
　　　　}
}
