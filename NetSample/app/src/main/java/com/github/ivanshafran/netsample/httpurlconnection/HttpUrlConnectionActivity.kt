package com.github.ivanshafran.netsample.httpurlconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.github.ivanshafran.netsample.R
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnectionActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_url_connection)

        val textView = findViewById<TextView>(R.id.http_url_connection_result)
        textView.movementMethod = ScrollingMovementMethod()
        scope.launch {
            textView.text = "Loading..."
            val result = load()
            textView.text = result
        }
    }

    private suspend fun load(): String = withContext(Dispatchers.IO) {
        val url = URL("https://api.stackexchange.com/2.2/questions?page=1&pagesize=100&order=asc&sort=creation&tagged=Android&site=stackoverflow")
        val connection = url.openConnection() as HttpURLConnection? ?: return@withContext ""
        try {
            connection.requestMethod = "GET"

            connection.inputStream.bufferedReader().use { reader ->
                val builder = StringBuilder()
                var line: String? = reader.readLine()
                while (line != null) {
                    builder.append(line)
                    line = reader.readLine()
                }

                return@withContext builder.toString()
            }
        } finally {
            connection.disconnect()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
