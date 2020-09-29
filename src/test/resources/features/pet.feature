#language:pt

@pet
Funcionalidade: Cadastro de PET
  Realizar Testes no cadastro de pet

  @StatusPet
  Cenario: Valido status code
    Dado que tenho um payload valido do pet
    Quando realizo uma requisicao de post do pet
    Entao valido o status code 200
    
	@ValidacaoPet
  Cenario: valido campos
    Dado que tenho um payload valido do pet
    Quando realizo uma requisicao de post do pet
    Entao valido o campo "name" com o valor "doggie"
    E valido o campo "category.name" com o valor "teste api"
    E guardo o valor do id do pet gerado
 
