package br.edu.ifsp.dmo.palavras.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmo.palavras.R;
import br.edu.ifsp.dmo.palavras.model.Constants;

public class PalavrasAdapter extends RecyclerView.Adapter<PalavrasAdapter.ViewHolder> {
    private Context context;
    private List<String> palavras;

    public PalavrasAdapter(Context context, String letraId) {
        this.context = context;
        palavras = new ArrayList<>();

        String todas[] = context.getResources().getStringArray(R.array.palavras);

        for (String s : todas){
            if (s.startsWith(letraId)){
                palavras.add(s);
            }
        }
    }

    @NonNull
    @Override
    public PalavrasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PalavrasAdapter.ViewHolder holder, int position) {
        holder.palavraButton.setText(palavras.get(position));
        holder.palavraButton.setOnClickListener(v -> abrirNavegador(position));
    }

    private void abrirNavegador(int position) {
        Uri query = Uri.parse(Constants.SEARCH_PREFIX + palavras.get(position));
        Intent intent = new Intent(Intent.ACTION_VIEW, query);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return palavras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button palavraButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            palavraButton = itemView.findViewById(R.id.button_item);
        }
    }
}
