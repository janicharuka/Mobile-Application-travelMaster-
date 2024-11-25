package com.example.testing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<Task> taskList;

    public ToDoAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskText.setText(task.getTaskName());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        TextView taskText;

        public ToDoViewHolder(View itemView) {
            super(itemView);
            taskText = itemView.findViewById(android.R.id.text1);
        }
    }
}
