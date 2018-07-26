package app.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {
	
	@XmlAttribute(required = true)
	private String number;
	
	@XmlAttribute(required = true, name = "expiration_date")
	private String expirationDate;
	
	@XmlAttribute(required = true, name = "control_number")
	private Integer controlNumber;
	
	@XmlAttribute(required = true)
	private String type;
	
	public CreditCard() {
	}
	
	public CreditCard(String number, String expirationDate, Integer controlNumber, String type) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.controlNumber = controlNumber;
		this.type = type;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Integer getControlNumber() {
		return controlNumber;
	}
	
	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
