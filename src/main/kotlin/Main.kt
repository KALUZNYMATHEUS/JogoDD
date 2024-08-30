import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    var nome: String
    var personagem: Personagem


    var maxPontos = 27
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

    personagem.distribuirPontos(scanner, personagem, pontosDisponiveis)

    println("Todos os pontos foram distribuídos!")

    personagem.aplicarBonusRacial()
    personagem.mostrar()
}



