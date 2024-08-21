package co.edu.uniempresarial.seven_project.service;

import co.edu.uniempresarial.seven_project.model.Municipio;

import java.util.List;

public interface IMunicipioService {
    List<Municipio> listMunicipios();
    List<Municipio> searchByDepartamento(String departamento);
}
