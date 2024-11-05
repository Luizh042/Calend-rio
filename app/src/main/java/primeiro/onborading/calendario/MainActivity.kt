package primeiro.onborading.calendario

import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.AppComponentFactory
import primeiro.onborading.calendario.ui.theme.CalendarioTheme
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val emptyMessageTextView = findViewById<TextView>(R.id.emptyMessageTextView)
        val addExerciseButton = findViewById<MaterialButton>(R.id.addExerciseButton)

        val dateFormatter = SimpleDateFormat("dd/MM/yyyy",Locale.getDefault())

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val selectedDate = dateFormatter.format(calendar.time)

            val hasExercise = checkForExercises(selectedDate)

            if (hasExercise) {
                emptyMessageTextView.text = "Exercício programado para $selectedDate."
            } else {
                emptyMessageTextView.text = "Nenhum exercício para o dia selecionado."
            }
        }

        addExerciseButton.setOnClickListener {
            Toast.makeText(this, "Função para adicionar exercício em breve", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkForExercises(date: String): Boolean {
        return date == "25/12/2024"
    }
}
