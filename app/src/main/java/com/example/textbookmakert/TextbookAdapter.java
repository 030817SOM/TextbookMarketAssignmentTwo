package com.example.textbookmakert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder> {

    private List<Textbook> textbooks;
    private List<Textbook> fullList;

    public TextbookAdapter(List<Textbook> textbooks) {
        this.textbooks = textbooks;
        this.fullList = new ArrayList<>(textbooks);
    }

    @NonNull
    @Override
    public TextbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_textbook, parent, false);
        return new TextbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextbookViewHolder holder, int position) {
        Textbook book = textbooks.get(position);
        holder.tvTitle.setText("Title: " + book.getTitle());
        holder.tvSeller.setText("Seller: " + book.getSellerName());
        holder.tvCopies.setText("Copies: " + book.getCopies());
        holder.tvPrice.setText("Price: $" + book.getPrice());
    }

    @Override
    public int getItemCount() {
        return textbooks.size();
    }

    public void filter(String query) {
        textbooks.clear();
        if (query == null || query.trim().isEmpty()) {
            textbooks.addAll(fullList);
        } else {
            String lowerQuery = query.toLowerCase();
            for (Textbook book : fullList) {
                if (book.getTitle().toLowerCase().contains(lowerQuery) ||
                        book.getSellerName().toLowerCase().contains(lowerQuery)) {
                    textbooks.add(book);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class TextbookViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSeller, tvPrice, tvCopies;

        public TextbookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSeller = itemView.findViewById(R.id.tvSeller);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCopies = itemView.findViewById(R.id.tvCopies);
        }
    }
}
