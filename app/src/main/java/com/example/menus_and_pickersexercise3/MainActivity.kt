package com.example.menus_and_pickersexercise3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import com.example.menus_and_pickersexercise3.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { view: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
                    // Xử lý sự kiện khi người dùng chọn ngày
                    // Do month được tính bắt đầu từ 0 -> 11 nên muốn lấy chính xác tháng thì cần +1 vào month
                    val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1 }/$selectedYear"
                    Toast.makeText(this, "Selected date: $selectedDate", Toast.LENGTH_LONG).show()
                }, year, month, dayOfMonth
            )

            // Hiển thị DatePickerDialog
            datePickerDialog.show()
        }
    }
}