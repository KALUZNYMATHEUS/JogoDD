open class Personagem(
    val nome: String,
    var raca: String,
    var forca: Int,
    var destreza: Int,
    var constituicao: Int,
    var inteligencia: Int,
    var sabedoria: Int,
    var carisma: Int,
    var ModFinal: Int
): PersonagemInterface {

    override fun mostrar() {
        println("NOME : $nome")
        println("RAÇA : $raca")
        println("FORÇA : $forca")
        println("DESTREZA : $destreza")
        println("CONSTITUIÇÃO : $constituicao")
        println("INTELIGÊNCIA : $inteligencia")
        println("SABEDORIA : $sabedoria")
        println("CARISMA : $carisma")
        println("PONTOS DE VIDA : $ModFinal")
    }

    override fun calcularMod(valor: Int): Int{
        return when (valor){
            in 0..1 -> -5
            in 2..3 -> -4
            in 4..5 -> -3
            in 6..7 -> -2
            in 8..9 -> -1
            in 10..11 -> 0
            in 12..13 -> +1
            in 14..15 -> +2
            in 16..17 -> +3
            in 18..19 -> +4
            in 20..21 -> +5
            in 22..23 -> +6
            in 24..25 -> +7
            in 26..27 -> +8
            in 28..29 -> +9
            30 -> +10
            else -> throw IllegalArgumentException("Valor de habilidade inválido: $valor")
        }
    }

    override fun aplicarBonusRacial() {
        when (raca) {
            "Humano" -> {
                this.forca += 1
                this.destreza += 1
                this.constituicao += 1
                this.inteligencia += 1
                this.sabedoria += 1
                this.carisma += 1
            }
            "Anão" -> {
                this.constituicao += 2
            }
            "Elfo" -> {
                this.destreza += 2
            }
            "Orc" -> {
                this.forca += 2
                this.constituicao += 1
            }

            "Anão da Montanha" -> {
                this.forca += 2
            }
            "Dracono" -> {
                this.forca += 2
                this.carisma += 1
            }
            "Halfling" -> {
                this.destreza += 2
            }
            "Halfling Robusto" -> {
                this.constituicao += 1
            }
            "Halfling Pes-Leves" -> {
                this.carisma += 1
            }
            "Anão da Colina" -> {
                this.sabedoria += 1
            }
            "Tiefling" -> {
                this.carisma += 2
                this.inteligencia += 1
            }
            "Meio-Elfo" -> {
                this.carisma += 2
            }
            "Gnomo Da Floresta" -> {
                this.destreza += 1
            }
            "Alto Elfo" -> {
                this.inteligencia += 1
            }
            "Gnomo Das Rochas" -> {
                this.constituicao += 1
            }
            "Elfo Da Floresta" -> {
                this.sabedoria += 1
            }
            "Gnomo" -> {
                this.inteligencia += 2
            }
            "Drow" -> {
                this.carisma += 1
            }
            else -> println("Raça sem bônus específico.")
        }
    }
}


