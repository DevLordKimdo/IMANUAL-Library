package com.i.manual.xml.parser;

import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class XMLParserService {
	
	public void Upload(MultipartFile file) {
		try {
            InputStream inputStream = file.getInputStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Current Element: " + nNode.getNodeName());
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("    Employee ID: " + eElement.getAttribute("id"));
                    System.out.println("     First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("      Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("         Salary: " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
