package steps;

import static org.junit.Assert.assertEquals;

import entities.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import massa.PetMassa;
import utils.RestUtils;

public class PetSteps {
	String url;
	String endpoint;
	Pet pet;
	
	@Dado("que tenho um payload valido do pet")
	public void queTenhoUmPayloadValidoDoPet() {
	    url = PetMassa.url;
	    endpoint = PetMassa.endpoint;
	    pet = PetMassa.geraMassa();
	    RestUtils.setUrl(url);
	    RestUtils.setEndpoint(endpoint);
	}

	@Quando("realizo uma requisicao de post do pet")
	public void realizoUmaRequisicaoDePostDoPet() {
	    RestUtils.post(pet.get());
	}
	
	
	
	@Entao("guardo o valor do id do pet gerado")
	public void guardoOValorDoIdDoPetGerado() {
	    PetMassa.id = RestUtils.getValue("id").toString();
	}
	
	@Quando("altero o valor do nome do pet para {string}")
	public void alteroOValorDoNomeDoPetPara(String name) {
	    pet.setPet("name", name);
	}
	
	@Quando("realizo uma requisicao de get do pet utilizando o id")
	public void realizoUmaRequisicaoDeGetDoPetUtilizandoOId() {
	    String id = PetMassa.id;
	    RestUtils.setEndpoint(endpoint+"/"+id);
	    RestUtils.get();
	}

	@Quando("altero o valor do id do pet para o armazenado")
	public void alteroOValorDoIdDoPetParaOArmazenado() {
	    String id = PetMassa.id;
	    pet.setPet("id", id);
	}
	@Quando("realizo uma requisicao de put do pet")
	public void realizoUmaRequisicaoDePutDoPet() {
		RestUtils.setEndpoint(endpoint);
	    RestUtils.put(pet.get());
	}
	
	@Quando("realizo uma requisicao do post do pet {string} e guardo o id")
	public void realizoUmaRequisicaoDoPostDoPetEGuardoOId(String name) {
		pet.setPet("name", name);
		RestUtils.post(pet.get());
		PetMassa.id = RestUtils.getValue("id").toString();
	}



	@Entao("realizo uma requisicao de get utilizando o id e valido o nome {string}")
	public void realizoUmaRequisicaoDeGetUtilizandoOIdEValidoONome(String name) {
		String id = PetMassa.id;
	    RestUtils.setEndpoint(endpoint+"/"+id);
	    RestUtils.get();
	    assertEquals(name, RestUtils.getValue("name"));
	    
	}
	@Quando("realizo uma requisicao do put do pet {string} com o id")
	public void realizoUmaRequisicaoDoPutDoPetComOId(String name) {
		pet.setPet("name", name);
		String id = PetMassa.id;
	    pet.setPet("id", id);
	    RestUtils.setEndpoint(endpoint);
	    RestUtils.put(pet.get());
		
	}
	
	
}
