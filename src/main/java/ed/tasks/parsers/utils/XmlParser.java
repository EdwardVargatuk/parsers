package ed.tasks.parsers.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 12.08.2019 20:48
 *
 * @author Edward
 */
public class XmlParser {

    public void parseXml(File file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nCredit = doc.getDocumentElement().getElementsByTagName("credit");
            String credit = nCredit.item(0).getTextContent();

            NodeList nListlocations = doc.getElementsByTagName("location");
            NodeList nListMeta = doc.getElementsByTagName("meta");
            NodeList nListTime = doc.getElementsByTagName("time");


            for (int temp = 0; temp < nListlocations.getLength(); temp++) {
                Node nNode = nListlocations.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE & nNode.hasChildNodes()) {
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    Element eElement = (Element) nNode;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String type = eElement.getElementsByTagName("type").item(0).getTextContent();
                    String country = eElement.getElementsByTagName("country").item(0).getTextContent();
                    String timezone = eElement.getElementsByTagName("timezone").item(0).getTextContent();
                    double latitude = Double.parseDouble(eElement.getElementsByTagName("location").item(0).getAttributes().getNamedItem("latitude").getNodeValue());
                    int altitude = Integer.parseInt((eElement.getElementsByTagName("location").item(0).getAttributes().getNamedItem("altitude").getNodeValue()));
                    double longitude = Double.parseDouble(eElement.getElementsByTagName("location").item(0).getAttributes().getNamedItem("longitude").getNodeValue());
                    String geobase = (eElement.getElementsByTagName("location").item(0).getAttributes().getNamedItem("geobase").getNodeValue());
                    Long geobaseid = Long.valueOf((eElement.getElementsByTagName("location").item(0).getAttributes().getNamedItem("geobaseid").getNodeValue()));
                    System.out.println("name " + name + ", type " + type + ", country " + country + ", timezone " + timezone +
                            "\nlocation: altitude " + altitude + ", latitude " + latitude + ", longitude " + longitude + ", geobase " + geobase + ", geobaseid " + geobaseid);
                }
            }


            for (int temp = 0; temp < nListMeta.getLength(); temp++) {
                Node nNode2 = nListMeta.item(temp);
                if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("\nCurrent Element :" + nNode2.getNodeName());
                    Element eElement = (Element) nNode2;

                    String lastupdate = eElement.getElementsByTagName("lastupdate").item(0).getTextContent();
                    String calctime = (eElement.getElementsByTagName("calctime").item(0).getTextContent());
                    String nextupdate = eElement.getElementsByTagName("nextupdate").item(0).getTextContent();

                    System.out.println("lastupdate " + lastupdate + ", calctime " + calctime + ", nextupdate " + nextupdate);
                }
            }


            String rise = doc.getDocumentElement().getElementsByTagName("sun").item(0).getAttributes().getNamedItem("rise").getNodeValue();
            String set = doc.getDocumentElement().getElementsByTagName("sun").item(0).getAttributes().getNamedItem("set").getNodeValue();
            System.out.println("sun: rise = " + rise + ", set = " + set);
            System.out.print("\nforecast:");

            for (int temp = 0; temp < nListTime.getLength(); temp++) {
                Node nNode = nListTime.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE & nNode.hasChildNodes()) {
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    Element eElement = (Element) nNode;
                    String day = eElement.getAttribute("day");

                    int numberSymbol = Integer.parseInt(eElement.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("number").getNodeValue());
                    String nameSymbol = (eElement.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("name").getNodeValue());
                    String var = (eElement.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("var").getNodeValue());

                    double valuePrecipitation = Double.parseDouble((eElement.getElementsByTagName("precipitation").item(0).getAttributes().getNamedItem("value").getNodeValue()));
                    String typePrecipitation = (eElement.getElementsByTagName("precipitation").item(0).getAttributes().getNamedItem("type").getNodeValue());

                    int degWindDirection = Integer.parseInt(eElement.getElementsByTagName("windDirection").item(0).getAttributes().getNamedItem("deg").getNodeValue());
                    String codeWindDirection = (eElement.getElementsByTagName("windDirection").item(0).getAttributes().getNamedItem("code").getNodeValue());
                    String nameWindDirection = (eElement.getElementsByTagName("windDirection").item(0).getAttributes().getNamedItem("name").getNodeValue());

                    double mpsWindSpeed = Double.parseDouble((eElement.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("mps").getNodeValue()));
                    String nameWindSpeed = (eElement.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("name").getNodeValue());

                    double dayTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("day").getNodeValue()));
                    double minTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("min").getNodeValue()));
                    double maxTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("max").getNodeValue()));
                    double nightTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("night").getNodeValue()));
                    double eveTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("eve").getNodeValue()));
                    double mornTemperature = Double.parseDouble((eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("morn").getNodeValue()));


                    String unitPressure = (eElement.getElementsByTagName("pressure").item(0).getAttributes().getNamedItem("unit").getNodeValue());
                    double valuePressure = Double.parseDouble((eElement.getElementsByTagName("pressure").item(0).getAttributes().getNamedItem("value").getNodeValue()));

                    int valueHumidity = Integer.parseInt((eElement.getElementsByTagName("humidity").item(0).getAttributes().getNamedItem("value").getNodeValue()));
                    String unitHumidity = (eElement.getElementsByTagName("humidity").item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    String valueClouds = (eElement.getElementsByTagName("clouds").item(0).getAttributes().getNamedItem("value").getNodeValue());
                    short allClouds = Short.parseShort((eElement.getElementsByTagName("clouds").item(0).getAttributes().getNamedItem("all").getNodeValue()));
                    String unitClouds = (eElement.getElementsByTagName("clouds").item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println("day = " + day +
                            "\nsymbol: number " + numberSymbol + ", name " + nameSymbol + ", var " + var +
                            "\nprecipitation: value " + valuePrecipitation + ", type " + typePrecipitation +
                            "\nwindDirection: deg " + degWindDirection + ", code " + codeWindDirection + ", name " + nameWindDirection +
                            "\nwindSpeed: mps " + mpsWindSpeed + ", name " + nameWindSpeed +
                            "\ntemperature: day " + dayTemperature + ", min " + minTemperature + ", max " + maxTemperature + ", night " + nightTemperature + ", eve " + eveTemperature + ", morn " + mornTemperature +
                            "\npressure: unit " + unitPressure + ", value " + valuePressure +
                            "\nhumidity: value " + valueHumidity + ", unit " + unitHumidity +
                            "\nclouds: value " + valueClouds + ", all " + allClouds + ", unit " + unitClouds);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("WARN during reading file");
            e.printStackTrace();
        }
    }


}
