package com.gyscan_doc.CyberSecurity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.List;

public class SecurityPackageAdapter extends RecyclerView.Adapter<SecurityPackageAdapter.PackageViewHolder> {

    private List<SecurityPackage> packages;
    private OnPackageClickListener listener;

    public interface OnPackageClickListener {
        void onPackageClick(SecurityPackage pkg);
    }

    public SecurityPackageAdapter(List<SecurityPackage> packages, OnPackageClickListener listener) {
        this.packages = packages;
        this.listener = listener;
    }

    @Override
    public PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package_card, parent, false);
        return new PackageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackageViewHolder holder, int position) {
        SecurityPackage pkg = packages.get(position);
        holder.bind(pkg);
    }

    @Override
    public int getItemCount() {
        return packages.size();
    }

    class PackageViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;

        public PackageViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.packageTitle);
            descriptionTextView = itemView.findViewById(R.id.packageDescription);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onPackageClick(packages.get(position));
                }
            });
        }

        public void bind(SecurityPackage pkg) {
            titleTextView.setText(pkg.getTitle());
            descriptionTextView.setText(pkg.getDescription());
        }
    }
}