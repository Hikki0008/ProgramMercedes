const form = document.getElementById('veiculoForm');
const lista = document.getElementById('listaVeiculos');

const API_URL = 'http://localhost:8080/api/veiculos';

// Função para carregar veículos
function carregarVeiculos() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            lista.innerHTML = '';
            data.forEach(veiculo => {
                const li = document.createElement('li');
                li.textContent = `${veiculo.modelo} | ${veiculo.ano} | ${veiculo.placa} | ${veiculo.tipo}`;
                lista.appendChild(li);
            });
        })
        .catch(err => console.error('Erro ao buscar veículos:', err));
}

// Evento de envio do formulário
form.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(form);
    const veiculo = Object.fromEntries(formData.entries());

    fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(veiculo)
    })
        .then(res => {
            if (!res.ok) throw new Error("Erro ao cadastrar veículo.");
            return res.json();
        })
        .then(() => {
            form.reset();
            carregarVeiculos();
            alert('✅ Veículo cadastrado com sucesso!');
        })
        .catch(err => console.error(err));
});

// Carrega ao iniciar
carregarVeiculos();
