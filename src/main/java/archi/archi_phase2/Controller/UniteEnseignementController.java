package archi.archi_phase2.Controller;


import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Modele.UniteEnseignement;
import archi.archi_phase2.Service.UniteEnseignementService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UniteEnseignementController {

    private UniteEnseignementService ueService;

    public UniteEnseignementController(UniteEnseignementService ueService) {
        this.ueService = ueService;
    }

    @GetMapping("/ue")
    public List<UniteEnseignement> getUEs() throws IOException {
        return ueService.getUEs();
    }

    @GetMapping("/ue/{sigle}")
    public UniteEnseignement getUEById(@PathVariable String sigle) throws IOException {
        return ueService.getUEByName(sigle);
    }

    @PostMapping("/ue")
    public void addProm(@RequestBody UniteEnseignement ue) throws IOException {
        ueService.addUe(ue);
    }


    @RequestMapping("/hello")
    public String hello() {
        return "Hello World RESTful with Spring Boot";
    }

//    @GetMapping("/getlisteue")
//    public List<UniteEnseignement> getListeUE() {
//        List<UniteEnseignement> temp = new ArrayList<UniteEnseignement>();
//        String query = "SELECT * FROM ue";
//
//        try {
//            Connection connection = Connexion.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                UniteEnseignement ue = new UniteEnseignement(rs.getString(1), rs.getString(2));
//
//                temp.add(ue);
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            Connexion.closeConnection();
//        }
//
//        return temp;
//    }

}
