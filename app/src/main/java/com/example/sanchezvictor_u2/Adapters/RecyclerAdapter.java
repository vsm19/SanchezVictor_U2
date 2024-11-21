package com.example.sanchezvictor_u2.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanchezvictor_u2.Controllers.DetalleActivity;

import com.example.sanchezvictor_u2.Model.Explorador;
import com.example.sanchezvictor_u2.R;

import java.util.List;

import Utilidades.Utilidades;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>{
    private Context context;
    private androidx.appcompat.view.ActionMode mActionMode;
    private Explorador exp1;


    public RecyclerAdapter(List<Explorador> exploradores, Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        Explorador explorador = Utilidades.getExploradores().get(position);
        holder.txtViewDesc.setText(explorador.getDescripcionres());
        holder.txtViewTitle.setText(explorador.getNombre());
        holder.imgExplorador.setImageResource(explorador.getImagenId());
        holder.txtPlaneta.setText(explorador.getPlaneta());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetalleActivity.class);
                i.putExtra("IMAGEN", explorador.getImagenId());
                i.putExtra("PLANETA", explorador.getPlaneta());
                i.putExtra("INFO", explorador.getDescripcion());
                i.putExtra("NOMBRE", explorador.getNombre());
                context.startActivity(i);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                boolean res = false;
                if (mActionMode == null) {
                    mActionMode = ((AppCompatActivity) context).startSupportActionMode(mActionCallback);
                    exp1 = explorador;
                    res = true;
                }
                return res;
            }
        });
    }

    @Override
    public int getItemCount() {return Utilidades.getExploradores().size();}

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView imgExplorador;
        TextView txtViewTitle;
        TextView  txtViewDesc;
        TextView  txtPlaneta;

        //Todo 2.1.1 El constructor recibe como parámetro un tipo vista(itemView) que contiene la celda ya creada
        // a partir del layout correspondiente.
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imgExplorador  = (ImageView) itemView.findViewById(R.id.img_item);
            txtViewTitle = (TextView)  itemView.findViewById(R.id.txt_item_tittle);
            txtViewDesc  = (TextView)  itemView.findViewById(R.id.txt_item_desc);
            txtPlaneta = (TextView) itemView.findViewById(R.id.txt_item_planeta);

        }
    }

    private ActionMode.Callback mActionCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_eliminar, menu);
            mode.setTitle("Eliminar");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int itemId = item.getItemId();
            if (itemId == R.id.act_borrar) {
                AlertDialog alertDialog = createAlertDialog("Borrar", "Esta seguro que desea borrar a este explorador inocente?");
                alertDialog.show();
            }
            mode.finish();
            return true;
        }


        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    public AlertDialog createAlertDialog(String titulo, String mensaje){
        int index = Utilidades.getExploradores().indexOf(exp1);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensaje)
                .setTitle(titulo);
        builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(index>=0) {
                    Toast.makeText(context, "Borrado, explorador aniquilado", Toast.LENGTH_SHORT).show();
                    Utilidades.getExploradores().remove(index);
                    notifyItemRemoved(index);
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Cancelado, el explorador se mantiene inamovible", Toast.LENGTH_SHORT).show();
            }
        });

        // Todo 2.3 Una vez hemos añadido todas las configuraciones creamos el alertDialog. En este
        // Todo -> caso, devolvemos el objeto creado.
        return builder.create();
    }

}
