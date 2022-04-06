import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    public String login, username;
    private String password;
    public String sexo, cidade, pais;
    public int idade;
    public Community comunidadeDono = null;
    public ArrayList<String> amigosAdd = new ArrayList<String>();
    public ArrayList<String> amigos = new ArrayList<String>();
    public ArrayList<String> comunidades = new ArrayList<String>();
    public ArrayList<String> minhasComunidades = new ArrayList<String>();
    public ArrayList<Messages> minhasMensagens = new ArrayList<Messages>();
    public ArrayList<String> mensagensFeed = new ArrayList<String>();

    public String getPassword(){
        return this.password;
    }

    public void newAccount(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Login: ");
        login = sc.nextLine();

        System.out.print("Password: ");
        password = sc.nextLine();

        System.out.print("Username: ");
        username = sc.nextLine();
    }

    public void newProfile(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nSexo: ");
        sexo = sc.nextLine();

        System.out.print("Idade: ");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Cidade: ");
        cidade = sc.nextLine();

        System.out.print("País: ");
        pais = sc.nextLine();
    }

    public void editProfile() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSelecione o que você seja mudar:\n1 - Sexo\n2 - Idade\n3 - Cidade\n4 - País\n5 - Todos\n");
		
		int entrada = sc.nextInt();
		sc.nextLine();
		
		switch(entrada) {
		
			case 1:
				System.out.print("Sexo: ");
				sexo = sc.nextLine();
				System.out.println("Alteração feita com sucesso!");
				break;
			
			case 2:
				System.out.print("Idade: ");
				idade = sc.nextInt();
                sc.nextLine();
				System.out.println("Alteração feita com sucesso!");
				break;
				
			case 3:
				System.out.print("Cidade: ");
				cidade = sc.nextLine();
				System.out.println("Alteração feita com sucesso!");
				break;
			
            case 4:
                System.out.print("País: ");
                pais = sc.nextLine();
                System.out.println("Alteração feita com sucesso!");
                break;

			case 5:
				System.out.print("Sexo: ");
				sexo = sc.nextLine();
				
				System.out.print("Idade: ");
				idade = sc.nextInt();
                sc.nextLine();

                System.out.print("Cidade: ");
                cidade = sc.nextLine();
				
				System.out.print("País: ");
				pais = sc.nextLine();
				System.out.println("Alteração feita com sucesso!");
				break;
		
		}
	}

    public void exibirPerfil(){
        System.out.println("\n--------------------------------\n" + username.toUpperCase() + "\n--------------------------------");
		System.out.println("Sexo: " + sexo + "   Idade: " + idade);
        System.out.println("Cidade: " + cidade + "   País: " + pais);

		System.out.println("Lista de amigos: ");
		for(int i = 0; i < amigos.size(); i++) {
			System.out.println("   " + amigos.get(i));
		}

		if(comunidadeDono != null) {
			System.out.println("Minha comunidade: " + comunidadeDono.nomeComunidade + "\n  Descrição: " + comunidadeDono.descricao);

        }

		System.out.println("\nComunidades que estou:");
		for(int i = 0; i < minhasComunidades.size(); i++) {
			System.out.println("   " + minhasComunidades.get(i));
		}
    }

    public void exibirPerfilAlguem(ArrayList<Account> contas){
        Scanner sc = new Scanner(System.in);
        int sucesso = 0;
        System.out.println("Digite o nome de quem deseja ver o perfil");
        String pessoa = sc.nextLine();

        for(int i = 0; i < contas.size(); i++){
            if(pessoa.equals(contas.get(i).username)){
                contas.get(i).exibirPerfil();
                sucesso++;
            }
        }
        if(sucesso == 0){
            System.out.println("\nO usuario digitado não existe!\n");
        }

    }

    public void addFriend(String nome){
        String name = nome;
        amigosAdd.add(name); //ADICIONA NA LISTA DE PEDIDOS
        System.out.println("Pedido de amizade enviado!");
    }

    public void mandarMensagem(ArrayList<Account> contas){
        Scanner sc = new Scanner(System.in);
        int decidir = 0;
        System.out.println("\nPara quem você deseja mandar a mensagem?");
        String pessoa = sc.nextLine();

        for(int i = 0; i < minhasMensagens.size(); i++){
            if(pessoa.equals(minhasMensagens.get(i).remetente)){
                System.out.print("\nDigite sua mensagem: ");  //ENVIAR PARA ALGUEM Q JA ENVIOU ANTES
                String mensagemPEnviar = sc.nextLine();
                minhasMensagens.get(i).mensagens.add(username + ": " + mensagemPEnviar);
                decidir++;
            }
        }
        if(decidir == 0){

            for(int i = 0; i < contas.size(); i++) {
                if(pessoa.equals(contas.get(i).username)) {
                    Messages mensagemAdd = new Messages();
                    mensagemAdd.remetente = username;

                    System.out.print("\nDigite sua mensagem: ");  //ENVIAR PARA ALGUEM Q NUNCA ENVIOU
                    String mensagemPEnviar = sc.nextLine();

                    mensagemAdd.mensagens.add(username + ": " + mensagemPEnviar);
                    contas.get(i).minhasMensagens.add(mensagemAdd);
                    
                }
            }
        }
		System.out.println("\nMensagem Enviada!");
    }

    public void lerMensagens(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da pessoa que deseja ler as mensagens");
        String pessoa = sc.nextLine();  //ESCOLHE O NOME DA PESSOA QUE DESEJA LER
        int leu = 0;

        for(int i = 0; i < minhasMensagens.size(); i++){
            if(pessoa.equals(minhasMensagens.get(i).remetente)){
                minhasMensagens.get(i).printarMensagens();  //IMPRIME TODAS MENSAGENS DA PESSOA DIGITADA
                leu++;
            }
        }

        if(leu == 0){  //NÃO HAVIA MENSAGENS DA PESSOA
            System.out.println("\nO nome digitado está erradou ou vocês ainda não possuem mensagens!");
        }

    }

    public void criarComunidade() {
		Community comunidade = new Community();
		comunidade.criarNovaComunidade(username);

		comunidadeDono = comunidade;
    }
    
    public void adicionarComunidade(ArrayList<Account> contas){
        Scanner sc = new Scanner(System.in);

        if(comunidadeDono != null){
            System.out.println("Digite o usuario que deseja adicionar a sua comunidade: ");
            String pessoa = sc.nextLine();
            int adicionado = 0;
            for(int i = 0; i < contas.size(); i++){
                if(pessoa.equals(contas.get(i).username)){  
                    comunidadeDono.membros.add(pessoa);  //ADICIONA A PESSOA COMO MEMBRO E COLOCA NA COMUNIDADES DELA
                    contas.get(i).minhasComunidades.add(comunidadeDono.nomeComunidade);
                    System.out.println("\nPronto! " + pessoa + " faz parte da sua comunidade agora!\n");
                    adicionado++;
                }
            }
            if(adicionado == 0){
                System.out.println("\nO usuario digitado não existe!\n");
            }
        }
    }

    public void mandarFeed(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite alguma coisa para seu feed:");
        String mensagem = sc.nextLine();

        mensagensFeed.add(mensagem);
    }

    public void printarFeed(){
        if(mensagensFeed.size() > 0){
            System.out.println("\nMensagens no feed:\n");

            for(int i = 0; i < mensagensFeed.size(); i++){
                System.out.println("--> " + mensagensFeed.get(i));
            }
        }
        else System.out.println("\nVocê ainda não possui nenhuma mensagem!!\n");
    }
}
