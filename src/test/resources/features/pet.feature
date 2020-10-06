#language:pt
@pet
Funcionalidade: Cadastro de PET
  Realizar Testes no cadastro de pet

	Contexto:
		Dado que tenho um payload valido do pet

  @StatusPet
  Cenario: Valido status code
    Quando realizo uma requisicao de post do pet
    Entao valido o status code 200

  @ValidacaoPet
  Cenario: valido campos
    Quando realizo uma requisicao de post do pet
    Entao valido o campo "name" com o valor "doggie"
    E valido o campo "category.name" com o valor "teste api"
    E guardo o valor do id do pet gerado

  @EsquemaCenario
  Esquema do Cenario: <Cenario>
    Quando altero o valor do nome do pet para "<pet>"
    Quando realizo uma requisicao de post do pet
    Entao valido o campo "name" com o valor "<pet>"
  

    Exemplos: 
      | Cenario              | pet    |
      | Cadastro Pets Ted    | Ted    |
      | Cadastro Pets Ruby   | Ruby   |
      | Cadastro Pets Pipoca | Pipoca |
  
  
  
  @CrudPet
  Cenario: Crud Pet
    Quando altero o valor do nome do pet para "Ted"
    E realizo uma requisicao de post do pet
    Entao guardo o valor do id do pet gerado
    Quando realizo uma requisicao de get do pet utilizando o id
    Entao valido o campo "name" com o valor "Ted"
    Quando altero o valor do nome do pet para "Pipoca"
    E altero o valor do id do pet para o armazenado
    E realizo uma requisicao de put do pet
    Quando realizo uma requisicao de get do pet utilizando o id
    Entao valido o campo "name" com o valor "Pipoca"
   
  @CrudPet2
  Cenario: Crud Pet2
  	Quando realizo uma requisicao do post do pet "Ted" e guardo o id
  	Entao realizo uma requisicao de get utilizando o id e valido o nome "Ted"
    Quando realizo uma requisicao do put do pet "Pipoca" com o id
    Entao realizo uma requisicao de get utilizando o id e valido o nome "Pipoca"
    
    
    