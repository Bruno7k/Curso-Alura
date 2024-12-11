function comprar() {
    let tipoIngresso = document.getElementById('tipo-ingresso').value;
    let quantidadeComprada = document.getElementById('qtd').value;
    atualizarQuantidade(tipoIngresso, quantidadeComprada);
}
function atualizarQuantidade(tipo, quantidade) {
    let elementId;

    switch (tipo) {
        case 'inferior':
            elementId = 'qtd-inferior';
            break;
        case 'superior':
            elementId = 'qtd-superior';
            break;
        case 'pista':
            elementId = 'qtd-pista';
            break;
        default:
            console.error('Tipo de ingresso inválido');
            return;
    }

    let quantidadeDisponivel = document.getElementById(elementId);
    let novaQuantidade = parseInt(quantidadeDisponivel.textContent) - quantidade;
    
    if (novaQuantidade < 0) {
        alert('Quantidade indisponível');
    } else {
        quantidadeDisponivel.textContent = novaQuantidade;
    }
}

