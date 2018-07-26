package app.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CardValidatorIT {
	
	public static void main(String[] args) throws MalformedURLException {
		Endpoint endpoint = Endpoint.publish("http://localhost:8180/cardValidator", new CardValidator());
		System.out.println("IS PUBLISHED? " + endpoint.isPublished());
		System.out.println("EQUALS? " + endpoint.getBinding().getBindingID().equals("http://schemas.xmlsoap.org/wsdl/soap/http"));
		
		URL wsdlLocation = new URL("http://localhost:8180/cardValidator?wsdl");
		String namespaceURI = "http://soap.app/";
		String servicePart = "CardValidatorService";
		String portName = "CardValidatorPort";
		QName serviceQN = new QName(namespaceURI, servicePart);
		QName portQN = new QName(namespaceURI, portName);
		
		Service service = Service.create(wsdlLocation, serviceQN);
		Validator cardValidator = service.getPort(portQN, Validator.class);
		
		CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
		System.out.println("IS VALID? " + cardValidator.validate(creditCard));
		
		creditCard.setNumber("12341233");
		System.out.println("IS VALID? " + cardValidator.validate(creditCard));
		
		//endpoint.stop();
		//System.out.println("IS PUBLISHED? " + endpoint.isPublished());
	}
}