class Humano (nome: String) : Personagem(
    nome = nome,
    raca = "Humano",
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
        this.forca += 1
        this.destreza += 1
        this.constituicao += 1
        this.inteligencia += 1
        this.sabedoria += 1
        this.carisma += 1
    }


}