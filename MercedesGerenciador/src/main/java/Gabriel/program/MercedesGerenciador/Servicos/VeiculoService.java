package Gabriel.program.MercedesGerenciador.Veiculos;

import Gabriel.program.MercedesGerenciador.Repository.Repositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final Repositorios.VeiculoRepository repository;

    @Autowired
    public VeiculoService(Repositorios.VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }
}
