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
	
	
}
