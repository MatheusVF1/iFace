import java.util.ArrayList;
import java.util.Scanner;

public class iFace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Account> contas = new ArrayList<Account>();
        int entrada = -11;

        System.out.println("Seja bem vindo ao iFace");
        System.out.println("Escolha o que deseja fazer:");
        System.out.println("0 - Sair do programa\n1 - Criar uma conta\n2 - Entrar na conta\n");

        while (entrada != 0){
            entrada = sc.nextInt();
            sc.nextLine();

            switch(entrada){
                case 0:
                    System.out.println("Encerrando o programa."); //FECHAR O PROGRAMA
                    break;

                case 1:
                    Account conta = new Account();

                    conta.newAccount(); //CRIAR A CONTA NOVA
                    conta.newProfile(); //CRIAR O PERFIL
                    contas.add(conta);

                    System.out.println("\nConta criada com sucesso!\n");
                    System.out.print("O que deseja fazer agora? ");
                    break;
                    
                case 2:
                    System.out.print("Digite seu login: "); //ENTRAR NA CONTA
                    String login = sc.nextLine();
                    String password = null;
                    int id = 0, existe = 0;

                    for(int i = 0; i < contas.size(); i++){     //VERIFICANDO SE O LOGIN EXISTE
                        if(login.equals(contas.get(i).login)){
                            id = i;
                            System.out.print("Password: ");
                            password = sc.nextLine();
                            existe++;
                            break;
                        };
                    }

                    if(existe == 0){
                        System.out.println("Login não encontrado! Tente novamente.\n");
                    }
                    else if(password.equals(contas.get(id).getPassword())){  //VERIFICANDO SE A SENHA CONFERE COM O LOGIN
                        System.out.println("\nSeja bem vindo a sua conta no iFace, " + contas.get(id).username + "!\n");
                        System.out.println("Escolha o que deseja fazer:"); //MENU DE OPÇÕES DO USUARIO ABAIXO
                        System.out.println("0 - Sair da Conta\n1 - Editar meu perfil\n2 - Exibir meu perfil\n3 - Adicionar um amigo\n4 - Pedidos de amizade\n5 - Exibir lista de amigos\n6 - Enviar uma mensagem\n7 - Ler minhas mensagens\n8 - Criar uma comunidade\n9 - Adicionar membros\n10 - Exibir o perfil de algum usuário\n11 - Exibir alguma comunidade\n12 - Mandar mensagens para o Feed\n13 - Ver meu Feed\n14 - Controlar visualizações no Feed\n15 - Exibir o Feed de algum usuario\n16 - Apagar sua conta");
                        
                        int entrada2 = -11;

                        while(entrada2 != 0){

                            entrada2 = sc.nextInt();
                            sc.nextLine();

                            switch(entrada2){
                                case 0:
                                    System.out.println("Saindo da conta!"); //SAI DA CONTA
                                    break;
                                case 1:
                                    contas.get(id).editProfile();  //EDITAR O PERFIL
                                    break;

                                case 2:
                                    contas.get(id).exibirPerfil();  //EXIBIR O PERFIL
                                    break;

                                case 3:
                                    int existe1 = 0;

                                    System.out.println("\nDigite o nome do usuario de quem deseja adicionar.");
                                    String nomeAmigo = sc.nextLine();

                                    for(int i = 0; i < contas.size(); i++){
                                        if(nomeAmigo.equals(contas.get(i).username)){     //PROCURANDO SE O NOME DO USUARIO EXISTE
                                            contas.get(i).addFriend(contas.get(id).username);  //ADICIONANDO SEU NOME A LISTA DE PEDIDOS DO USUARIO SOLICITADO
                                            contas.get(i).mensagensFeed.add(contas.get(id).username + " te enviou uma solicitação de amizade"); //ADICIONA NO FEED DO AMIGO QUE ENVIOU SOLICITAÇÃO
                                            existe1++;
                                        }
                                    }
                                    if(existe1 == 0){
                                        System.out.println("Nome de usuario não encontrado!");
                                    }
                                    break;

                                case 4:
                                    System.out.println("Lista de solicitações de amizade");
                                    System.out.println("Digite 1 para aceitar e 0 para recusar\n");

                                    if(contas.get(id).amigosAdd.size() > 0){
                                        for(int i = 0; i < contas.get(id).amigosAdd.size(); i++){ //EXIBIR OS PEDIDOS DE AMIZADE
                                            System.out.println(contas.get(id).amigosAdd.get(i) + " deseja te adicionar!");
                                            System.out.print("Você aceita? ");

                                            int aceita = sc.nextInt();
                                            sc.nextLine();

                                            if (aceita == 0){
                                                contas.get(id).amigosAdd.remove(i);
                                                System.out.println("\nPedido recusado!\n"); //REMOVE DA LISTA DE PEDIDOS
                                            }
                                            else if(aceita == 1){
                                                contas.get(id).amigos.add(contas.get(id).amigosAdd.get(i)); //ADICIONANDO NA SUA LISTA DE AMIGOS

                                                for(int k = 0; k < contas.size(); k++){
                                                    if(contas.get(id).amigosAdd.get(i).equals(contas.get(k).username)){
                                                        contas.get(k).amigos.add(contas.get(id).username);  //ADICIONANDO NA LISTA DE AMIGOS DO USUARIO
                                                        contas.get(k).mensagensFeed.add(contas.get(id).username + " aceitou seu pedido de amizade!");
                                                        System.out.println("\nAgora você e " + contas.get(k).username + " são amigos!");
                                                    }
                                                }
                                                contas.get(id).amigosAdd.remove(i);
                                            }
                                        }
                                    }
                                    else System.out.println("\nVocê não possui pedidos de amizade!\n");
                                    break;

                                case 5:
                                    if(contas.get(id).amigos.size() > 0){
                                        System.out.println("Seus amigos: ");
                                        for(int i = 0; i < contas.get(id).amigos.size(); i++){
                                            System.out.println("   " + contas.get(id).amigos.get(i));
                                        }
                                    }
                                    else{
                                        System.out.println("\nVocê ainda não possui nenhum amigo!\n");
                                    }
                                    break;
                                case 6:
                                    contas.get(id).mandarMensagem(contas);  //ENVIAR MENSAGEM PARA ALGUEM
                                    break;

                                case 7:
                                    contas.get(id).lerMensagens();  //LER AS MINHAS MENSAGENS
                                    break;

                                case 8:
                                    contas.get(id).criarComunidade();  //CRIAR MINHA COMUNIDADE
                                    break;

                                case 9:
                                    contas.get(id).adicionarComunidade(contas);
                                    break;

                                case 10:
                                    contas.get(id).exibirPerfilAlguem(contas);
                                    break;

                                case 11:
                                    System.out.println("\nDigite o nome da comunidade que deseja ver:");
                                    String comuni = sc.nextLine();
                                    int exibido = 0;

                                    for(int i = 0; i < contas.size(); i++){
                                        if(contas.get(i).comunidadeDono != null && comuni.equals(contas.get(i).comunidadeDono.nomeComunidade)){
                                            contas.get(i).comunidadeDono.mostrarComunidade();
                                            exibido++;
                                        }
                                    }
                                    if(exibido == 0){
                                        System.out.println("\nA comunidade digitada não existe!");
                                    }
                                    break;

                                case 12:
                                    contas.get(id).mandarFeed();
                                    break;

                                case 13:
                                    contas.get(id).printarFeed();
                                    break;

                                case 14:
                                    contas.get(id).controlarFeed();
                                    break;
                                case 15:
                                    contas.get(id).exibirFeedAlguem(contas, contas.get(id).username);
                                    break;
                                case 16:
                                    System.out.println("\nTem certeza que deseja excluir sua conta?\nDigite 1 para confirmar e 0 para cancelar.");
                                    int excluir = sc.nextInt();
                                    sc.nextLine();
                                    
                                    if(excluir == 1){
                                        for(int i = 0; i < contas.size(); i++) {
                                            for(int j = 0; j < contas.get(i).amigos.size(); j++) {
                                                if(contas.get(id).username.equals(contas.get(i).amigos.get(j))) { //remove da lisat de amizade
                                                    contas.get(i).amigos.remove(j);
                                                }
                                            }
                                        }

                                        for(int i = 0; i < contas.size(); i++) {
                                            for(int j = 0; j < contas.get(i).amigosAdd.size(); j++) {
                                                if(contas.get(id).username.equals(contas.get(i).amigosAdd.get(j))) {  //remove da lista de pedidos de amizade
                                                    contas.get(i).amigosAdd.remove(j);
                                                }
                                            }
                                        }
                                        
                                        for(int i = 0; i < contas.size(); i++) {
                                            for(int j = 0; j < contas.get(i).minhasMensagens.size(); j++) {
                                                if(contas.get(id).username.equals(contas.get(i).minhasMensagens.get(j).remetente)) { //remove da lista de mensagens
                                                    contas.get(i).minhasMensagens.remove(j);
                                                }
                                            }
                                        }
                                        
                                        for(int i = 0; i < contas.size(); i++) {
                                            if(contas.get(i).comunidadeDono != null) {
                                                for(int j = 0; j < contas.get(i).comunidadeDono.membros.size(); j++) {
                                                    if(contas.get(id).username.equals(contas.get(i).comunidadeDono.membros.get(j))) { //remove do membro de outras comunidades
                                                        contas.get(i).comunidadeDono.membros.remove(j);
                                                    }
                                                }
                                            }
                                        }
                                        
                                        if(contas.get(id).comunidadeDono != null){
                                            for(int i = 0; i < contas.size(); i++){
                                                for(int j = 0; j < contas.get(i).minhasComunidades.size(); j++){
                                                    if(contas.get(id).comunidadeDono.nomeComunidade.equals(contas.get(i).minhasComunidades.get(j))){
                                                        contas.get(i).minhasComunidades.remove(j);
                                                    }
                                                }
                                            }
                                        }
    
                                        contas.remove(id);
                                        System.out.println("\nConta excluida com sucesso!\n");
                                        entrada2 = 0;
                                    }
                                    break;

                            }
                            if(entrada2 != 0){
                            System.out.println("\nEscolha o que deseja fazer:");
                            System.out.println("0 - Sair da Conta\n1 - Editar meu perfil\n2 - Exibir meu perfil\n3 - Adicionar um amigo\n4 - Pedidos de amizade\n5 - Exibir lista de amigos\n6 - Enviar uma mensagem\n7 - Ler minhas mensagens\n8 - Criar uma comunidade\n9 - Adicionar membros\n10 - Exibir o perfil de algum usuário\n11 - Exibir alguma comunidade\n12 - Mandar mensagens para o Feed\n13 - Ver meu Feed\n14 - Controlar visualizações no Feed\n15 - Apagar sua conta");
                        }
                    }
                }
                break;
                    
                default:
                    System.out.println("\nNúmero invalido digitado!!\n");
                    break;
            }

            if(entrada != 0){
            System.out.println("\nEscolha o que deseja fazer:");
            System.out.println("0 - Sair do programa\n1 - Criar uma conta\n2 - Entrar na conta\n");
            }
        }

        sc.close();
    }
}
