package Gabriel.program.MercedesGerenciador.Repository;

import Gabriel.program.MercedesGerenciador.Servicos.Servico;
import Gabriel.program.MercedesGerenciador.Veiculos.Veiculo;
import Gabriel.program.MercedesGerenciador.Vendas.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class Repositorios {
    public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}

    public interface VendaRepository extends JpaRepository<Venda, Long> {}

    public interface ServicoRepository extends JpaRepository<Servico, Long> {
        List<Servico> findByVeiculoId(Long veiculoId);
    }

}
