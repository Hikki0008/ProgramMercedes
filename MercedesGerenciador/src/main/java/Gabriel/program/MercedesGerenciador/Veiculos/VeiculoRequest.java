package Gabriel.program.MercedesGerenciador.Veiculos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequest {

    private String modelo;
    private int ano;
    private String placa;
    private String tipo;
}
