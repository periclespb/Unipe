# -*- coding: utf-8 -*-

import sys

if sys.version_info.major == 2:
    comprimento, frases = raw_input().split()
elif sys.version_info.major == 3:
    comprimento, frases = input().split()

comprimento = int(comprimento) #comprimento do cartao
frases = int(frases) #frases coletadas
contador = 1 #quantidade de testes

def programacao_dinamica(listaOpcoes, caracteres_sobrando, solucao_dinamica, menor):

    if (caracteres_sobrando < menor):
        return solucao_dinamica
    solucao = []
    for i in listaOpcoes:
        lista = listaOpcoes[:]
        lista.remove(i)
        listaOpcoes.remove(i)
        solucao.append(programacao_dinamica(lista, caracteres_sobrando - i[0], solucao_dinamica + i[1], menor))

    if solucao == []:
        return 0
    return max(solucao)


while comprimento != 0 and frases != 0:
    lista = []

    for i in range(frases):
        if sys.version_info.major == 2:
            n_caracteres, qtd_euteamo = raw_input().split()
            lista.append((int(n_caracteres), int(qtd_euteamo)))
        elif sys.version_info.major == 3:
             n_caracteres, qtd_euteamo = input().split()
             lista.append((int(n_caracteres), int(qtd_euteamo)))


    # busca gulosa
    lista_dinamica = lista[:]
    # pega sempre o que tem mais euteamo
    caracteres_sobrando = comprimento
    solucao_gulosa = 0
    # calcula menor conjunto de chars
    menor = 201
    for i in lista:
        if i[0] < menor:
            menor = i[0]

    # seleciona o maior valor possivel
    while caracteres_sobrando >= menor:
        maior = 0
        char = 0
        if lista == []:
            break
        for i in lista:
            if i[1] >= maior and i[0] <= caracteres_sobrando:
                maior = i[1]
                char = i[0]
        lista.remove((char, maior))
        caracteres_sobrando = caracteres_sobrando - char
        solucao_gulosa += maior

    if sys.version_info.major == 2:
        print('\nTeste ') + str(contador)
        contador += 1
        print('\nSolução Gulosa:') + str(solucao_gulosa)

        # programacao dinâmica
        caracteres_sobrando = comprimento
        solucao_gulosa = 0
        solucao_dinamica = programacao_dinamica(lista_dinamica, caracteres_sobrando, 0, menor)

        print('\nSolução Programação Dinâmica:') + str(solucao_dinamica)
        comprimento, frases = raw_input().split()
        comprimento = int(comprimento)
        frases = int(frases)
    elif sys.version_info.major == 3:
        print('\nTeste {}'.format(contador))
        contador += 1
        print('\nSolução Gulosa: {}'.format(solucao_gulosa))

        # programacao dinâmica
        caracteres_sobrando = comprimento
        solucao_gulosa = 0
        solucao_dinamica = programacao_dinamica(lista_dinamica, caracteres_sobrando, 0, menor)
        print('\nSolução Programação Dinâmica: {}'.format(solucao_dinamica))
        comprimento, frases = input().split()
        comprimento = int(comprimento)
        frases = int(frases)