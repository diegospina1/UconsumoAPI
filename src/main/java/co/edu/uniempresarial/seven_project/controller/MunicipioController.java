package co.edu.uniempresarial.seven_project.controller;

import co.edu.uniempresarial.seven_project.model.Municipio;
import co.edu.uniempresarial.seven_project.service.IMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("municipio")
public class MunicipioController {

    @Autowired
    IMunicipioService service;

    @GetMapping(value = "/listar")
    public List<Municipio> listarMunicipios(){

        return service.listMunicipios();
    }

    @GetMapping(value = "/departamento/{nombre}")
    public List<Municipio> buscarPorDepartamento(@PathVariable("nombre") String departamento){
        return service.searchByDepartamento(departamento);
    }
}
