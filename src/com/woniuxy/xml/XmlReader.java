package com.woniuxy.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReader {
	
	public static void read() throws FileNotFoundException, DocumentException{
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new FileInputStream(new File("src/com/woniuxy/xml/database1.xml")));
		Element root=doc.getRootElement();
		List<Element> list=root.elements("propertity");
		
		String driverClass=list.get(0).attributeValue("driverClass");		
		System.out.println(driverClass);
		String jdbcurl=list.get(1).attributeValue("jdbcurl");		
		System.out.println(jdbcurl);
		String userName=list.get(2).attributeValue("userName");		
		System.out.println(userName);
		String password=list.get(3).attributeValue("password");		
		System.out.println(password);

	}
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		read();
	}
}
