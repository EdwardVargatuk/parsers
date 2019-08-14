package ed.tasks.parsers.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ed.tasks.parsers.models.Cluster;
import ed.tasks.parsers.models.FallibleWithInners;
import ed.tasks.parsers.models.Node;
import ed.tasks.parsers.models.Server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 12.08.2019 20:48
 *
 * @author Edward
 */
public class JsonParser {

    private static final String NODE = "node.json";
    private static final String SERVER = "server.json";
    private static final String CLUSTER = "cluster.json";

    public static void toJSON(FallibleWithInners fallibleWithInners) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String filename = JsonParser.getFilename(fallibleWithInners);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), fallibleWithInners);
        System.out.println("json created!" + filename);
    }

    //hardcore changes for example
    public static void editNodeJson() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(NODE));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(bytes);
        ObjectNode node = ((ObjectNode) jsonNode);
        node.put("Number", 777);
        node.put("New_Value", "new value");
        node.remove("Transaction_passed");
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("updatedNode.json"), node);
        System.out.println("json created! updatedNode.json");
    }

    private static String getFilename(FallibleWithInners fallibleWithInners) {
        if (fallibleWithInners instanceof Node) {
            return NODE;
        }
        if (fallibleWithInners instanceof Server) {
            return SERVER;
        }
        return CLUSTER;
    }


    public static Node toJavaObjectNode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(NODE), Node.class);
    }

    public static Server toJavaObjectServer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(SERVER), Server.class);
    }

    public static Cluster toJavaObjectCluster() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(CLUSTER), Cluster.class);
    }

}
