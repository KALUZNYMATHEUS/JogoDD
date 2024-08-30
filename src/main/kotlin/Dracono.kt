class Dracono(nome: String) : Personagem(
    nome = nome,
    raca = "Dracono",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    modificador = ModificadorPadrao(),
    bonusRacialStrategy = BonusRacialDracono()
) {
    override fun mostrar() {
        super.mostrar()
    }

}