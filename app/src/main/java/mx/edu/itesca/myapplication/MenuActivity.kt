package mx.edu.itesca.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnAntojitos: Button = findViewById(R.id.button_antojitos) as Button
        var btnEspecialidades: Button = findViewById(R.id.button_especialidades) as Button
        var btnCombinations: Button = findViewById(R.id.button_combinations) as Button
        var btnTortas: Button = findViewById(R.id.button_tortas) as Button
        var btnSopas: Button = findViewById(R.id.button_sopas) as Button
        var btnDrinks: Button = findViewById(R.id.button_drinks) as Button




        btnAntojitos.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Antojitos")
            intent.putExtra("imgCabecera", R.drawable.antojitos)

            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Especialidades")
            intent.putExtra("imgCabecera", R.drawable.especialidades)

            startActivity(intent)
        }

        btnCombinations.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Combinaciones")
            intent.putExtra("imgCabecera", R.drawable.combinations)

            startActivity(intent)
        }

        btnTortas.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Tortas")
            intent.putExtra("imgCabecera", R.drawable.tortas)

            startActivity(intent)
        }

        btnSopas.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Sopas")
            intent.putExtra("imgCabecera", R.drawable.sopas)

            startActivity(intent)
        }

        btnDrinks.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Drinks")
            intent.putExtra("imgCabecera", R.drawable.drinks)

            startActivity(intent)
        }

    }
}