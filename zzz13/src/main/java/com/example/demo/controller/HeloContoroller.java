package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class HeloContoroller {
    @Autowired
    EmployeeRepository empRepository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Employee> emplist=empRepository.findAll();
        model.addAttribute("emplist", emplist);
        return "index";
    }
}