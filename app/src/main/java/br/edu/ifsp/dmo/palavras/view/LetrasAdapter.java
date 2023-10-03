package br.edu.ifsp.dmo.palavras.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmo.palavras.R;

public class LetrasAdapter extends RecyclerView.Adapter<LetrasAdapter.ViewHolder> {
    private Context context;

    private List<Character> letras;

    public LetrasAdapter(Context context) {
        this.context = context;

        letras = new ArrayList<>(23);
        for(char c = 'a'; c<= 'z'; c++){
            letras.add(c);
        }
    }

    @NonNull
    @Override
    public LetrasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LetrasAdapter.ViewHolder holder, int position) {
        holder.itemButton.setText(letras.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return letras.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button itemButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemButton = itemView.findViewById(R.id.button_item);
        }
    }
}
