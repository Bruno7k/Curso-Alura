let amigos = [];
let presenteia = [];
let recebe = [];

function adicionar() {
    let nome = document.getElementById('nome-amigo').value;
    if (nome && !amigos.includes(nome)) { 
        amigos.push(nome);
        document.getElementById('lista-amigos').innerHTML = amigos.join(', ');
        document.getElementById('nome-amigo').value = '';
    } else {
        alert('Digite um nome válido e que não esteja na lista.');
    }
}

function sortear() {
    if (amigos.length < 2) {
        alert('Adicione pelo menos 2 amigos para realizar o sorteio.');
        return;
    }

    presenteia = [...amigos]; 
    recebe = [...amigos]; 

    recebe = recebe.sort(() => Math.random() - 0.5);
    presenteia = presenteia.sort(() => Math.random() - 0.5);


    for (let i = 0; i < presenteia.length; i++) {
        if (presenteia[i] === recebe[i]) {
            let temp = recebe[i];
            let j = (i + 1) % recebe.length;
            recebe[i] = recebe[j];
            recebe[j] = temp;
        }
    }

    let conteudo = '';
    for (let i = 0; i < amigos.length; i++) {
        conteudo += presenteia[i] + ' -> ' + recebe[i] + '<br>';
    }
    document.getElementById('lista-sorteio').innerHTML = conteudo;
}

function reiniciar() {
    amigos = [];
    presenteia = [];
    recebe = [];
    document.getElementById('lista-amigos').innerHTML = '';
    document.getElementById('lista-sorteio').innerHTML = '';
}