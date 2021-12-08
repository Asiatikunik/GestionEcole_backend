package archi.archi_phase2;

import archi.archi_phase2.Controller.PromotionController;
import archi.archi_phase2.Controller.UniteEnseignementController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
//@ComponentScan(basePackageClasses = PromotionController.class)
public class ArchiPhase2Application {

	public static void main(String[] args) {
		System.out.println("Helloworld");
		SpringApplication.run(ArchiPhase2Application.class, args);
	}

}
