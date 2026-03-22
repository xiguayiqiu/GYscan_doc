package com.gyscan_doc.Windows;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.List;
import java.util.function.Consumer;

public class WindowsCommandAdapter extends RecyclerView.Adapter<WindowsCommandAdapter.ViewHolder> {

    private List<WindowsCommandPackage> packages;
    private Consumer<WindowsCommandPackage> onPackageClick;

    public WindowsCommandAdapter(List<WindowsCommandPackage> packages, Consumer<WindowsCommandPackage> onPackageClick) {
        this.packages = packages;
        this.onPackageClick = onPackageClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WindowsCommandPackage pkg = packages.get(position);
        holder.titleTextView.setText(pkg.getTitle());
        holder.descriptionTextView.setText(pkg.getDescription());
        
        holder.itemView.setOnClickListener(v -> {
            if (onPackageClick != null) {
                onPackageClick.accept(pkg);
            }
        });
    }

    @Override
    public int getItemCount() {
        return packages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.packageTitle);
            descriptionTextView = itemView.findViewById(R.id.packageDescription);
        }
    }
}