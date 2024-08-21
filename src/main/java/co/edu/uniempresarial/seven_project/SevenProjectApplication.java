package co.edu.uniempresarial.seven_project;

import co.edu.uniempresarial.seven_project.service.MunicipioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SevenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SevenProjectApplication.class, args);
	}

	//REST template
	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}


}
