package Gabriel.program.MercedesGerenciador;


import Gabriel.program.MercedesGerenciador.Controllers.ConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercedesApp implements CommandLineRunner {

    @Autowired
    private ConsoleController consoleController;

    public static void main(String[] args) {
        SpringApplication.run(MercedesApp.class, args);
    }

    @Override
    public void run(String... args) {
        consoleController.iniciar();
    }
}
