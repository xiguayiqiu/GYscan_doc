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

public class WindowsCommandListAdapter extends RecyclerView.Adapter<WindowsCommandListAdapter.ViewHolder> {

    private List<WindowsCommandItem> commands;
    private Consumer<WindowsCommandItem> onCommandClick;

    public WindowsCommandListAdapter(List<WindowsCommandItem> commands, Consumer<WindowsCommandItem> onCommandClick) {
        this.commands = commands;
        this.onCommandClick = onCommandClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_command, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WindowsCommandItem command = commands.get(position);
        holder.commandName.setText(command.getName());
        holder.commandDescription.setText(command.getDescription());
        
        holder.itemView.setOnClickListener(v -> {
            if (onCommandClick != null) {
                onCommandClick.accept(command);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commands.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView commandName;
        TextView commandDescription;

        ViewHolder(View itemView) {
            super(itemView);
            commandName = itemView.findViewById(R.id.commandName);
            commandDescription = itemView.findViewById(R.id.commandDescription);
        }
    }
}