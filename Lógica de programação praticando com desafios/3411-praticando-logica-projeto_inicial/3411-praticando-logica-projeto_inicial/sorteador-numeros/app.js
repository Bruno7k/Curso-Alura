function sortear(){
    let quantidade = parseInt(document.getElementById('quantidade').value);
    let comeco = parseInt(document.getElementById('de').value);
    let fim = parseInt(document.getElementById('ate').value);

    // Verifica se os valores de intervalo são válidos
    if (comeco > fim) {
        alert('O valor "De" não pode ser maior que o valor "Até".');
        return;
    }

    let numerosSorteados = [];
    let numero;

    for (let i = 0; i < quantidade; i++) {
        numero = obterNumeroAleatorio(comeco, fim);
        while (numerosSorteados.includes(numero)) {
            numero = obterNumeroAleatorio(comeco, fim);
        }
        numerosSorteados.push(numero);
    }

    let resultado = document.getElementById('resultado');
    resultado.innerHTML = `<label class="texto__paragrafo">Números sorteados: ${numerosSorteados}</label>`;
    alterarStatusBotao();
}

function obterNumeroAleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function alterarStatusBotao(){
    let botao = document.getElementById('btn-reiniciar');
    if (botao.classList.contains('container__botao-desabilitado')) {
        botao.classList.remove('container__botao-desabilitado');
        botao.classList.add('container__botao');
    } else {
        botao.classList.remove('container__botao');
        botao.classList.add('container__botao-desabilitado');
    }
}

function reiniciar(){
    document.getElementById('quantidade').value = '';
    document.getElementById('de').value = '';
    document.getElementById('ate').value = '';
    document.getElementById('resultado').innerHTML = '<label class="texto__paragrafo">Números sorteados:  nenhum até agora</label>';
    alterarStatusBotao();
}
