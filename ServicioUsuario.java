/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaApiDemo.jrTarjetas.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="ServicioRest")
public class ServicioUsuario {
   
    
    @RequestMapping(method=RequestMethod.GET,produces="application/json",path ="getUser")
    public @ResponseBody ModelResponse getUser(){
       ModelResponse r=new ModelResponse();
       r.setId(111);
       r.setNombre("Reinaldo");
       r.setCode(1710);
       r.setStatus(true);
       return r;
   }
}
