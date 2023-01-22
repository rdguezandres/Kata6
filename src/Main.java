import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.xml.bind.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static java.util.stream.Collectors.joining;

/**
 * @author Entrar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, JAXBException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/hello");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("phonetics").getAsJsonArray()
                .get(1).getAsJsonObject();
        Phonetic phonetic = gson.fromJson(jsonObject, Phonetic.class);
        System.out.println(phonetic.toString() + "\n");
        JAXBContext context = JAXBContext.newInstance(Phonetic.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(phonetic, System.out);
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }
    }
}
