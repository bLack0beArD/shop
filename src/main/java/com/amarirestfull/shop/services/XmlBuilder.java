package com.amarirestfull.shop.services;
// this class is it's just builder class it's an implemetion of builder desgin pattren
//i used this design pattern to compose and create the String object that reperesent ana xml file 
public class XmlBuilder {
	private String xml ;
    public XmlBuilder() {
    	xml= "<customer id=\"";
    }
	public XmlBuilder buildId(int id) {
		xml += String.valueOf(id)+"\">\n";
		return this;
	}

	public XmlBuilder buildFistName(String firstname) {
		xml += "<first-name>"+firstname+ "</first-name> \n";
		return this;
	}
    public XmlBuilder buildLastName(String lastname) {
    	xml+="<last-name>"+lastname+ "</last-name>\n";
    	return this;
    }
    public XmlBuilder buildStress(String stress) {
    	xml+="<street>"+stress+"</street> \n";
    	return this;
    }
    public XmlBuilder buildCity(String city) {
    	xml+="<city>" +city+"</city> \n";
    	return this;
    }
    public XmlBuilder buildState(String state) {
    	xml+="<state>" + state + "</state> \n";
    	return this;
    }
    public XmlBuilder buildZip(String zip) {
    	xml+="<zip>" + zip + "</zip> \n";
    	return this;
    }
    public XmlBuilder buildCountry(String country ) {
    	xml+="<country>" + country + "</country>\n";
    	return this;
    }
    public String build() {
    	return xml+"</customer>";
    }
}
