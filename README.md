Este é projeto de estudo com o intuito de gerar meu primeiro projeto POO java 21.

Farei um projeto voltado a pratica de progamação orientada a objeto

Projeto: Herança de estoque e produtos Exemplo: Irei adicionar ao meu estoque um produto{ nome = "Caixa de ovo", Pai = null, Qndd = 1, minhaProporcao = 1, 
proporcaoHerança = 12 }

aqui podemos visualizar que o nome desse produto e vemos também que não é um sub-produto e que ele é 1 unidade e pode deixar de herança 12 unidades então ele é 1x12,
pra cada unidade dele pode deixar de herança 12 unidades, logo pra ter 1 unidade dele, seu filho teria que ter 12

Irei adicionar sub-produto{ nome = "Carte de ovo", Pai = "Caixa de ovo", Qndd = 0, minhaProporcao = 1, proporcaoHerança = 30}

aqui já acontece varias coisas, uma delas é que esse sub-produto terá 12 unidade de estoque, mesmo que a quantidade inicial sejá 0.
Isso porque seu estoque está vinculado a estoque do produto pai, logo herda o seu estoque convertido.
Já que cada unidade dele e 12 unidade que seu filho irá herda, no caso os subs produtos. E vimos também que ele é da proporção 1x30.
cada unidade desse sub produto passará como herança 30 unidades então mesmo sendo um produto filho também poderá ser um produto pai.

Irei adicionar outro sub-produto{ nome = "ovo", Pai = "Cartela de ovo", Qndd = 0, minhaProporcao = 1, proporcaoHerança = 1}

aqui irei assim como outro sub produto seu estoque estará vinculçado ao estoque do seu pai,
com a proporção de herança de seu pai e 1x30 onde cada unidade de seu pai se converte 30 unidade que esse produto herdará, logo seu estoque é de 360 unidades. 
Já que a raiza que é a caixa que tem a proporção de 1x12 e do seu pai que é 1x30 logo 1x12x30 = 360. Aqui também vimos que é o fim de gerações desse produto, 
logo que esse produto so consegue passa como herança ele mesmo. -- podendo futuramente usar isso para encaixar produtos compostos ou transforma esse produto em outro 
produto onde esse hoje não é o objetivo.

EX1 ==> OK, agora irei adicionar 30 unidades no produto ovo:

ao adicionar 30 unidade no estoque do produto ovo, terá a função de distribuição onde passará para o produto pai.
Logo 30 ovos será igua à 1 unidade do produto pai, porém o produto cartela de ovo passará para o seu pai que é a caixa de ovo, que mesmo adicionando uma cartela 
de ovos continuaria sendo uma caixa, porém adicionará no estoque de herança estrá 13 unidade. Então o produto cartela de ovo terá 13 unidade e produto ovo terá 390 unidades.

Mais porque o produto raiz "caixa de ovo" continuaria sendo uma caixa. 
No sistema terá dois tipo de estoque. O primeiro seria o estoque estoqueAtual, e o estoqueHerança;
As funcionalidades desses estoque é o controle de estoque diante das converções de herança. 
O produto "caixa de ovo" a sia proporção é 1 porém pra cada unidade dele poderá gerar 12 unidade de herança
-- também poderia ser 360 unidade -- então no estoqueAtual desse produto continuaria sendo 1 mesmo que tenha 13 unidade de herança.
Pois para que o estoqueAtua ter 2 unidade seria necessario 24 de herança pra ter 2 unidade. Quando chegar no produto raiz a atualização de estoque, 
seus descendentes atualizaria os seus de acordo com a porporção desles.

EX2 ==> OK, agora irei adicionar 30 unidades no produto ovo:

ao adicionar 15 unidade no sub produto ovo passará a converte para seu pai, e aqui iremos ver uma outra funcionalidade na logica de gestão de estoque. 
O pai do produto ovo é a Cartela de ovo que é 1x30 porém foi adicionado 15 unidade, logo não daria pra gerá uma cartela de ovos para passar 
a converção para o pai da cartela de ovo que é caixa de ovo --
porém se a caixa de ovo tivesse a proporção de 1x360 poderia passar já que a cartela de ovo teria que ser 30x30 já
que precisaria consumir 30 de herança pra ter uma unidade no estoqueAtual e logo também poderia passar como herança 30 unidade, 
assim cada não importa que parte dessa geração será adicionada, todos serpa afetado -- então a atualização será somete na cartela e o ovo. 
A cartela continuaria tendo 12 estoqueAtual porem o estoqueHerança estaria 375. Desta forma manteria a isolação dependendo da da porporção inicial Raiz. 
Como não teve adicção suficiente para tranforma em uma cartela de ovo não teria como converte pra caixa.
