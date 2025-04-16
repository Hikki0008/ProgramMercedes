package Gabriel.program.MercedesGerenciador.Servicos;

import Gabriel.program.MercedesGerenciador.Repository.VendaRepository;
import Gabriel.program.MercedesGerenciador.Vendas.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository repository;

    @Autowired
    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataVendaBetween(inicio, fim);
    }
}