let listaDeNumerosSorteados = [];
let numeroLimite = 10;
let numeroSecreto = gerarNumeroAleatorio();
let cont = 1;
function exibirTextoNaTela(tag, texto){
    let campo = document.querySelector(tag);
    campo.innerHTML = texto;
    responsiveVoise.speak(texto, 'Brazilian Portuguese Female',{rate:1.2});
}
function exibirMensagemInicial(){
    exibirTextoNaTela('h1', 'Jogo do Número Secreto');
    exibirTextoNaTela('p', 'Adivinhe o número secreto entre 1 e 10');
}

exibirMensagemInicial();
function verificarChute(){
    let chute = document.querySelector('input').value;
    console.log(numeroSecreto);

    if (chute == numeroSecreto){
        exibirTextoNaTela('h1', 'Parabéns, você acertou!');
        let palavraTentativa = cont > 1 ? 'tentativas' : 'tentativa';
        let mensagem = `O número secreto era ${numeroSecreto} e você acertou com apenas ${cont} ${palavraTentativa}`;
        exibirTextoNaTela('p', mensagem);    
        document.getElementById('reiniciar').removeAttribute('disabled');
    }else{
        if(chute > numeroSecreto){
            exibirTextoNaTela('p', 'O número secreto é menor');
        }else{
            exibirTextoNaTela('p', 'O número secreto é maior');
        }
        cont++;
        limparCampo();
    }
}

function reiniciarJogo(){
    numeroSecreto = gerarNumeroAleatorio();
    limparCampo();
    cont = 1;
    exibirMensagemInicial();
    document.getElementById('reiniciar').setAttribute('disabled', true);
}

function gerarNumeroAleatorio(){
    let numeroEscolhido = parseInt(Math.random() * numeroLimite + 1);
    let quatidadeDeElementosNaLista = listaDeNumerosSorteados.length;

    if(quatidadeDeElementosNaLista == numeroLimite){
        listaDeNumerosSorteados = [];
    }

    if(listaDeNumerosSorteados.includes(numeroEscolhido)){
        return gerarNumeroAleatorio();
    }else{
        listaDeNumerosSorteados.push(numeroEscolhido);
        return numeroEscolhido;
    }
}

function limparCampo(){
    chute = document.querySelector('input');
    chute.value = '';
}