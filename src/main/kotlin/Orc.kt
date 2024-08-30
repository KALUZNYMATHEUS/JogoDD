class Orc (nome: String) : Personagem(
    nome = nome,
    raca = "Meio-orc",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialOrc()

) {
    override fun mostrar() {
        super.mostrar()
    }

}