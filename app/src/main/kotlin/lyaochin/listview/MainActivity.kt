package lyaochin.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // получаем экземпляр элемента ListView
        val listView = findViewById(R.id.listView) as ListView

        //обращаемся к строковым ресурсам
        val catNames = resources.getStringArray(R.array.cat_names)

        // используем адаптер данных
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, catNames)
//
        listView.adapter = adapter
    }
}
