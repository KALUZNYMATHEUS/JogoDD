import java.util.Scanner
open class Personagem(
    val nome: String,
    var raca: String,
    var forca: Int,
    var destreza: Int,
    var constituicao: Int,
    var inteligencia: Int,
    var sabedoria: Int,
    var carisma: Int,
    var modificador: Modificador,
    var bonusRacialStrategy: BonusRacialStrategy? = null
): PersonagemInterface{

    init {
        definirBonusRacial()
    }

    fun validarAtributos(
        nome: String,
        forca: Int,
        destreza: Int,
        constituicao: Int,
        inteligencia: Int,
        sabedoria: Int,
        carisma: Int
    ): Boolean {
        // Validar se o nome foi preenchido
        if (nome.isBlank()) {
            println("Nome inválido. O nome não pode estar vazio.")
            return false
        }

        // Valida se cada atributo está entre 8 e 15
        val atributosValidos = listOf(
            "Força" to forca,
            "Destreza" to destreza,
            "Constituição" to constituicao,
            "Inteligência" to inteligencia,
            "Sabedoria" to sabedoria,
            "Carisma" to carisma
        )

        for ((atributo, valor) in atributosValidos) {
            if (valor !in 8..15) {
                println("Valor inválido para $atributo. O valor deve estar entre 8 e 15.")
                return false
            }
        }

        // Se todos os valores forem válidos
        return true
    }

     fun definirBonusRacial() {
        bonusRacialStrategy = when (raca) {
            "Humano" -> BonusRacialHumano()
            "Anão" -> BonusRacialAnao()
            "Anão da Colina" -> BonusRacialAnaoDaColina()
            "Anão da Montanha" -> BonusRacialAnaoDaMontanha()
            "Draconato" -> BonusRacialDracono()
            "Drow" -> BonusRacialDrow()
            "Elfo" -> BonusRacialElfo()
            "Elfo da Floresta" -> BonusRacialElfoDaFloresta()
            "Gnomo" -> BonusRacialGnomo()
            "Gnomo da Floresta" -> BonusRacialGnomoDaFloresta()
            "Gnomo das Rochas" -> BonusRacialGnomoDasRochas()
            "Halfling" -> BonusRacialHalfling()
            "Halfling Pés-Leves" -> BonusRacialHalflingPesLeves()
            "Halfling Robusto" -> BonusRacialHalflingRobusto()
            "Meio-Elfo" -> BonusRacialMeioElfo()
            "Orc" -> BonusRacialOrc()
            "Tiefling" -> BonusRacialTiefling()
            else -> null
        }
    }

    fun aplicarBonusRacial() {
        bonusRacialStrategy?.aplicarBonus(this)
    }

    override fun mostrar() {
        println("NOME : $nome")
        println("RAÇA : $raca")
        println("FORÇA : $forca")
        println("DESTREZA : $destreza")
        println("CONSTITUIÇÃO : $constituicao")
        println("INTELIGÊNCIA : $inteligencia")
        println("SABEDORIA : $sabedoria")
        println("CARISMA : $carisma")
        println("PONTOS DE VIDA : ${modificador.calcularMod(constituicao) + 10}")
    }

    override fun distribuirPontos(scanner: Scanner, personagem: Personagem, pontosDisponiveis : Int){
        var maxPontos = 27
        var pontosDisponiveis = maxPontos

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
    }
}


