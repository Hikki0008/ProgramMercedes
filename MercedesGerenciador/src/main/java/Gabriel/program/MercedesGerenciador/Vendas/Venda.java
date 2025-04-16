package Gabriel.program.MercedesGerenciador.Vendas;

import Gabriel.program.MercedesGerenciador.Veiculos.Veiculo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dataVenda;
    private BigDecimal valorVenda;

    @ManyToOne
    private Veiculo veiculo;

}
