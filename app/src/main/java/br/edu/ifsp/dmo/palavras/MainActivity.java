package br.edu.ifsp.dmo.palavras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifsp.dmo.palavras.view.LetrasAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private boolean linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = false;
        recyclerView = findViewById(R.id.recyclerview_letras);
        recyclerView.setAdapter(new LetrasAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alterarLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem trocarLayputButton = menu.findItem(R.id.trocar_layout);
        alterarIconeMenu(trocarLayputButton);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.trocar_layout){
            alterarLayout();
            alterarIconeMenu(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alterarLayout() {
        linearLayout = !linearLayout;
        if (linearLayout){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }
    }

    private void alterarIconeMenu(MenuItem itemMenu) {
        if (itemMenu != null){
            if (linearLayout){
                itemMenu.setIcon(getDrawable(R.drawable.ic_grid));
            }else {
                itemMenu.setIcon(getDrawable(R.drawable.ic_list));
            }
        }
    }
}