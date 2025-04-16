package Gabriel.program.MercedesGerenciador.Controllers;

import Gabriel.program.MercedesGerenciador.Veiculos.Veiculo;
import Gabriel.program.MercedesGerenciador.Veiculos.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController {

    private final VeiculoService veiculoService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public ConsoleController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
                continue;
            }

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> listarVeiculos();
                case 0 -> System.out.println("Encerrando o sistema.");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarVeiculo() {
        System.out.println("\n--- Cadastro de Veículo ---");

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setPlaca(placa);
        veiculo.setTipo(tipo);

        veiculoService.cadastrar(veiculo);
        System.out.println("✅ Veículo cadastrado com sucesso!");
    }

    private void listarVeiculos() {
        System.out.println("\n--- Lista de Veículos ---");
        List<Veiculo> lista = veiculoService.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : lista) {
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Ano: " + veiculo.getAno());
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Tipo: " + veiculo.getTipo());
                System.out.println("--------------------------");
            }
        }
    }
}



