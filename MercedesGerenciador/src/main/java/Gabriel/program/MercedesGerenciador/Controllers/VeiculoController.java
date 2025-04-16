package Gabriel.program.MercedesGerenciador.Controllers;

import Gabriel.program.MercedesGerenciador.Veiculos.Veiculo;
import Gabriel.program.MercedesGerenciador.Veiculos.VeiculoService;
import Gabriel.program.MercedesGerenciador.Veiculos.VeiculoRequest;
import Gabriel.program.MercedesGerenciador.Veiculos.VeiculoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // POST /veiculos - Cadastrar um novo veículo
    @PostMapping
    public VeiculoResponse cadastrar(@RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(veiculoRequest.getModelo());
        veiculo.setAno(veiculoRequest.getAno());
        veiculo.setPlaca(veiculoRequest.getPlaca());
        veiculo.setTipo(veiculoRequest.getTipo());

        Veiculo veiculoSalvo = veiculoService.cadastrar(veiculo);

        return new VeiculoResponse(veiculoSalvo); // Retorna o DTO de resposta
    }

    // GET /veiculos - Listar todos os veículos
    @GetMapping
    public List<VeiculoResponse> listarTodos() {
        List<Veiculo> veiculos = veiculoService.listarTodos();
        return veiculos.stream()
                .map(VeiculoResponse::new)  // Transforma cada Veiculo em VeiculoResponse
                .collect(Collectors.toList());
    }
}


