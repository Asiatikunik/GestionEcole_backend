package archi.archi_phase2;

import Controller.PromotionController;
import Controller.UniteEnseignementController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = PromotionController.class)
public class ArchiPhase2Application {

	public static void main(String[] args) {
		System.out.println("Helloworld");
		SpringApplication.run(ArchiPhase2Application.class, args);
	}

}
