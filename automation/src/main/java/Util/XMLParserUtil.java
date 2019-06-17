package Util;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mufleh on 17/06/2019.
 */
public class XMLParserUtil {

    public static NodeList getXMLElementAsNode(Document xmlDoc, String expression) throws XPathExpressionException {
        final XPath xPath = XPathFactory.newInstance().newXPath();
        return (NodeList) xPath.compile(expression).evaluate(xmlDoc, XPathConstants.NODESET);
    }

    public static Document documentBuilder(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(filePath);
        return document;
    }

    public static String convertXMLDocToString(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
        return stringWriter.getBuffer().toString();
    }

    public static void updateChildNodes(NodeList nodes){
        for (int i = 0; i < nodes.getLength(); i++) {
            String uniqueValue = RandomStringUtils.randomAlphabetic(10);
            Node node = nodes.item(i);
            if (node.hasChildNodes()){
                String value = node.getFirstChild().getNodeValue();
                node.getFirstChild().setNodeValue(value+uniqueValue);
            }
        }
    }

    public static String updateXmlFile(String filePath, Map<String, String> elementsMap) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerException {
        Document document = documentBuilder(filePath);
        Set<String> elements = elementsMap.keySet();
        NodeList nodeList;
        NodeList make;

        // accessing parent nodes
        for (String element : elements) {
            nodeList = getXMLElementAsNode(document,element);
            Node header = null;
            header = nodeList.item(0);
            header.setTextContent(elementsMap.get(element));
        }
        // accessing child nodes
        make = document.getElementsByTagName("Registration");
        updateChildNodes(make);

        return convertXMLDocToString(document);
    }

    @Test
    public void test() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException, TransformerException {
        Map<String, String> elementMap = new HashMap<>();
        elementMap.put("/Person/Header/Name","Jon");
        String test = updateXmlFile("src/test/resources/test1.xml", elementMap);
        System.out.println(test);
    }
}
