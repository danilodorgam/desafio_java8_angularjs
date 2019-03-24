## Desafio
Desafio Java


Descrição

Antes de manipular os dados do cliente é necessário realizar a autenticação do usuário. Não se preocupe nesse momento em criar novas contas para o serviço.

Um usuário poderá se autenticar no sistema com duas contas diferentes:

    1- Usuário admin 
Senha 123456
Esse usuário possui permissão total no sistema.

    2- Usuário comum
Senha 123456
Esse usuário só tem permissão de visualização dos dados.

Um registro de um cliente deverá ter os seguintes campos com suas respectivas regras:

Nome:
	* Mínimo de 3 caracteres;
	* Máximo de 100 caracteres;
	* Campo obrigatório;
	* Permite apenas letras, espaços e números.
CPF:
	* Sempre deve ser mostrado com máscara;
	* Deve ser persistido na base sem máscara;
	* É um campo obrigatório.
		
Endereço:
	* Obrigatório preenchimento de CEP, logradouro, bairro, cidade e uf;
	* Opcional complemento;
	* Outros dados não devem ser preenchidos;
	* Deve estar integrado com um serviço de consulta de CEP. Sugestão: https://viacep.com.br/
	* O usuário pode alterar os dados que vieram do serviço de consulta de CEP;
	* O CEP deve ser mostrado com máscara;
	* O CEP deve ser persistido sem máscara.
	
Telefones:
	* Podem ser cadastrados múltiplos telefones;
	* Pelo menos um telefone deve ser cadastrado;
	* No cadastro de telefone, deve ser informado o tipo de telefone (residencial, comercial e celular) e o número;
	* A máscara de telefone deve ser de acordo com o tipo de telefone (celular possui um digito a mais);
	* o telefone deve ser mostrado com máscara;
	* o telefone deve ser persistido sem máscara.

E-mail:	
	* Podem ser cadastrados múltiplos e-mails;
	* Pelo menos um e-mail deve ser cadastrado;
	* Deve ser um e-mail válido.

    • O sistema deverá ser divido em dois projetos, um projeto para o front e outro para o serviço.
    • O projeto de serviços deverá ser desenvolvido com as seguintes tecnologias:
	* Java 8
	* Spring / Springboot
	* Hibernate
	* Maven
	* Você pode adicionar tecnologias a mais se achar necessário
