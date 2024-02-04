package com.amarirestfull.shop.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.amarirestfull.shop.domain.Customer;

import jakarta.ws.rs.WebApplicationException;

public class OperationsCustomer {
	
	
	public static  Customer readCustomer(InputStream is) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();
			Customer cust = new Customer();
			if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals("")) {
				cust.setId(Integer.valueOf(root.getAttribute("id")));
			}
			NodeList nodes = root.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {

				Element element = (Element) nodes.item(i);
				switch (element.getTagName()) {
				case ("first-name"):
					cust.setFirstName(element.getTextContent());
				case ("last-name"):
					cust.setLastName(element.getTextContent());
				case ("street"):
					cust.setStreet(element.getTextContent());
				case ("city"):
					cust.setCity(element.getTextContent());
				case ("state"):
					cust.setState(element.getTextContent());
				case ("zip"):
					cust.setZip(element.getTextContent());
				case ("country"):
					cust.setCountry(element.getTextContent());

				}
			}
			return cust;
		} catch (Exception e) {
			throw new WebApplicationException(e, 400);
		}

	}
	public static void outputCustomer(OutputStream os, Customer cust) throws IOException

	{
	
		PrintStream writer = new PrintStream(os);
		String xml =new XmlBuilder()
				.buildId(cust.getId())
				.buildFistName(cust.getFirstName())
				.buildLastName(cust.getLastName())
				.buildStress(cust.getStreet())
				.buildCity(cust.getCity())
				.buildState(cust.getState())
				.buildZip(cust.getZip())
				.buildCountry(cust.getCountry())
				.build();

		writer.println(xml);
		

	}
}
