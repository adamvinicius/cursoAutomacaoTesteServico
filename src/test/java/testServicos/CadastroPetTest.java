package testServicos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import entities.Category;
import entities.Pet;
import entities.Tag;
import massa.PetMassa;
import utils.RestUtils;

public class CadastroPetTest {
	String url = "https://petstore.swagger.io/v2/";
	String endpoint = "pet";
	@Test
	public void validaStatusCode() {
		RestUtils.setUrl(url);
		RestUtils.setEndpoint(endpoint);
		
		String json = "{\"category\": {\"id\": 0,\"name\": \"teste api\"},    \"name\": \"doggie\",    \"photoUrls\": [        \"string\"    ],    \"tags\": [        {            \"id\": 0,            \"name\": \"string\"        }    ],    \"status\": \"available\"}";
		
		RestUtils.post(json);
		
		assertEquals(200, RestUtils.getStatusCode());
	
	}
	
	@Test
	public void validaErroNomeNull() {
		RestUtils.setUrl(url);
		RestUtils.setEndpoint(endpoint);
				
		Pet pet = PetMassa.geraMassa();
		pet.remove("name");
		RestUtils.post(pet.get());
		assertEquals(405, RestUtils.getStatusCode());
	}
	
	@Test
	public void validaStatusCodeMap() {
		RestUtils.setUrl(url);
		RestUtils.setEndpoint(endpoint);
				
		Pet pet = PetMassa.geraMassa();

		pet.setPet("name", "Ted");
		
		RestUtils.post(pet.get());
		assertEquals(200, RestUtils.getStatusCode());
		
		assertEquals("teste api", RestUtils.getValue("category.name"));
		assertEquals("doggie", RestUtils.getValue("name"));
		assertEquals("tag", RestUtils.getValue("tags[0].name"));
		
			
		assertNotEquals("", RestUtils.getValue("id"));
		assertNotEquals(null, RestUtils.getValue("id"));
	}
}
