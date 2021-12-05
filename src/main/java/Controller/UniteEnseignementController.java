package Controller;

import Modele.UniteEnseignement;
import Service.UniteEnseignementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UniteEnseignementController {

    private UniteEnseignementService ueservice = new UniteEnseignementService();

    @GetMapping("/ue")
    public List<UniteEnseignement> getUEs() throws IOException {
        return ueservice.getUEs();
    }

    @GetMapping("/ue/{sigle}")
    public UniteEnseignement getUEById(@PathVariable String sigle) throws IOException {
        return ueservice.getUEByName(sigle);
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
