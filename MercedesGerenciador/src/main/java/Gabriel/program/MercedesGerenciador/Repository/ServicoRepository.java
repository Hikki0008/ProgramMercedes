package Gabriel.program.MercedesGerenciador.Repository;

import Gabriel.program.MercedesGerenciador.Servicos.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByVeiculoId(Long veiculoId);
}
