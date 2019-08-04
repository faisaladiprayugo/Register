package com.android.latihankotlin1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var namee: EditText? = null
    var genderr: Spinner? = null
    var emaill: EditText? = null
    var phonee: EditText? = null
    var addresss: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namee = findViewById(R.id.name)
        genderr = findViewById(R.id.gender)
        emaill = findViewById(R.id.email)
        phonee = findViewById(R.id.phone)
        addresss = findViewById(R.id.address)
        genderr = findViewById(R.id.gender)

        button.setOnClickListener {
            validasiInput()
        }
        setDataSpinner()
    }

    fun setDataSpinner() {
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderr?.adapter = adapter
    }

    fun validasiInput() {

        val namaInput = namee?.text.toString()
        val emailInput = emaill?.text.toString()
        val phoneInput = phonee?.text.toString()
        val addressInput = addresss?.text.toString()
        val genderInput = genderr?.selectedItem.toString()

        when{
            genderInput.equals("Pilih jenis kelamin") ->
                Toast.makeText(this, "Kelamin harus dipilih", Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> namee?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> emaill?.error = "Email tidak boleh kosong"
            phoneInput.isEmpty() -> phonee?.error = "Nomor HP tidak boleh kosong"
            addressInput.isEmpty() -> addresss?.error = "Alamat tidak boleh kosong"
        else -> {
            Toast.makeText(this, "Data masuk berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}}