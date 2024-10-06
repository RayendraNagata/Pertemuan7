package com.example.pertemuan7

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_add)

        val editTextTaskTitle = findViewById<EditText>(R.id.editTextTaskTitle)
        val spinnerRepeat = findViewById<Spinner>(R.id.spinnerRepeat)
        val buttonDatePicker = findViewById<Button>(R.id.buttonDatePicker)
        val editTextHour = findViewById<EditText>(R.id.editTextHour)
        val editTextMinute = findViewById<EditText>(R.id.editTextMinute)
        val editTextSecond = findViewById<EditText>(R.id.editTextSecond)
        val buttonSaveTask = findViewById<Button>(R.id.buttonSaveTask)
        val textViewDate = findViewById<TextView>(R.id.textViewDate)

        // DatePicker Dialog untuk pemilihan tanggal
        buttonDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    textViewDate.text = selectedDate
                }, year, month, day)

            datePickerDialog.show()
        }

        // Tambahkan AlertDialog untuk konfirmasi penambahan task
        buttonSaveTask.setOnClickListener {
            val taskTitle = editTextTaskTitle.text.toString()
            val repeatOption = spinnerRepeat.selectedItem.toString()
            val hour = editTextHour.text.toString()
            val minute = editTextMinute.text.toString()
            val second = editTextSecond.text.toString()
            val date = textViewDate.text.toString()

            if (taskTitle.isNotEmpty() && date != "Date") {
                // Menampilkan dialog konfirmasi
                val builder = AlertDialog.Builder(this)
                builder.setTitle("SimpliRemind")
                builder.setMessage("Do you want to add this as a new task?")

                // Tombol "Yes" pada dialog
                builder.setPositiveButton("Yes") { dialog, which ->
                    // Simpan task (logika simpan di sini)
                    Toast.makeText(this, "Task: $taskTitle\nTime: $hour:$minute:$second\nDate: $date\nRepeat: $repeatOption", Toast.LENGTH_LONG).show()
                }

                // Tombol "No" untuk membatalkan
                builder.setNegativeButton("No") { dialog, which ->
                    dialog.dismiss()
                }

                // Menampilkan dialog
                val dialog: AlertDialog = builder.create()
                dialog.show()

            } else {
                // Tampilkan pesan error jika field belum terisi lengkap
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
