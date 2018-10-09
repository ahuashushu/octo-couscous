package org.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.product.service.TypesService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class TypesController {

    @Autowired
    private TypesService typesService;

    public String getTypes(ModelMap map){
       List list=typesService.selectName();
        map.addAttribute("listName",list);
        return "productList";
    }

}
