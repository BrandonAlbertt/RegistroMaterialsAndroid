package com.example.diseo.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diseo.R
import com.example.diseo.entidad.Docente

class DocenteAdapter(private val docentes: List<Docente>) : RecyclerView.Adapter<DocenteAdapter.DocenteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocenteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_docente, parent, false)
        return DocenteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DocenteViewHolder, position: Int) {
        val docente = docentes[position]
        holder.nombreTextView.text = docente.nombreE
        holder.paternoTextView.text = docente.paternoE
        holder.maternoTextView.text = docente.maternoE
        // Aquí puedes agregar la lógica para cargar la imagen del docente
    }

    override fun getItemCount(): Int {
        return docentes.size
    }

    inner class DocenteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.nombreDocente)
        val paternoTextView: TextView = view.findViewById(R.id.paternoDocente)
        val maternoTextView: TextView = view.findViewById(R.id.maternoDocente)
        val imageView: ImageView = view.findViewById(R.id.imageDocente)
    }
}