class GnomoDasRochas  (nome: String) : Personagem(
    nome = nome,
    raca = "Gnomo das Rochas",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialGnomoDasRochas()
) {
    override fun mostrar() {
        super.mostrar()
    }

}