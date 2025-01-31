package Spring_Sem04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringSem04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSem04Application.class, args);
	}

}
