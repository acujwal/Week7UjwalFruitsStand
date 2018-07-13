package com.example.fruitstand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

@Autowired
FruitRepository fruitRepository;

@Autowired
WeekdayRepository weekdayRepository;


    @RequestMapping("/")
    public String fruitsDetails(Model model) {
        model.addAttribute("fruits", fruitRepository.findAll());
        model.addAttribute("weekdays", weekdayRepository.findAll());
        return "index";
    }

    @GetMapping("/search")
    public String getSearch()
    {
        return "fruitform";
    }

    @GetMapping("/search1")
    public String getSearch1()
    {
        return "weekform";
    }

    @GetMapping("/add1")
    public String AddTime(Model model) {
        return "weekform";
    }

    @GetMapping("/add")
    public String AddFruit(Model model) {
        return "fruitform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Fruit fruit, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "fruitform";
        }
        String search = request.getParameter("id");
        model.addAttribute("listResult",fruitRepository.findByNameIgnoreCase(search));
        return "fruitform";
    }

    @PostMapping("/processdays")
    public String processForm(@Valid Weekday weekday, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "weekform";
        }
        String search = request.getParameter("id");
        model.addAttribute("listResult",weekdayRepository.findByDaysIgnoreCase(search));
        return "weekform";
    }

}
