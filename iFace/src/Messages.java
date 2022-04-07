import java.util.ArrayList;

public class Messages{
	
	public String remetente;
	public ArrayList<String> mensagens = new ArrayList<String>();

	public void printarMensagens(){
		if(mensagens.size() > 0) {
			System.out.println("\nSuas mensagens com " + remetente + ":\n");

			for(int i = 0; i < mensagens.size(); i++) {
				System.out.println(mensagens.get(i));
			}
		}
		else {
			System.out.println("Você ainda não recebeu nenhuma mensagem do(a) " + remetente);
		}
	}
	
}
