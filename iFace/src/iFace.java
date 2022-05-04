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
                        if(login.equals(contas.get(i).getLogin())){
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
                        System.out.println("\nSeja bem vindo a sua conta no iFace, " + contas.get(id).getUsername() + "!\n");
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
                                    contas.get(id).adicionarAmigo(contas); //ENVIAR PEDIDO DE AMIZADE
                                    break;

                                case 4:
                                    contas.get(id).pedidosAmizade(contas); //VER PEDIDOS DE AMIZADE E ACEITAR
                                    break;

                                case 5:
                                    contas.get(id).printarAmigos();  //MOSTRAR LISTA DE AMIGOS
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
                                    contas.get(id).adicionarComunidade(contas); //ADICIONAR MEMBROS A COMUNIDADE
                                    break;

                                case 10:
                                    contas.get(id).exibirPerfilAlguem(contas); //MOSTRAR PERFIL DE ALGUÉM
                                    break;

                                case 11:
                                    contas.get(id).exibirComunidadeAlguem(contas); //MOSTRAR COMUNIDADE DE ALGUEM
                                    break;

                                case 12:
                                    contas.get(id).mandarFeed(); //MANDAR MENSAGEM PARA O FEED
                                    break;

                                case 13:
                                    contas.get(id).printarFeed();  //VER MEU FEED
                                    break;

                                case 14:
                                    contas.get(id).controlarFeed(); //CONTROLAR QUEM PODE VER O FEED
                                    break;

                                case 15:
                                    contas.get(id).exibirFeedAlguem(contas);  //MOSTRAR O FEED DE ALGUÉM
                                    break;

                                case 16:
                                    contas.get(id).excluirConta(contas, id); //EXCLUI A CONTA
                                    entrada2 = 0;
                                    break;
                                
                                default:
                                    System.out.println("\nNúmero invalido digitado!!\n");
                                    break;

                            }
                            if(entrada2 != 0){
                            System.out.println("\nEscolha o que deseja fazer:");
                            System.out.println("0 - Sair da Conta\n1 - Editar meu perfil\n2 - Exibir meu perfil\n3 - Adicionar um amigo\n4 - Pedidos de amizade\n5 - Exibir lista de amigos\n6 - Enviar uma mensagem\n7 - Ler minhas mensagens\n8 - Criar uma comunidade\n9 - Adicionar membros\n10 - Exibir o perfil de algum usuário\n11 - Exibir alguma comunidade\n12 - Mandar mensagens para o Feed\n13 - Ver meu Feed\n14 - Controlar visualizações no Feed\n15 - Exibir o Feed de algum usuario\n16 - Apagar sua conta");
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
