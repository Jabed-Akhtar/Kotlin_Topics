/*
 ******************************************************************************
 * @file        : MainActivity.kt
 * @brief       : ...
 *****************************************************************************
 * @author      : Jabed-Akhtar (Github)
 * @date        : 27.04.2023
 *****************************************************************************
 * Description:
 * 	- a source within this script: ...
 ******************************************************************************
 */

package com.j.todoapp

// Imports ====================================================================
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// Class - MainActivity =======================================================
class MainActivity : AppCompatActivity() {

    /* *************** Variables *************** */
    private lateinit var todoAdapter: TodoAdapter

    /* *************** onCreate function *************** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        findViewById<RecyclerView>(R.id.rvTodoItems).adapter = todoAdapter
        findViewById<RecyclerView>(R.id.rvTodoItems).layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btAddTodo).setOnClickListener{
            val todoTitle = findViewById<EditText>(R.id.etTodoTitle).text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                findViewById<EditText>(R.id.etTodoTitle).text.clear()
            }
        }

        findViewById<Button>(R.id.btDelTodo).setOnClickListener{
            todoAdapter.deleteTodos()
        }
    }
}

/* ##### END OF FILE ####################################################### */
