package com.eop.api.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author Ravi K
 *
 */
public class JaxbUtil {
	public static <T> T convertToJaxb(Class<?> jaxbClass, String xmlString) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(jaxbClass);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		InputStream is = new ByteArrayInputStream(xmlString.getBytes());
		Reader reader = null;
		try{
			reader = new InputStreamReader(is);	    
			return (T) unmarshaller.unmarshal(reader);
		}finally{
			try {
				if(reader!=null){
					reader.close();
				}
				if(is!=null){
					is.close();
				}
			}catch(IOException e){
			}
		}
	}
	public static String convertToXmlString(Class jaxbClass, Object jaxbObj) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(jaxbClass);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		marshaller.marshal(jaxbObj, out);
		return out.toString();
	}
}
