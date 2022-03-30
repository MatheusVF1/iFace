package iFace.src;

import java.util.Scanner;

public class Account {
    public String login, username;
    private String password;
    public String sexo, cidade;
    public int idade;

    public void newAccount(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Login: ");
        login = sc.nextLine();

        System.out.println("Password: ");
        password = sc.nextLine();

        System.out.println("Username: ");
        username = sc.nextLine();

        sc.close();
    }

    public String getPassword(){
        return this.password;
    }

    public void newProfile(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Sexo: ");
        sexo = sc.nextLine();

        System.out.println("Idade: ");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Cidade: ");
        cidade = sc.nextLine();

        sc.close();
    }
}