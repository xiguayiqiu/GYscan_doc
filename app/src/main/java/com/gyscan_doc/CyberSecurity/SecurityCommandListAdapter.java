package com.gyscan_doc.CyberSecurity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.List;

public class SecurityCommandListAdapter extends RecyclerView.Adapter<SecurityCommandListAdapter.CommandViewHolder> {

    private List<SecurityCommandItem> commands;
    private OnCommandClickListener listener;

    public interface OnCommandClickListener {
        void onCommandClick(SecurityCommandItem command);
    }

    public SecurityCommandListAdapter(List<SecurityCommandItem> commands, OnCommandClickListener listener) {
        this.commands = commands;
        this.listener = listener;
    }

    @Override
    public CommandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_command, parent, false);
        return new CommandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommandViewHolder holder, int position) {
        SecurityCommandItem command = commands.get(position);
        holder.bind(command);
    }

    @Override
    public int getItemCount() {
        return commands.size();
    }

    class CommandViewHolder extends RecyclerView.ViewHolder {
        private TextView commandNameTextView;
        private TextView commandDescriptionTextView;

        public CommandViewHolder(View itemView) {
            super(itemView);
            commandNameTextView = itemView.findViewById(R.id.commandName);
            commandDescriptionTextView = itemView.findViewById(R.id.commandDescription);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onCommandClick(commands.get(position));
                }
            });
        }

        public void bind(SecurityCommandItem command) {
            commandNameTextView.setText(command.getName());
            commandDescriptionTextView.setText(command.getDescription());
        }
    }
}