package com.zebrano.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zebrano.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // используем класс привязки к XML файлу
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        // указываем корень класса для отображения
        setContentView(bindingClass.root)

        // работаем с классом
        bindingClass.tvMain.text = getText(R.string.tvMain)
        bindingClass.tvMain.textSize = 24F
    }
}