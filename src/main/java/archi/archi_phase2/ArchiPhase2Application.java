package archi.archi_phase2;

import archi.archi_phase2.Controller.PromotionController;
import archi.archi_phase2.Controller.UniteEnseignementController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = PromotionController.class)
public class ArchiPhase2Application {

	public static void main(String[] args) {
		System.out.println("Helloworld");
		SpringApplication.run(ArchiPhase2Application.class, args);
	}

}
