class AnaoDaMontanha(nome: String) : Personagem(
    nome = nome,
    raca = "Anão da Montanha",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialAnaoDaMontanha()
) {
    override fun mostrar() {
        super.mostrar()
    }

}