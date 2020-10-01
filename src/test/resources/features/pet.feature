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
