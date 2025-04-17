package Gabriel.program.MercedesGerenciador.Controllers;

import Gabriel.program.MercedesGerenciador.Veiculos.Veiculo;
import Gabriel.program.MercedesGerenciador.Servicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500") // ou onde você estiver rodando o HTML
@RestController
@RequestMapping("/api/veiculos") // Define a base URL da API
public class VeiculoRestController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoRestController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Endpoint para cadastrar um novo veículo
    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrar(veiculo);
    }

    // Endpoint para listar todos os veículos
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }


}

