import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    var nome: String
    var personagem: Personagem

    // Definindo o número máximo de pontos que o usuário pode distribuir
    val maxPontos = 27
    var pontosDisponiveis = maxPontos

    println("Informe o nome de seu personagem : ")
    nome = scanner.next()

    // Input da raça
    println("Escolha a raça do personagem:")
    println("1. Anão")
    println("2. Elfo")
    println("3. Humano")
    println("4. Orc")
    println("5. Anão da Montanha")
    println("6. Dracono")
    println("7. Halfling")
    println("8. Halfling Robusto")
    println("9. Halfling Pes-Leves")
    println("10. Anão da Colina")
    println("11. Tiefling")
    println("12. Meio-Elfo")
    println("13. Gnomo Da Floresta")
    println("14. Alto Elfo")
    println("15. Gnomo Das Rochas")
    println("16. Elfo Da Floresta")
    println("17. Gnomo")
    println("18. Drow")

    personagem = when (readLine()?.toIntOrNull()) {
        1 -> Anao(nome)
        2 -> Elfo(nome)
        3 -> Humano(nome)
        4 -> Orc(nome)
        5 -> AnaoDaMontanha(nome)
        6 -> Dracono(nome)
        7 -> Halfling(nome)
        8 -> HalflingRobusto(nome)
        9 -> HalflingPesLeves(nome)
        10 -> AnaoDaColina(nome)
        11 -> Tiefling(nome)
        12 -> MeioElfo(nome)
        13 -> GnomoDaFloresta(nome)
        14 -> AltoElfo(nome)
        15 -> GnomoDasRochas(nome)
        16 -> ElfoDaFloresta(nome)
        17 -> Gnomo(nome)
        18 -> Drow(nome)
        else -> {
            println("Raça inválida, atribuindo Anão por padrão.")
            Anao(nome)
        }
    }

    while (pontosDisponiveis > 0) {
        println("Você tem $pontosDisponiveis pontos para distribuir.")
        println("Tabela de Custo de Pontos de Habilidade:")
        println("Valor | Custo")
        println("--------------")
        println("  8   |   0")
        println("  9   |   1")
        println(" 10   |   2")
        println(" 11   |   3")
        println(" 12   |   4")
        println(" 13   |   5")
        println(" 14   |   7")
        println(" 15   |   9")
        println("Escolha um atributo para adicionar pontos:")
        println("1. Força")
        println("2. Destreza")
        println("3. Constituição")
        println("4. Inteligência")
        println("5. Sabedoria")
        println("6. Carisma")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Força?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.forca) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.forca = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }

            2 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Destreza?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.destreza) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.destreza = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }
            3 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Constituição?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.constituicao) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.constituicao = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }
            4 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Inteligencia?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.inteligencia) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.inteligencia = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }
            5 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Sabedoria?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.sabedoria) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.sabedoria = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }
            6 -> {
                println("Quantos pontos de 8 a 15 deseja ter em Carisma?")
                val pontos = scanner.nextInt()

                if (pontos < 8 || pontos > 15) {
                    println("Digite um número entre 8 e 15")
                } else {
                    val custo = when (pontos) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }
                    val custoAnterior = when (personagem.carisma) {
                        8 -> 0
                        9 -> 1
                        10 -> 2
                        11 -> 3
                        12 -> 4
                        13 -> 5
                        14 -> 7
                        15 -> 9
                        else -> 0
                    }

                    if (pontosDisponiveis + custoAnterior >= custo) {
                        pontosDisponiveis = pontosDisponiveis + custoAnterior - custo
                        personagem.carisma = pontos
                    } else {
                        println("Você não tem pontos suficientes.")
                    }
                }

            }
            else -> {
                println("Opção inválida.")
            }
        }
    }

    println("Todos os pontos foram distribuídos!")

    personagem.ModFinal = personagem.calcularMod(personagem.constituicao) + 10
    personagem.aplicarBonusRacial()
    personagem.mostrar()
}



