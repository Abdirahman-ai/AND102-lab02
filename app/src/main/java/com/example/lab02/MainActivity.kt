package com.example.lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emailList: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.emailsRv);
        emailList = EmailFetcher.getEmails();
        val adapter = EmailAdapter(emailList);
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}