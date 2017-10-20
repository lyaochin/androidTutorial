package lyaochin.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.ListView
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import android.widget.AdapterView
import lyaochin.listview.R.id.listView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// получаем экземпляр элемента ListView
        val listView = findViewById(R.id.listView) as ListView
        val editText = findViewById(R.id.editText) as EditText

        // Создаём пустой массив для хранения значений
        val myArray: ArrayList<String> = ArrayList()

        // Создаём адаптер ArrayAdapter, чтобы привязать массив к ListView
        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myArray)

        // Привяжем массив через адаптер к ListView
        listView.adapter = adapter

        // Прослушиваем нажатия клавиш
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_DOWN)
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    myArray.add(0, editText.text.toString())
                    adapter.notifyDataSetChanged()
                    editText.setText("")
                    return@OnKeyListener true
                }
            false
        })

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, itemClicked, position, id ->
            Toast.makeText(applicationContext, (itemClicked as TextView).text,
                           Toast.LENGTH_SHORT).show()
        }
    }
}
