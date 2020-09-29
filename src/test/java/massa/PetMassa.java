package massa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import entities.Category;
import entities.Pet;
import entities.Tag;

public class PetMassa {
	public static Category category = new Category(0, "teste api");
	public static List<Object> listPhoto = new ArrayList<Object>();
	public static Tag tag = new Tag(0, "tag");
	public static List<LinkedHashMap<String, Object>> tags = new ArrayList<LinkedHashMap<String,Object>>();
	public static Pet pet = new Pet(category, "doggie", listPhoto, tags, "available");
	public static String url = "https://petstore.swagger.io/v2/";
	public static String endpoint = "pet";
	public static String id;
	
	public static Pet geraMassa() {
		listPhoto.add("string");
		tags.add(tag.get());
		return pet;
	}
	
}
