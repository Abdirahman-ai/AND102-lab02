package com.example.lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab02.EmailFetcher.Companion.getNext5Emails

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

        val loadMore = findViewById<Button>(R.id.loadMore);
        loadMore.setOnClickListener {
            val next5Emails = EmailFetcher.getNext5Emails();
            emailList += next5Emails;
            adapter.notifyDataSetChanged();
        }
    }
}