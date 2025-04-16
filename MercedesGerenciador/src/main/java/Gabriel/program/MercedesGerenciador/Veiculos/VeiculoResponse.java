package Gabriel.program.MercedesGerenciador.Veiculos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponse {

    private Long id;
    private String modelo;
    private int ano;
    private String placa;
    private String tipo;

    // Construtor para transformar uma entidade Veiculo em VeiculoResponse
    public VeiculoResponse(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.placa = veiculo.getPlaca();
        this.tipo = veiculo.getTipo();
    }
}

