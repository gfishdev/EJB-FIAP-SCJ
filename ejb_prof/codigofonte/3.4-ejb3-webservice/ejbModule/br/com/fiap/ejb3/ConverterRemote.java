package br.com.fiap.ejb3;

import javax.ejb.Remote;

@Remote
public interface ConverterRemote {
   
	public float celsiusToFarenheit(float celsius);
    public float farenheitToCelsius(float farenheit);
}
