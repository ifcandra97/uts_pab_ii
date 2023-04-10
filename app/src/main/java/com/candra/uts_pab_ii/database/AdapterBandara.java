package com.candra.uts_pab_ii.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.candra.uts_pab_ii.R;

import java.util.ArrayList;

public class AdapterBandara extends RecyclerView.Adapter<AdapterBandara.ViewHolderBandara>
{
    private Context ctx;
    private ArrayList arrId, arrNama, arrKota, arrAlamat;

    public AdapterBandara(Context ctx, ArrayList arrId, ArrayList arrNama, ArrayList arrKota, ArrayList arrAlamat) {
        this.ctx = ctx;
        this.arrId = arrId;
        this.arrNama = arrNama;
        this.arrKota = arrKota;
        this.arrAlamat = arrAlamat;
    }

    @NonNull
    @Override
    public ViewHolderBandara onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(ctx).inflate(R.layout.list_item_bandara, parent, false);
        return new ViewHolderBandara(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBandara.ViewHolderBandara holder, int position)
    {
        holder.tvId.setText(arrId.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvKota.setText(arrKota.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
    }

    @Override
    public int getItemCount()
    {
        if(arrId.size() == 0)
        {
            return 0;
        }
        else {
            return arrId.size();
        }
    }

    public class ViewHolderBandara extends RecyclerView.ViewHolder
    {
        private TextView tvId, tvNama, tvKota, tvAlamat;
        public ViewHolderBandara(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_Id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKota = itemView.findViewById(R.id.tv_kota);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);

        }
    }
}
