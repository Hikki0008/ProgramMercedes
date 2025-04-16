package Gabriel.program.MercedesGerenciador.Repository;

import Gabriel.program.MercedesGerenciador.Vendas.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataVendaBetween(LocalDate inicio, LocalDate fim);
}
