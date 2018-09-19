package fo.auto.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class ManagerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}


}
