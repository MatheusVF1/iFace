package iFace.src;
import java.util.Scanner;

public class iFace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int entrada = -1;

        System.out.println("Seja bem vindo ao iFace");
        System.out.println("Escolha o que deseja fazer:");
        System.out.println("0 - Sair do programa\n1 - Criar uma conta\n");

        while (entrada != 0){
            entrada = sc.nextInt();
            sc.nextLine();

            switch(entrada){
                case 1:
                    Account user = new Account();

                    user.newAccount(); //CRIAR UMA CONTA NOVA
                    user.newProfile(); //CRIAR SEU PERFIL

                    System.out.println("Conta criada com sucesso");
                    break;
            }
        }
        sc.close();
    }
}
