package co.edu.uniempresarial.seven_project.service;

import co.edu.uniempresarial.seven_project.model.Municipio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioService implements IMunicipioService {

    final private String URL = "https://www.datos.gov.co/resource/xdk5-pm3f.json";

    @Autowired
    RestTemplate template;

    @Override
    public List<Municipio> listMunicipios() {
        String response = template.getForObject(URL, String.class);
        Municipio municipio;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Municipio> municipioList = new ArrayList<>();
        ArrayNode arrayNode;

        try {
            arrayNode = (ArrayNode) objectMapper.readTree(response);
            for (Object object : arrayNode) {
                ObjectNode json = (ObjectNode) object;
                municipio = new Municipio(
                        json.get("region").asText(),
                        json.get("departamento").asText(),
                        json.get("municipio").asText(),
                        json.get("c_digo_dane_del_departamento").asInt());
                municipioList.add(municipio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return municipioList;
    }

    @Override
    public List<Municipio> searchByDepartamento(String departamento) {
        return listMunicipios()
                .stream()
                .filter(m -> m.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }
}
