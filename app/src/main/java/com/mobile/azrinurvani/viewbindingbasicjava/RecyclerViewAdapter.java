package com.mobile.azrinurvani.viewbindingbasicjava;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.viewbindingbasicjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<String> movieList = new ArrayList<String>();


    public void updateMovie(List<String>movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        if (movieList.size()>0){
            return movieList.size();
        }else{
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      /*  public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }*/

        RecyclerRowBinding recyclerRowBinding;

        public ViewHolder(@NonNull RecyclerRowBinding recyclerRowBinding){
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;

            this.recyclerRowBinding.txtMovieTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("ViewHolder","adapter position : "+getAdapterPosition());
                    Toast.makeText(view.getContext(), "adapter position :" +getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void bindView(String movieName){
            recyclerRowBinding.txtMovieTitle.setText(movieName);
        }
    }
}
