package com.example.pokedex.RecyclersContainers;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.RecyclersContainers.OptionInfo;

import java.util.List;
public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder> {
    private List<OptionInfo> opciones;
    public OptionAdapter(List<OptionInfo> opciones) {
        this.opciones = opciones;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_app_option, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OptionInfo opcion = opciones.get(position);
        holder.bind(opcion);
    }
    @Override
    public int getItemCount() {
        return opciones.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloTextView;
        private ImageView imagenImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.titleOptionID);
            imagenImageView = itemView.findViewById(R.id.ImageOptionID);
        }
        public void bind(OptionInfo opcion) {
            tituloTextView.setText(opcion.getTitulo());
            imagenImageView.setImageResource(opcion.getImagen());
        }
    }
}
