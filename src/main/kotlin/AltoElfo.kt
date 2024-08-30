class AltoElfo (nome: String) : Personagem(
    nome = nome,
    raca = "Alto Elfo",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialAltoElfo()
) {
    override fun mostrar() {
        super.mostrar()
    }

}