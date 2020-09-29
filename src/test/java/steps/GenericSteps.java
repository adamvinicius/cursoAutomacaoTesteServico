package steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.pt.Entao;
import utils.RestUtils;

public class GenericSteps {

	@Entao("valido o status code {int}")
	public void validoOStatusCode(int statusCode) {
	    assertEquals(statusCode, RestUtils.getStatusCode());
	}
	
	@Entao("valido o campo {string} com o valor {string}")
	public void validoOCampoComOValor(String key, String value) {
	    assertEquals(value, RestUtils.getValue(key));
	}
}
