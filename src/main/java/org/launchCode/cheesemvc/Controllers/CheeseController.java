package org.launchCode.cheesemvc.Controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController
{
    static ArrayList<String> cheeses = new ArrayList<>(); //Not a substitute for a DB

    @RequestMapping(value = "")
    public String index(Model model)
    {
        model.addAttribute("title", "My Cheeses") ;
        model.addAttribute("cheeses", cheeses) ;

        return "cheese/index" ;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model)
    {
        model.addAttribute("title", "Add Cheese") ;
        return "cheese/add" ;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName)
    {
       cheeses.add(cheeseName) ;

       //redirects to /cheese
       return "redirect:";
    }
}
