package testServicos;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RestUtils;

public class ConsultaCEP {
	String url = "http://viacep.com.br/ws/";
	
	@Test
	public void validaStatusCode() {
		//http://viacep.com.br/ws/{{CEP}}/json/
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
				
		RestUtils.setUrl(url);
		
		RestUtils.get();
		assertEquals(200, RestUtils.getStatusCode());
		
	}
	
	@Test
	public void validaDadosCEP() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("client-id", "curso");
		header.put("Authorization", "Basic YWRhbTp0ZXN0ZQ==");
		
		RestUtils.setUrl(url);
		
		RestUtils.get(header);
		
		
		assertEquals(200, RestUtils.getStatusCode());
		assertEquals("Rua Mauro", RestUtils.getValue("logradouro"));
		assertEquals("Saúde", RestUtils.getValue("bairro"));
		assertEquals("São Paulo", RestUtils.getValue("localidade"));
	}
	
	@Test
	public void validaDadosCEPParam() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
		
		LinkedHashMap<String, String> param = new LinkedHashMap<>();
		param.put("client-id", "curso");
		param.put("nome", "Adam");
		
		RestUtils.setUrl(url);
		
		RestUtils.getParams(param);
		
		
		assertEquals(200, RestUtils.getStatusCode());
		assertEquals("Rua Mauro", RestUtils.getValue("logradouro"));
		assertEquals("Saúde", RestUtils.getValue("bairro"));
		assertEquals("São Paulo", RestUtils.getValue("localidade"));
	}
	
	
	
	
	
}
