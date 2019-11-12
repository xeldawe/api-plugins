package com.xel.mnb;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SoapClient {
	
	private static List<MNB> mnbValues = new LinkedList<MNB>();
	final static String OLD_FORMAT = "yyyy-MM-dd";
	final static String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	private static DateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
	
	 // SAAJ - SOAP Client Testing
    public static void main(String args[]) {
        /*
            The example below requests from the Web Service at:
             http://www.webservicex.net/uszip.asmx?op=GetInfoByCity


            To call other WS, change the parameters below, which are:
             - the SOAP Endpoint URL (that is, where the service is responding from)
             - the SOAP Action

            Also change the contents of the method createSoapEnvelope() in this class. It constructs
             the inner part of the SOAP envelope that is actually sent.
         */
        String soapEndpointUrl = "http://www.mnb.hu/arfolyamok.asmx";
        String soapAction = "http://www.mnb.hu/webservices/MNBArfolyamServiceSoap/GetCurrencies";
        String soapAction2 = "http://www.mnb.hu/webservices/MNBArfolyamServiceSoap/GetCurrentExchangeRates";

     //   callSoapWebService(soapEndpointUrl, soapAction);
        callSoapWebService(soapEndpointUrl, soapAction2, mnbValues);
    }

	    private static void callSoapWebService(String soapEndpointUrl, String soapAction, List<MNB> mnbValues) {
	        try {
	            // Create SOAP Connection
	            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	            // Send SOAP Message to SOAP Server
	            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

	            // Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            soapResponse.writeTo(System.out);
	            System.out.println();

	            ByteArrayOutputStream out = new ByteArrayOutputStream();
	            soapResponse.writeTo(out);
	            String strMsg = new String(out.toByteArray());
	            //System.out.print("Response Array is "+Arrays.toString(strarray));
	            if(soapAction.equals("http://www.mnb.hu/webservices/MNBArfolyamServiceSoap/GetCurrencies")) {
		            List<String> output = getFullNameFromXml(strMsg, "GetCurrenciesResult");
		            String[] strarray = new String[output.size()];
		            output.toArray(strarray);
	            String first = strarray[0];
	            first = first.replace("<MNBCurrencies>", "");
	            first = first.replace("</MNBCurrencies>", "");
	            first = first.replace("<Currencies>", "");
	            first = first.replace("</Currencies>", "");
	            first = first.replace("<Curr>", "");
	            first = first.replace("</Curr>", " ");
	            String[] strResult = first.split(" ");
	            for(int i = 0; i < strResult.length; i++) {
	     //       	System.out.println("RESULT["+i+"]: "+strResult[i]);
	            }
	            }else {
		            List<String> output = getFullNameFromXml(strMsg, "GetCurrentExchangeRatesResult");
		            String[] strarray = new String[output.size()];
		    
		            output.toArray(strarray);
		            String first = strarray[0];
		            first = first.replace("<MNBCurrentExchangeRates>", "");
		            first = first.replace("</MNBCurrentExchangeRates>", "");
		            first = first.replace("curr=", "");
		            first = first.replace("unit=", "");
		            first = first.replace("date=", "");
		            first = first.replace("Day", "");
		            first = first.replace("Rate", "");
		            first = first.replace(">", "");
		            first = first.replace("<", "");
		            first = first.replace("/", "");
		            first = first.replace("/", "");
		            first = first.replace("\"", "");
		       //     System.out.println(first);
		            
		            String[] strResult = first.split(" ");
		            MNB mnb = null;

		            Timestamp ts = null;
		            int easyCounter = 0;
		            for(int i = 0; i < strResult.length; i++) {
//		            	System.out.println("RESULT["+i+"]: "+strResult[i]);
		            	if(i == 1){
		            		Date date = formatter.parse(strResult[i]);
		            		((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
		            		String newDateString = formatter.format(date);
		            		ts = Timestamp.valueOf(newDateString);
		            	}
		            	if(i > 1) {
		            		if(easyCounter == 2) {
		            			easyCounter = 0;
		            		}
		            		easyCounter++;
		            		if(easyCounter==1) {
		            			mnb = new MNB();
		            			mnb.setDate(ts);
		            			mnb.setUnit(Integer.valueOf(strResult[i]));
		            		}else {
		            			mnb.setNat(strResult[i].substring(0,3));
		            			String tmp = strResult[i].substring(3).replace(",", ".");
		            			mnb.setValue(Double.valueOf(tmp));
		            			mnbValues.add(mnb);
		            		}
		            	}
		            }
	            }
	            StringBuilder jsonBuilder = new StringBuilder();
	            jsonBuilder.append("[");
	            boolean isFirst = true;
	            for(MNB item:mnbValues) {
	            	if(isFirst) {
	            		isFirst = false;
	            	}else {
	            		jsonBuilder.append(",");
	            	}
	            	  jsonBuilder.append(item.toString());
	            }
	            jsonBuilder.append("]");
	            System.out.println(jsonBuilder.toString());
	            soapConnection.close();
	        } catch (Exception e) {
	            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
	            e.printStackTrace();
	        }
	    }
	    
	    public static Document loadXMLString(String response) throws Exception
	    {
	        DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource(new StringReader(response));

	        return db.parse(is);
	    }
	    
	    public static List<String> getFullNameFromXml(String response, String tagName) throws Exception {
	        Document xmlDoc = loadXMLString(response);
	        NodeList nodeList = xmlDoc.getElementsByTagName(tagName);
	        List<String> ids = new ArrayList<String>(nodeList.getLength());
	        for(int i=0;i<nodeList.getLength(); i++) {
	            Node x = nodeList.item(i);
	            ids.add(x.getFirstChild().getNodeValue());             
	           // System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
	        }
	        return ids;
	    }
	    
	    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

//        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
	    
//	    	  private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//
//        String myNamespace = "myNamespace";
//        String myNamespaceURI = "http://www.webserviceX.NET";
//
//        // SOAP Envelope
//        SOAPEnvelope envelope = soapPart.getEnvelope();
//        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
//
//            /*
//            Constructed SOAP Request Message:
//            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
//                <SOAP-ENV:Header/>
//                <SOAP-ENV:Body>
//                    <myNamespace:GetInfoByCity>
//                        <myNamespace:USCity>New York</myNamespace:USCity>
//                    </myNamespace:GetInfoByCity>
//                </SOAP-ENV:Body>
//            </SOAP-ENV:Envelope>
//            */
//
//        // SOAP Body
//        SOAPBody soapBody = envelope.getBody();
//        SOAPElement soapBodyElem = soapBody.addChildElement("GetInfoByCity", myNamespace);
//        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("USCity", myNamespace);
//        soapBodyElem1.addTextNode("New York");
//    }
}
