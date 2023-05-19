package com.codeup.codeupspringblog.controllers;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {
//    @RequestParam int randomNum, Model model
    @GetMapping("/rollDice")
    public String rollDice (){
        return "guessNum";
    }

    @GetMapping("/rollDice/{n}")
    public String rollDiceNumber(@PathVariable int n, Model model) {
        int randomNumber = (int)Math.floor(Math.random() * (6 - 1 + 1) + 1);
        String guess = "";

        if(randomNumber == n) {
            guess = "Yay! You guessed correctly";
        }else{
            guess = "Nice try but you're incorrect...";
        }

        model.addAttribute("userGuess", "You guessed: " + n);
        model.addAttribute("diceRoll", "dice rolled " + randomNumber);
        model.addAttribute("guess", guess);

        return "guessNum";
    }

}
