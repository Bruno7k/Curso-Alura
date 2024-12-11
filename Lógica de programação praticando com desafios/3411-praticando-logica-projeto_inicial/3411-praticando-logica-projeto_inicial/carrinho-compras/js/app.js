let totalGeral;
limpar();
function adicionar() {
    let produto = document.getElementById('produto').value;
    let quantidade = document.getElementById('quantidade').value;
    let [nomeProduto, preco] = produto.split(' - ');
    let precoReal = parseFloat(preco.replace('R$', '').trim());
    let precoT = quantidade * precoReal;
    if(quantidade>0){
        let carrinho = document.getElementById('lista-produtos');
        carrinho.innerHTML = carrinho.innerHTML + `<section class="carrinho__produtos__produto">
            <span class="texto-azul">${quantidade}x</span> ${nomeProduto} <span class="texto-azul">R$${precoT}</span>
            </section>`;
        totalGeral += precoT;
        let total = document.getElementById('valor-total');
        total.textContent = `R$ ${totalGeral}`;
        document.getElementById('quantidade').value = 0;
    }
    
}

function limpar() {
    document.getElementById('lista-produtos').innerHTML = '';
    document.getElementById('valor-total').textContent = 'R$';
    totalGeral = 0;
}
