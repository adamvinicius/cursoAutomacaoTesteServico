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
	public void validaStatusCodeMap() {
		RestUtils.setUrl(url);
		RestUtils.setEndpoint(endpoint);
				
		Category category = new Category(0, "teste api");
		List<Object> listPhoto = new ArrayList<Object>();
		listPhoto.add("string");
		Tag tag = new Tag(0, "tag");
		List<LinkedHashMap<String, Object>> tags = new ArrayList<LinkedHashMap<String,Object>>();
		tags.add(tag.get());
		Pet pet = new Pet(category, "doggie", listPhoto, tags, "available");
		
		
		RestUtils.post(pet.get());
		assertEquals(200, RestUtils.getStatusCode());
		
		assertEquals("teste api", RestUtils.getValue("category.name"));
		assertEquals("doggie", RestUtils.getValue("name"));
		assertEquals("tag", RestUtils.getValue("tags[0].name"));
		
			
		assertNotEquals("", RestUtils.getValue("id"));
		assertNotEquals(null, RestUtils.getValue("id"));
	}
}
