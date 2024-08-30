class Halfling (nome: String) : Personagem(
    nome = nome,
    raca = "Halfling",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialHalfling()
) {
    override fun mostrar() {
        super.mostrar()
    }

}