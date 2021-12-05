package Service;

import Modele.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SessionService {

    public List<Session> getSessions() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/json/session.json"));

        List<Session> sessions = Arrays.asList(mapper.readValue(reader,Session[].class));

        return sessions;
    }

    //public Session getSessionBy
}
