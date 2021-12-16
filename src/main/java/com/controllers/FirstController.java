package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "firstNumber",required = false) int firstNumber,
                             @RequestParam(value = "secondNumber",required = false) int secondNumber,
                             @RequestParam(value = "typeOfOperation",required = false) String typeOfOperation,
                             Model model) {
        double result;
        switch (typeOfOperation) {
            case "multiplication": // Умножение
                result = firstNumber * secondNumber;
                break;
            case "division": // Деление
                result = firstNumber / (double)secondNumber;
                break;
            case "addition": // Сложение
                result = firstNumber + secondNumber;
                break;
            case "subtraction": // Вычитание
                result = firstNumber - secondNumber;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";

    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello " + name + " " + surname);

//        System.out.println("Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
