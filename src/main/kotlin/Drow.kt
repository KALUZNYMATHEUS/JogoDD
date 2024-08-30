class Drow (nome: String) : Personagem(
    nome = nome,
    raca = "Drow",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialDrow()
) {
    override fun mostrar() {
        super.mostrar()
    }

}