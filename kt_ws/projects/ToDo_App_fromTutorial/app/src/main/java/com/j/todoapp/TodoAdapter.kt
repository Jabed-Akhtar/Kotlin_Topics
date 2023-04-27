/*
 ******************************************************************************
 * @file        : TodoAdapter.kt
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
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Class - TodoAdapter ========================================================
class TodoAdapter (
    private val todos: MutableList<Todo>
        ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteTodos() {
        todos.removeAll {todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvTodoTitle).text = curTodo.title
            findViewById<CheckBox>(R.id.cbDone).isChecked = curTodo.isChecked

            toggleStrikeThrough(findViewById<TextView>(R.id.tvTodoTitle), curTodo.isChecked)

            findViewById<CheckBox>(R.id.cbDone).setOnCheckedChangeListener {_, isChecked ->
                toggleStrikeThrough(findViewById<TextView>(R.id.tvTodoTitle), isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }
}


/* ##### END OF FILE ####################################################### */
