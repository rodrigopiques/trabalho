
public class App {

    private static final int CAPACIDADE_MAXIMA = 100;
    private static Pessoa[] tarefas = new Pessoa[CAPACIDADE_MAXIMA];
    private static int contador = 0;
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = menu.exibirMenuPrincipal();
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    atualizarTarefa();
                    break;
                case 4:
                    excluirTarefa();
                    break;
                case 5:
                    marcarTarefaConcluida();
                    break;
                case 0:
                    menu.exibirMensagem("Saindo do programa...");
                    break;
                default:
                    menu.exibirMensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        menu.fecharScanner();
    }

    public static void adicionarTarefa() {
        if (contador < CAPACIDADE_MAXIMA) {
            String nome = menu.lerString("Digite o nome da tarefa: ");
            String descricao = menu.lerString("Digite a descrição da tarefa: ");
            tarefas[contador] = new Pessoa(nome, descricao);
            contador++;
            menu.exibirMensagem("Tarefa adicionada com sucesso!");
        } else {
            menu.exibirMensagem("Não é possível adicionar mais tarefas. Capacidade máxima atingida.");
        }
    }

    public static void listarTarefas() {
        if (contador == 0) {
            menu.exibirMensagem("Nenhuma tarefa cadastrada.");
            return;
        }

        menu.exibirMensagem("--- Lista de Tarefas ---");
        for (int i = 0; i < contador; i++) {
            System.out.println("ID: " + i);
            System.out.println(tarefas[i]);
            System.out.println("-------------------------");
        }
    }

    public static void atualizarTarefa() {
        if (contador == 0) {
            menu.exibirMensagem("Nenhuma tarefa para atualizar.");
            return;
        }

        listarTarefas();
        int id = menu.lerInt("Digite o ID da tarefa para atualizar: ");

        if (id >= 0 && id < contador) {
            String novoNome = menu.lerString("Digite o novo nome da tarefa: ");
            String novaDescricao = menu.lerString("Digite a nova descrição da tarefa: ");
            tarefas[id].setNome(novoNome);
            tarefas[id].setDescricao(novaDescricao);
            menu.exibirMensagem("Tarefa atualizada com sucesso!");
        } else {
            menu.exibirMensagem("ID de tarefa inválido.");
        }
    }

    public static void excluirTarefa() {
        if (contador == 0) {
            menu.exibirMensagem("Nenhuma tarefa para excluir.");
            return;
        }

        listarTarefas();
        int id = menu.lerInt("Digite o ID da tarefa para excluir: ");

        if (id >= 0 && id < contador) {
            for (int i = id; i < contador - 1; i++) {
                tarefas[i] = tarefas[i + 1];
            }
            tarefas[contador - 1] = null; // Limpa a última posição
            contador--;
            menu.exibirMensagem("Tarefa excluída com sucesso!");
        } else {
            menu.exibirMensagem("ID de tarefa inválido.");
        }
    }

    public static void marcarTarefaConcluida() {
        if (contador == 0) {
            menu.exibirMensagem("Nenhuma tarefa para marcar como concluída.");
            return;
        }

        listarTarefas();
        int id = menu.lerInt("Digite o ID da tarefa para marcar como concluída: ");

        if (id >= 0 && id < contador) {
            tarefas[id].setConcluida(true);
            menu.exibirMensagem("Tarefa marcada como concluída!");
        } else {
            menu.exibirMensagem("ID de tarefa inválido.");
        }
    }
}