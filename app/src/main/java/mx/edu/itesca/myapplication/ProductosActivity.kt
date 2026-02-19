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

        val ivHeader = findViewById<ImageView>(R.id.imageView)
        val bundle = intent.extras
        if (bundle != null) {
            val imagenRes = bundle.getInt("imgCabecera")

            ivHeader.setImageResource(imagenRes)
        }
        var menuOption: String?= intent.getStringExtra("menuType")
        agregarProductos(menuOption)
        var listview: ListView = findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }
    fun agregarProductos(option:String?) {
        when(option){
            "Antojitos"->{
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 5.69))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat...", 10.99))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese marinated pork and pineapple.", 7.99))
                menu.add(Product("Sincronizadas", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole. Sandwich of Two flour tortillas...", 7.99))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice...", 10.99))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice...", 10.99))
                menu.add(Product("Coctel", R.drawable.coctel, "Shrimp cocktail", 16.49))
            }
            "Especialidades"->{
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas. Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas.", 17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo, served with chips.", 6.99))
                menu.add(Product("Botana Camarones al mojo de ajo", R.drawable.botanacamarones, "", 19.99))
            }
            "Combinaciones"->{
                menu.add(Product("Taco Tradicional Combo", R.drawable.taco, "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", 6.99))
                menu.add(Product("Mexican Burritos", R.drawable.burritos, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz. Your choice of meat on a big burrito made of flour tortilla with", 13.69))
                menu.add(Product("Los Portales Burrito", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans. Served with a side of lettuce salad, tomatoes, sour cream and guacamole.", 14.59))
                menu.add(Product("Cinco", R.drawable.cinco, "One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, and beans. Served with rice and beans.", 10.99))
                menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. Served with a side of rice and beans.", 10.99))
            }
            "Tortas"->{
                menu.add(Product("Torta Regular", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", 13.39))
                menu.add(Product("Torta Milanesa de Res o Pollo", R.drawable.tortamilanesa, "Breaded steak or chicken.", 13.99))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.", 14.49))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada y pastor. Mexican sausage, steak and marinated por.", 13.99))
                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican, "Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.", 11.99))
            }
            "Sopas"->{
                menu.add(Product("Pozole", R.drawable.pozole, "WEDNSDAY - SUNDAY Pork ribs and bonston butt stew with homminy and oregano. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL.", 7.99))
                menu.add(Product("Menudo", R.drawable.menudo, "Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down through generations.", 8.99))
                menu.add(Product("Caldo de Res", R.drawable.caldores, "Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE", 8.39))
                menu.add(Product("Caldo de Camaron", R.drawable.caldocamaron, "Shrimp soup.", 13.99))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Seafood soup.", 21.99))
            }
            "Drinks"->{
                menu.add(Product("Michelada", R.drawable.michelada, "", 3.75))
                menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.75))
                menu.add(Product("Caguamas", R.drawable.caguama, "", 9.99))
                menu.add(Product("Caguamas Micheladas", R.drawable.caguamamichelada, "", 2.75))
                menu.add(Product("Charolazo", R.drawable.charolazo, "", 9.75))
                menu.add(Product("Cubeta Six", R.drawable.cubetasix, "", 9.75))
                menu.add(Product("Cubetazo", R.drawable.cubetazo, "", 9.75))
                menu.add(Product("Mexican Beer", R.drawable.mexicanbeer, "", 2.75))
                menu.add(Product("Sodas", R.drawable.sodas, "", 2.75))



            }
        }

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
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = productos[position]
        var inflador = LayoutInflater.from(contexto)

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