import java.util.ArrayList;
import java.util.Scanner;

public class Community{
	public String dono, nomeComunidade, descricao;
	public ArrayList<String> membros = new ArrayList<String>();
	
	public void criarNovaComunidade(String donoComunidade) {	
		Scanner sc = new Scanner(System.in);
		
		dono = donoComunidade;
		membros.add(donoComunidade);

		System.out.println("Bem vindo a criação da comunidade! Escreva as informações abaixo.");

		System.out.print("Nome da comunidade: ");
		nomeComunidade = sc.nextLine();
		
		System.out.print("Descrição da comunidade: ");
		descricao = sc.nextLine();
		
		System.out.println("\nParabéns! Sua comunidade foi criada!");
		
	}
	
	public void mostrarComunidade() {
		System.out.println("\n--------------------------\n" + nomeComunidade.toUpperCase() + "\n--------------------------");
		System.out.println("Criado por: " + dono);
		System.out.println("Descrição: " + descricao);
		System.out.println("Membros:");
		for(int i = 0; i < membros.size(); i++) {
			System.out.println("   " + membros.get(i));
		}
		
	}
	
	
}
