package br.com.fiap.ejb3;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Stateless
@WebService(name="converter")
public class Converter implements ConverterRemote {

	public float celsiusToFarenheit(@WebParam(name="celsius") float celsius) {
		return (celsius * 9 / 5) + 32;
	}
	
	@WebMethod(exclude=true)
	public float farenheitToCelsius(@WebParam(name="farenheit") float farenheit) {
		return (farenheit - 32) * 5 / 9;
	}
}
