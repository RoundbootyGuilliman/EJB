package app.soap;

import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface = "app.soap.Validator")
public class CardValidator implements Validator {
	
	@Override
	@WebResult(name = "isValid")
	public boolean validate(CreditCard creditCard) {
		Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
		return Integer.parseInt(lastDigit.toString()) % 2 == 0;
	}
	
	@Override
	@WebResult(name = "card")
	public CreditCard getCard() {
		return new CreditCard("12341234", "10/10", 1234, "VISA");
	}
}