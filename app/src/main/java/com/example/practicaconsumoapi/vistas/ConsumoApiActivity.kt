package com.example.practicaconsumoapi.vistas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.practicaconsumoapi.Entidades.Persona
import com.example.practicaconsumoapi.MenuActivity
import com.example.practicaconsumoapi.R
import com.example.practicaconsumoapi.RetrofitClient
import com.example.practicaconsumoapi.databinding.ActivityConsumoApiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsumoApiActivity  : AppCompatActivity() {

    lateinit var binding: ActivityConsumoApiBinding
    var direccion: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumoApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retroftiTraer = RetrofitClient.consumirApi.obtenerPersona()

        retroftiTraer.enqueue(object : Callback<Persona> {
            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                binding.name.text = response.body()?.results!![0].name.first
                binding.correo.text = response.body()?.results!![0].email
                binding.fechanacimiento.text = response.body()?.results!![0].dob.date
                direccion = "${response.body()?.results!![0].location.street.name}, num ${response.body()?.results!![0].location.street.number}, ${response.body()?.results!![0].location.city} cp ${response.body()?.results!![0].location.postcode}, ${response.body()?.results!![0].location.state}, ${response.body()?.results!![0].location.country}"
                binding.direccion.text = direccion
                binding.telefono.text = response.body()?.results!![0].phone
                binding.contrasena.text  = response.body()?.results!![0].login.password

            }

            override fun onFailure(call: Call<Persona>, t: Throwable) {
                Toast.makeText(this@ConsumoApiActivity, "Error al consultar Api Rest", Toast.LENGTH_SHORT).show()
            }

        })

        val btnActualizar = findViewById<AppCompatButton>(R.id.btnActualizar)
        btnActualizar.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }
    }

}