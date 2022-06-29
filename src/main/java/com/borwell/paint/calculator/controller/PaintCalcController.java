package com.borwell.paint.calculator.controller;

import com.borwell.paint.calculator.model.Calculations;
import com.borwell.paint.calculator.model.Dimensions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaintCalcController
{
    @GetMapping("/dimensions")
    public String paintForm(Model model){
        model.addAttribute("dimensions", new Dimensions());
        return "dimensions";
    }

    @PostMapping("/dimensions")
    public String paintSubmit(@ModelAttribute Dimensions dimensions, Model model){
        Calculations calculations = new Calculations(dimensions);

        model.addAttribute("dimensions", dimensions);
        model.addAttribute("volume", calculations.roomVolume());
        model.addAttribute("floorArea", calculations.floorArea());
        model.addAttribute("paintRequired", calculations.paintRequired());

        return "results";
    }
}
