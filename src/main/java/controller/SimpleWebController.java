package main.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.Model.Party;


@Controller
public class SimpleWebController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String partyForm(Model model) {
        model.addAttribute("party", new Party());
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String partySubmit(@ModelAttribute Party party, Model model) {
    	
        model.addAttribute("party", party);
        String info = String.format("Party Submission: id = %d, firstname = %s, lastname = %s", 
        		party.getId(), party.getFirstname(), party.getLastname());
        log.info(info);
        
        return "result";
    }

}