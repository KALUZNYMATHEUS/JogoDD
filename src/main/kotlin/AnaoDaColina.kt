class AnaoDaColina(nome: String) : Personagem(
    nome = nome,
    raca = "Anão da Colina",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialAnaoDaColina()
) {
    override fun mostrar() {
        super.mostrar()
    }

}