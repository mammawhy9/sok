package pl.gda.pg.skos.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.gda.pg.skos.entities.Candidate;
import pl.gda.pg.skos.entities.Task;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class BackendUtils implements Serializable {

    private static final long serialVersionUID = 2574327097347360037L;
    private static final String BACKEND_ADDRESS = "http://sok-dev.ds.pg.gda.pl/backend";
    private static Gson gson = new Gson();

    public static Candidate getCandidateFromToken(String token) {
        Candidate candidate = null;
        try {
            String url = BACKEND_ADDRESS + "/user/" + token;
            Document data = Jsoup.connect(url).ignoreContentType(true).get();
            String json = data.select("body").text();
            candidate = gson.fromJson(json, Candidate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidate;
    }

    public static List<Task> getTasks() {
        List<Task> tasks = null;
        try {
            String url = BACKEND_ADDRESS + "/tasks";
            Document data = Jsoup.connect(url).ignoreContentType(true).get();
            String json = data.select("body").text();
            tasks = gson.fromJson(json, new TypeToken<List<Task>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
