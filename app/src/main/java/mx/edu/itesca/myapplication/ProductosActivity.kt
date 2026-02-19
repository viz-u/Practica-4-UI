package mx.edu.itesca.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregarProductos()

        // Configuración del ListView y el Adaptador
        var listview: ListView = findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }
    fun agregarProductos() {
        menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 5.69))
        menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat...", 10.99))
        menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese marinated pork and pineapple.", 7.99))
        menu.add(Product("Sincronizadas", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole. Sandwich of Two flour tortillas...", 7.99))
        menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice...", 10.99))
        menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice...", 10.99))
        menu.add(Product("Coctel", R.drawable.coctel, "Shrimp cocktail", 16.49))
    }
}
private class AdaptadorProductos : BaseAdapter {
    var productos = ArrayList<Product>()
    var contexto: Context? = null

    // Constructor corregido
    constructor(context: Context, producto: ArrayList<Product>) {
        this.productos = producto
        this.contexto = context
    }

    override fun getCount(): Int {
        return productos.size // Regresa el tamaño real
    }

    override fun getItem(position: Int): Any {
        return productos[position] // Regresa el objeto
    }

    override fun getItemId(position: Int): Long {
        return position.toLong() // Regresa la posición
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = productos[position]
        var inflador = LayoutInflater.from(contexto)

        // Es mejor usar 'parent' para inflar correctamente
        var vista = inflador.inflate(R.layout.producto_view, parent, false)

        var imagen = vista.findViewById<ImageView>(R.id.producto_img)
        var nombre = vista.findViewById<TextView>(R.id.producto_nombre)
        var desc = vista.findViewById<TextView>(R.id.producto_desc)
        var precio = vista.findViewById<TextView>(R.id.producto_precio)

        imagen.setImageResource(prod.image)
        nombre.text = prod.name
        desc.text = prod.description
        precio.text = "$${prod.price}"

        return vista
    }
}