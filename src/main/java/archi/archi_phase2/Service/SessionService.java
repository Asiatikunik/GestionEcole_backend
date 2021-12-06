package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class SessionService {

    public List<Session> getSessions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Session> sessions = null;
        String file = "src/main/resources/json/session.json";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            sessions = Arrays.asList(mapper.readValue(reader,Session[].class));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return sessions;
    }

    public Session getSessionBy(String ue, String promotion, LocalDate date, LocalTime debut, LocalTime fin) throws IOException {
        List<Session> sessions = getSessions();
        for (Session session : sessions) {
            if(session.getUniteEnseigment().getSigle().equals(ue) && session.getPromotion().getNom().equals(promotion) && session.getCreneau().getDate().equals(date) && session.getCreneau().getDebut().equals(debut) && session.getCreneau().getFin().equals(fin)) {
                return session;
            }
        }
        return null;

    }

    //public Session getSessionBy
}
