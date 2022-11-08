package com.zebrano.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.zebrano.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // используем класс привязки к XML файлу
        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        // Выключаем ночной режим
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // указываем корень класса для отображения
        setContentView(bindingClass.root)

        // работаем с классом
        bindingClass.tvMain.text = getText(R.string.tvMain) // имя приложения
        bindingClass.tvMain.textSize = 24F
        bindingClass.bAction.isAllCaps = false // Выключаем ВОТ ТАКОЕ

        val tiEditText = bindingClass.textInputLayout.editText
        val editTextpn = bindingClass.editTextTextPersonName

        // очистка текста
        editTextpn.setText(String())

        // слушатель кнопки
        bindingClass.bAction.setOnClickListener {
            // играемся с видимостью
            if (bindingClass.tvMain.visibility == View.VISIBLE)
                bindingClass.tvMain.visibility = View.INVISIBLE
            else
                bindingClass.tvMain.visibility = View.VISIBLE
            // новая строка конкатенации
            val str = editTextpn.text.toString()+tiEditText?.text.toString()
            // применение новой строки
            editTextpn.setText(str)
            Log.d("AppLog","Button pushed!")

        }

    }
}