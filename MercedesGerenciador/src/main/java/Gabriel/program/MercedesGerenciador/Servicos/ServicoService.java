package Gabriel.program.MercedesGerenciador.Servicos;

import Gabriel.program.MercedesGerenciador.Repository.Repositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private Repositorios.ServicoRepository repository;

    public Servico cadastrar(Servico servico) {
        return repository.save(servico);
    }

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public List<Servico> listarPorVeiculo(Long veiculoId) {
        return repository.findByVeiculoId(veiculoId);
    }
}
