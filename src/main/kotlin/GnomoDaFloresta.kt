class GnomoDaFloresta  (nome: String) : Personagem(
    nome = nome,
    raca = "Gnomo da Floresta",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialGnomoDaFloresta()
) {
    override fun mostrar() {
        super.mostrar()
    }

}