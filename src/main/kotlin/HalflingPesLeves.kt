class HalflingPesLeves  (nome: String) : Personagem(
    nome = nome,
    raca = "Halfling Pes-Leves",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    ModFinal = 0
) {
    override fun mostrar() {
        super.mostrar()
    }

    override fun calcularMod(valor: Int): Int {
        return super.calcularMod(valor)
    }

    override fun aplicarBonusRacial() {
        super.aplicarBonusRacial()
        // O bônus racial já foi aplicado na inicialização
    }
}