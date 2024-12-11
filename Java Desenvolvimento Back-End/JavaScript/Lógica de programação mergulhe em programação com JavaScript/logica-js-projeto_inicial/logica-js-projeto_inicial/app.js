alert('Boas vindas ao jogo do número secreto');
let limite = prompt('Escolha um numero para ser o limite do jogo');
let numeroSecreto = parseInt(Math.random() * limite) + 1;
let chute;
let cont = 1;


while (chute != numeroSecreto) {
    chute = prompt(`Escolha um número entre 1 e ${limite}`);
    if (chute == numeroSecreto) {
        break;
    }else{
        if(numeroSecreto > chute){
            alert(`O número secreto é maior que o ${chute}`);
        }else{
            alert(`O número secreto é menor que o ${chute}`);
        }
        cont++;
    }
}

let palavraTentativa = cont > 1 ? 'tentativas' : 'tentativa';
alert(`O número secreto era ${numeroSecreto} e você acertou com apenas ${cont} ${palavraTentativa}`);
// if(cont == 1){
//     alert(`O número secreto era ${numeroSecreto} e você acertou com apenas ${cont} tentativa`);
// }else{
//     alert(`O número secreto era ${numeroSecreto} e você acertou com apenas ${cont} tentativas`);
// }
