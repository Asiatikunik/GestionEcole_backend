package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Creneau;
import archi.archi_phase2.Modele.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    private String filename = "src/main/resources/json/session.json";

    public List<Session> getSessions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Session> sessions = null;
        String file = "src/main/resources/json/session.json";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            sessions = new ArrayList<>(Arrays.asList(mapper.readValue(reader, Session[].class)));
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

    public void addSession(Session session) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Session> sessions = getSessions();
        sessions.add(session);
        String json = mapper.writeValueAsString(sessions);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }

    public void deleteSession(Session session) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Session> sessions = getSessions();
        System.out.println(sessions);
        sessions.removeIf(sess -> (sess.isEquals(session)));
        System.out.println(sessions);
        String json = mapper.writeValueAsString(sessions);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }
}
