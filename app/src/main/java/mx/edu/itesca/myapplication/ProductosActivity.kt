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

private class AdaptadorProductos: BaseAdapter{
    var productos= ArrayList<Product>()
    var contexto: Context?=null

    constructor(context: Context, producto: ArrayList<Product>){
        this.productos=productos
        this.contexto=contexto
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any? {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = productos[position]

        var inflador = LayoutInflater.from(contexto)
        var vista = inflador.inflate(R.layout.producto_view, null)

        var imagen = vista.findViewById(R.id.producto_img) as ImageView
        var nombre = vista.findViewById(R.id.producto_nombre) as TextView
        var desc = vista.findViewById(R.id.producto_desc) as TextView
        var precio = vista.findViewById(R.id.producto_precio) as TextView

        imagen.setImageResource(prod.image)
        nombre.setText(prod.name)
        desc.setText(prod.description)
        precio.setText("$${prod.price}")

        return vista
    }

}