package ed.tasks.parsers;

import ed.tasks.parsers.models.Cluster;
import ed.tasks.parsers.models.FallibleWithInners;
import ed.tasks.parsers.models.Node;
import ed.tasks.parsers.models.Server;
import ed.tasks.parsers.utils.JsonParser;
import ed.tasks.parsers.utils.XmlParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 12.08.2019 20:48
 *
 * @author Edward
 */
public class App {


    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------XML--PARSER---------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------");

        XmlParser xmlParser = new XmlParser();
        File fXmlFile = new File("src/main/resources/sampleXml.xml");
        xmlParser.parseXml(fXmlFile);

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------JSON-PARSER---------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------");
        Node firstExampleNode = new Node(1, "first_example");

        Server server1 = new Server(1, "192.0.0.1", App.fillAndGetListOfNodes(8));
        Server server2 = new Server(55, "192.168.0.1", App.fillAndGetListOfNodes(5));
        Server server3 = new Server(11, "192.168.1.10", App.fillAndGetListOfNodes(3));
        Server server4 = new Server(3, "192.168.1.77", App.fillAndGetListOfNodes(12));

        Cluster cluster = new Cluster(Arrays.asList(server1, server2, server3, server4), 105.5d);

        try {
            JsonParser.toJSON(firstExampleNode);
            JsonParser.toJSON(server4);
            JsonParser.toJSON(cluster);

            System.out.println("---------------------------------------------------------------------");
            FallibleWithInners node = JsonParser.toJavaObjectNode();
            FallibleWithInners server = JsonParser.toJavaObjectServer();
            FallibleWithInners cluster1 = JsonParser.toJavaObjectCluster();
            System.out.println("converted from json node:\n" + node);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("converted from json server:\n" + server);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("converted from json cluster:\n" + cluster1);
            System.out.println("---------------------------------------------------------------------");
            JsonParser.editNodeJson();
            System.out.println("old json:\n" + App.readLineByLine("node.json"));
            System.out.println("new json after update:\n" + App.readLineByLine("updatedNode.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<Node> fillAndGetListOfNodes(int capacity) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 1; i < capacity; i++) {
            nodeList.add(new Node(i, i + "_node"));
        }
        return nodeList;
    }

    private static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
