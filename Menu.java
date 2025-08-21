import java.util.Scanner;

public class Menu {

    private Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public int exibirMenuPrincipal() {
        System.out.println("--- Lista de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Atualizar Tarefa");
        System.out.println("4. Excluir Tarefa");
        System.out.println("5. Marcar Tarefa como Concluída");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return entrada.nextInt();
    }

    public String lerString(String mensagem) {
        System.out.print(mensagem);
        entrada.nextLine(); // Consome a quebra de linha
        return entrada.nextLine();
    }

    public int lerInt(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        if (entrada != null) {
            entrada.close();
        }
    }
}