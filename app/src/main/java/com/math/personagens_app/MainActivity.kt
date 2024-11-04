package com.math.personagens_app

import BonusRacialAltoElfo
import BonusRacialAnao
import BonusRacialAnaoDaColina
import BonusRacialAnaoDaMontanha
import BonusRacialDracono
import BonusRacialDrow
import BonusRacialElfo
import BonusRacialElfoDaFloresta
import BonusRacialGnomo
import BonusRacialGnomoDaFloresta
import BonusRacialGnomoDasRochas
import BonusRacialHalfling
import BonusRacialHalflingPesLeves
import BonusRacialHalflingRobusto
import BonusRacialHumano
import BonusRacialMeioElfo
import BonusRacialOrc
import BonusRacialTiefling
import ModificadorPadrao
import Personagem
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Spinner
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var pontosDisponiveis = 27 // Valor inicial dos pontos disponíveis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        fun atualizarPontosDisponiveis() {
            try {

                val nome = findViewById<EditText>(R.id.etNome).text.toString()
                val raca = findViewById<Spinner>(R.id.etRaca).selectedItem.toString()

                val forca = findViewById<EditText>(R.id.etForça).text.toString().toIntOrNull() ?: 8
                val destreza =
                    findViewById<EditText>(R.id.etDestreza).text.toString().toIntOrNull() ?: 8
                val constituicao =
                    findViewById<EditText>(R.id.etConstituicao).text.toString().toIntOrNull() ?: 8
                val inteligencia =
                    findViewById<EditText>(R.id.etInteligencia).text.toString().toIntOrNull() ?: 8
                val sabedoria =
                    findViewById<EditText>(R.id.etSabedoria).text.toString().toIntOrNull() ?: 8
                val carisma =
                    findViewById<EditText>(R.id.etCarisma).text.toString().toIntOrNull() ?: 8

                val personagem = Personagem(nome, raca, forca, destreza, constituicao, inteligencia, sabedoria, carisma, ModificadorPadrao(), null)


                val custoForca =  personagem.calcularCusto(forca)
                val custoDestreza =  personagem.calcularCusto(destreza)
                val custoConstituicao =  personagem.calcularCusto(constituicao)
                val custoInteligencia =  personagem.calcularCusto(inteligencia)
                val custoSabedoria =  personagem.calcularCusto(sabedoria)
                val custoCarisma =  personagem.calcularCusto(carisma)


                val custoTotal =
                    custoForca + custoDestreza + custoConstituicao + custoInteligencia + custoSabedoria + custoCarisma

                val pontosRestantes = 27 - custoTotal


                findViewById<TextView>(R.id.tvPontosDisponiveis).text =
                    "Pontos Disponíveis: $pontosRestantes"


                pontosDisponiveis = pontosRestantes


                if (pontosRestantes < 0) {
                    findViewById<TextView>(R.id.tvPontosDisponiveis).text = "Pontos insuficientes!"
                }

            } catch (e: NumberFormatException) {
                findViewById<TextView>(R.id.tvPontosDisponiveis).text = "Erro ao calcular pontos"
            }
        }


        fun configurarTextWatchers() {
            val camposAtributos = listOf(
                findViewById<EditText>(R.id.etForça),
                findViewById<EditText>(R.id.etDestreza),
                findViewById<EditText>(R.id.etConstituicao),
                findViewById<EditText>(R.id.etInteligencia),
                findViewById<EditText>(R.id.etSabedoria),
                findViewById<EditText>(R.id.etCarisma)
            )

            for (campo in camposAtributos) {
                campo.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        atualizarPontosDisponiveis()
                    }

                    override fun afterTextChanged(s: Editable?) {}
                })
            }
        }

        fun aplicarBonusRacial(personagem: Personagem) {
            when (personagem.raca) {
                "Humano" -> personagem.bonusRacialStrategy = BonusRacialHumano()
                "Alto Elfo" -> personagem.bonusRacialStrategy = BonusRacialAltoElfo()
                "Anão" -> personagem.bonusRacialStrategy = BonusRacialAnao()
                "Anão da Colina" -> personagem.bonusRacialStrategy = BonusRacialAnaoDaColina()
                "Anão da Montanha" -> personagem.bonusRacialStrategy = BonusRacialAnaoDaMontanha()
                "Draconato" -> personagem.bonusRacialStrategy = BonusRacialDracono()
                "Drow" -> personagem.bonusRacialStrategy = BonusRacialDrow()
                "Elfo" -> personagem.bonusRacialStrategy = BonusRacialElfo()
                "Elfo da Floresta" -> personagem.bonusRacialStrategy = BonusRacialElfoDaFloresta()
                "Gnomo" -> personagem.bonusRacialStrategy = BonusRacialGnomo()
                "Gnomo das Rochas" -> personagem.bonusRacialStrategy = BonusRacialGnomoDasRochas()
                "Gnomo da Floresta" -> personagem.bonusRacialStrategy = BonusRacialGnomoDaFloresta()
                "Halfling" -> personagem.bonusRacialStrategy = BonusRacialHalfling()
                "Halfling Pés-Leves" -> personagem.bonusRacialStrategy = BonusRacialHalflingPesLeves()
                "Halfling Robusto" -> personagem.bonusRacialStrategy = BonusRacialHalflingRobusto()
                "Meio-Elfo" -> personagem.bonusRacialStrategy = BonusRacialMeioElfo()
                "Orc" -> personagem.bonusRacialStrategy = BonusRacialOrc()
                "Tiefling" -> personagem.bonusRacialStrategy = BonusRacialTiefling()
            }
        }

        configurarTextWatchers()

        val btnCreateCharacter = findViewById<Button>(R.id.btnCreateCharacter)
        btnCreateCharacter.setOnClickListener {


            val nome = findViewById<EditText>(R.id.etNome).text.toString()
            val raca = findViewById<Spinner>(R.id.etRaca).selectedItem.toString()


            try {
                val forca = findViewById<EditText>(R.id.etForça).text.toString().toInt()
                val destreza = findViewById<EditText>(R.id.etDestreza).text.toString().toInt()
                val constituicao =
                    findViewById<EditText>(R.id.etConstituicao).text.toString().toInt()
                val inteligencia =
                    findViewById<EditText>(R.id.etInteligencia).text.toString().toInt()
                val sabedoria = findViewById<EditText>(R.id.etSabedoria).text.toString().toInt()
                val carisma = findViewById<EditText>(R.id.etCarisma).text.toString().toInt()

                val modificador = ModificadorPadrao()


                val personagem = Personagem(nome, raca, forca, destreza, constituicao, inteligencia, sabedoria, carisma, ModificadorPadrao(), null)

                if (!personagem.validarAtributosPersonagem(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma)) {
                    Toast.makeText(
                        this,
                        "Preencha todos os campos corretamente. Atributos devem estar entre 8 e 15.",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }


                val custoTotal =
                    personagem.calcularCusto(forca) +  personagem.calcularCusto(destreza) + personagem.calcularCusto(constituicao) +  personagem.calcularCusto(inteligencia) +  personagem.calcularCusto(sabedoria) +  personagem.calcularCusto(carisma)

                if (custoTotal > 27) {
                    Toast.makeText(
                        this,
                        "Pontos insuficientes para distribuir esses atributos. Custo: $custoTotal, Disponíveis: $pontosDisponiveis",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }

                    aplicarBonusRacial(personagem)
                    personagem.aplicarBonusRacial()

                    val forcaFinal = personagem.forca
                    val destrezaFinal = personagem.destreza
                    val constituicaoFinal = personagem.constituicao
                    val inteligenciaFinal = personagem.inteligencia
                    val sabedoriaFinal = personagem.sabedoria
                    val carismaFinal = personagem.carisma

                

                val intent = Intent(this, telaDois::class.java)
                intent.putExtra("NOME", nome)
                intent.putExtra("RACA", raca)
                intent.putExtra("FORCA", forcaFinal)
                intent.putExtra("DESTREZA", destrezaFinal)
                intent.putExtra("CONSTITUICAO", constituicaoFinal)
                intent.putExtra("INTELIGENCIA", inteligenciaFinal)
                intent.putExtra("SABEDORIA", sabedoriaFinal)
                intent.putExtra("CARISMA", carismaFinal)
                intent.putExtra("PONTOS DE VIDA", modificador.calcularMod(constituicaoFinal) + 10
                )

                    startActivity(intent)


            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Preencha todos os campos corretamente com números válidos.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}