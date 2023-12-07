package com.example.rumahadatapps

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvRumahAdat: RecyclerView

    private val list = ArrayList<RumahAdat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRumahAdat = findViewById(R.id.rv_rumah_adat)
        rvRumahAdat.setHasFixedSize(true)

        list.addAll(getListRumahAdat())
        showRvList()
    }

    private fun getListRumahAdat(): ArrayList<RumahAdat> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataOrigin = resources.getStringArray(R.array.data_origin)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSource = resources.getStringArray(R.array.data_source)
        val dataImage1 = resources.getStringArray(R.array.data_image1)
        val dataImage2 = resources.getStringArray(R.array.data_image2)
        val dataImage3 = resources.getStringArray(R.array.data_image3)
        val philosophy = resources.getStringArray(R.array.data_philosophy)

        val listRumahAdat = ArrayList<RumahAdat>()

        for (i in dataName.indices){
            val rumahAdat = RumahAdat(dataName[i], dataOrigin[i], dataDescription[i], dataPhoto.getResourceId(i, -1),
                            dataSource[i], dataImage1[i], dataImage2[i], dataImage3[i], philosophy[i])
            listRumahAdat.add(rumahAdat)
        }

        return listRumahAdat
    }

    private fun showRvList() {
        rvRumahAdat.layoutManager = LinearLayoutManager(this)
        rvRumahAdat.adapter = RumahAdatAdapter(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                val moveToAboutActivity = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveToAboutActivity)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}