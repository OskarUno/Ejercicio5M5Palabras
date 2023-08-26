package com.awakelab.oskar.ejercicio5m5palabras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awakelab.oskar.ejercicio5m5palabras.databinding.ItemBinding;

import java.util.List;

public class AdapterWords extends RecyclerView.Adapter<AdapterWords.ViewHolder> {
    private List<String> words;

    @NonNull
    @Override
    public AdapterWords.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWords.ViewHolder holder, int position) {
        String item = words.get(position);
        holder.showInformation(item);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setData(List<String> data) {
        this.words = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener {
        private ItemBinding itemBinding;

        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
            itemView.setOnClickListener(this);
        }

        public void showInformation(String words) {
            itemBinding.textView.setText(words);
        }

        @Override
        public void onClick(View v) {
           String elemento = (String) itemBinding.textView.getText();
            Toast.makeText(itemView.getContext(), "Seleccionó" + elemento, Toast.LENGTH_SHORT).show();
        }
    }
}