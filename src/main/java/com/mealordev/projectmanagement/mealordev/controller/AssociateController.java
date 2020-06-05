package com.mealordev.projectmanagement.mealordev.controller;

import com.mealordev.projectmanagement.mealordev.model.entity.Associate;
import com.mealordev.projectmanagement.mealordev.model.interfaces.IAssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/associate")
@SessionAttributes("associate")
public class AssociateController {

    @Autowired
    private IAssociateService iAssociateService;

    @GetMapping
    public String getAllAssociate(Model model) {
        model.addAttribute("associates", iAssociateService.getAllAssociates());
        model.addAttribute("titulo", "Listado de Asociados");
        return "views/associate-views/associate-mainview";
    }


    @GetMapping(value = "/form")
    public String addAssociate(Model model) {
        Associate associate = new Associate();
        model.addAttribute("associate", associate);
        model.addAttribute("titulo", "Form associate");
        return "views/associate-views/form";
    }

    /*
     * We add inject VALID to execute the validation annotations added in the entity class.
     * We add too BindingResult to validate the result of the form and is always after the
     * validated object in the form.
     * Valid + bindignrsult always togheter
     *  */
    @PostMapping(value = "/form")
    public String saveAssociate(@Valid Associate associate, BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
        /*If the form fails entity validation annotations, we have to return the same
         * view with the error messages.*/
        if (bindingResult.hasErrors()) {
            //The instance of the object is passed to the view automaticlly when the form fails.
            model.addAttribute("titulo", "Form associate");
            return "views/associate-views/form";
        }
        iAssociateService.addAssociate(associate);
        sessionStatus.setComplete();
        return "redirect:form";
    }

    /*We use an id to find the associate in the database, then we
     * redirect to the form but filling up all the fields.*/
    @GetMapping(value = "/form/{id}")
    public String updateAssociate(@PathVariable(value = "id") Long id, Model model) {
        Associate associate = null;
        if (id > 0) {
            associate = iAssociateService.findOneAssocite(id);

        } else {
            return "redirect:views/associate-views/associate-mainview";
        }
        model.addAttribute("associate", associate);
        model.addAttribute("titulo", "Form associate");
        return "views/associate-views/form";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteAssociate(@PathVariable(value = "id") Long idAssociate) {
        if (idAssociate > 0) {
            iAssociateService.deleteAssociate(idAssociate);
        }
        return "redirect:views/associate-views/associate-mainview";
    }

}
