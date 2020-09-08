package uk.pover.stationgates;

import com.fasterxml.jackson.core.JsonProcessingException;
import uk.pover.stationgates.models.IModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class WebApi {
    public WebApi(StationGates plugin) {
        _plugin = plugin;
    }

    public boolean SaveModel(IModel model) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(model);

            String name = model.getClass().getName().toLowerCase();
            name = (name.substring(0,1).toUpperCase()) + name.substring(1);

            String endpoint = name;
            String method = "PUT";
        } catch(JsonProcessingException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    private StationGates _plugin;
}
