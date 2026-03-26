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

public class WindowsPackageAdapter extends RecyclerView.Adapter<WindowsPackageAdapter.ViewHolder> {

    private List<WindowsCommandPackage> packages;
    private Consumer<WindowsCommandPackage> onPackageClick;

    public WindowsPackageAdapter(List<WindowsCommandPackage> packages, Consumer<WindowsCommandPackage> onPackageClick) {
        this.packages = packages;
        this.onPackageClick = onPackageClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WindowsCommandPackage pkg = packages.get(position);
        holder.title.setText(pkg.getTitle());
        holder.description.setText(pkg.getDescription());
        
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

    private int getIconResId(String iconName) {
        switch (iconName) {
            case "file":
                return R.drawable.ic_library;
            case "system":
                return R.drawable.ic_terminal;
            case "disk":
                return R.drawable.ic_tools;
            case "network":
                return R.drawable.ic_security;
            case "registry":
                return R.drawable.ic_terminal;
            case "security":
                return R.drawable.ic_security;
            case "batch":
                return R.drawable.ic_tools;
            case "tools":
                return R.drawable.ic_tools;
            default:
                return R.drawable.ic_tools;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.packageTitle);
            description = itemView.findViewById(R.id.packageDescription);
        }
    }
}