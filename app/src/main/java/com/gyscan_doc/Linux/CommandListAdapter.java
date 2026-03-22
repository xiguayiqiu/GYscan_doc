package com.gyscan_doc.Linux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.List;
import java.util.function.Consumer;

public class CommandListAdapter extends RecyclerView.Adapter<CommandListAdapter.ViewHolder> {

    private List<CommandItem> commands;
    private Consumer<CommandItem> onCommandClick;

    public CommandListAdapter(List<CommandItem> commands, Consumer<CommandItem> onCommandClick) {
        this.commands = commands;
        this.onCommandClick = onCommandClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_command_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommandItem command = commands.get(position);
        holder.commandTextView.setText(command.getName());
        holder.descriptionTextView.setText(command.getDescription());
        
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
        TextView commandTextView;
        TextView descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            commandTextView = itemView.findViewById(R.id.commandName);
            descriptionTextView = itemView.findViewById(R.id.commandDescription);
        }
    }
}