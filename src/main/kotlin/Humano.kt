class Humano (nome: String) : Personagem(
    nome = nome,
    raca = "Humano",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialHumano()
) {
    override fun mostrar() {
        super.mostrar()
    }

}