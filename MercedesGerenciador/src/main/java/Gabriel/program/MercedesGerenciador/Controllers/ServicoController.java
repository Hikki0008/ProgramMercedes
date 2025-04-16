package Gabriel.program.MercedesGerenciador.Controllers;

import Gabriel.program.MercedesGerenciador.Servicos.Servico;
import Gabriel.program.MercedesGerenciador.Servicos.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    // POST /servicos
    @PostMapping
    public Servico cadastrar(@RequestBody Servico servico) {
        return servicoService.cadastrar(servico);
    }

    // GET /servicos
    @GetMapping
    public List<Servico> listarTodos() {
        return servicoService.listarTodos();
    }

    // GET /servicos/veiculo/{id}
    @GetMapping("/veiculo/{veiculoId}")
    public List<Servico> listarPorVeiculo(@PathVariable Long veiculoId) {
        return servicoService.listarPorVeiculo(veiculoId);
    }
}
