package com.math.personagens_app

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import Personagem
import ModificadorPadrao

class telaDois : AppCompatActivity() {
    companion object {
        const val CHANNEL_ID = "YOUR_CHANNEL_ID"
        const val NOTIFICATION_ID = 1
        const val REQUEST_CODE_NOTIFICATION_PERMISSION = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_dois)

        createNotificationChannel()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), REQUEST_CODE_NOTIFICATION_PERMISSION)
        } else {
            sendNotification()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.telaDois)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Exibe as informações do personagem
        val nome = intent.getStringExtra("NOME") ?: "Desconhecido"
        val raca = intent.getStringExtra("RACA") ?: "Humano"
        val forca = intent.getIntExtra("FORCA", 0)
        val destreza = intent.getIntExtra("DESTREZA", 0)
        val constituicao = intent.getIntExtra("CONSTITUICAO", 0)
        val inteligencia = intent.getIntExtra("INTELIGENCIA", 0)
        val sabedoria = intent.getIntExtra("SABEDORIA", 0)
        val carisma = intent.getIntExtra("CARISMA", 0)
        val pontosDeVida = intent.getIntExtra("PONTOS DE VIDA", 0)

        val personagem = Personagem(nome, raca, forca, destreza, constituicao, inteligencia, sabedoria, carisma, ModificadorPadrao(), null)
        val modificador = ModificadorPadrao()
        val bonusRacial = personagem.bonus()

        findViewById<TextView>(R.id.tvNome).text = "Nome: $nome"
        findViewById<TextView>(R.id.tvRaca).text = "Raça: $raca"
        findViewById<TextView>(R.id.tvForca).text = forca.toString()
        findViewById<TextView>(R.id.tvBonusForca).text = "(+ ${bonusRacial["forca"] ?: 0})"
        findViewById<TextView>(R.id.tvDestreza).text = destreza.toString()
        findViewById<TextView>(R.id.tvBonusDestreza).text = "(+ ${bonusRacial["destreza"] ?: 0})"
        findViewById<TextView>(R.id.tvConstituicao).text = constituicao.toString()
        findViewById<TextView>(R.id.tvBonusConstituicao).text = "(+ ${bonusRacial["constituicao"] ?: 0})"
        findViewById<TextView>(R.id.tvInteligencia).text = inteligencia.toString()
        findViewById<TextView>(R.id.tvBonusInteligencia).text = "(+ ${bonusRacial["inteligencia"] ?: 0})"
        findViewById<TextView>(R.id.tvSabedoria).text = sabedoria.toString()
        findViewById<TextView>(R.id.tvBonusSabedoria).text = "(+ ${bonusRacial["sabedoria"] ?: 0})"
        findViewById<TextView>(R.id.tvCarisma).text = carisma.toString()
        findViewById<TextView>(R.id.tvBonusCarisma).text = "(+ ${bonusRacial["carisma"] ?: 0})"
        findViewById<TextView>(R.id.tvPontosDeVida).text = "$pontosDeVida"
        findViewById<TextView>(R.id.tvModificador).text = " (${modificador.calcularMod(constituicao) ?: 0})"

        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Gmail" // Define o nome do canal como "Gmail"
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(this, telaDois::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            // Ações de Responder e Arquivar
            val replyIntent = Intent(this, telaDois::class.java).apply { putExtra("ACTION", "REPLY") }
            val replyPendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, replyIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            val archiveIntent = Intent(this, telaDois::class.java).apply { putExtra("ACTION", "ARCHIVE") }
            val archivePendingIntent: PendingIntent = PendingIntent.getActivity(this, 1, archiveIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            // Carrega a imagem do perfil
            val largeIcon = BitmapFactory.decodeResource(resources, R.drawable.profile_image)

            // Estilo de Mensagem
            val messagingStyle = NotificationCompat.MessagingStyle("Você")
                .setConversationTitle("Movie night")
                .addMessage("Hey, do you have any plans for tonight? I was thinking a few of us could go watch a movie at the theater nearby...", System.currentTimeMillis(), "Justin Rhyss")

            // Construindo a notificação
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_email) // Ícone do Gmail
                .setLargeIcon(largeIcon) // Adiciona a imagem de perfil
                .setContentTitle("Gmail") // Define o título da notificação como "Gmail"
                .setContentText("Hey, do you have any plans for tonight? I was thinking...")
                .setStyle(messagingStyle)
                .addAction(R.drawable.ic_transparent, "Reply", replyPendingIntent)
                .addAction(R.drawable.ic_transparent, "Archive", archivePendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                notify(NOTIFICATION_ID, builder.build())
            }
        } else {
            Toast.makeText(this, "Permissão de notificações não concedida.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE_NOTIFICATION_PERMISSION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    sendNotification()
                } else {
                    Toast.makeText(this, "Permissão de notificações negada.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
