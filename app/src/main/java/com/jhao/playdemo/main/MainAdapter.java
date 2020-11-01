package com.jhao.playdemo.main;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhao.playdemo.R;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/11/1
 * @describe
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<String> btnLabels;
    private Context mContext;

    public MainAdapter(Context context, List<String> btnLabels) {
        this.btnLabels = btnLabels;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_optiongs, null);
        view.setOnClickListener(v -> {
            if (mOnItemClickedListener != null) {
                mOnItemClickedListener.onItemClick(v, (Integer) v.getTag());
            }
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.mButton.setText(btnLabels.get(position));
    }

    @Override
    public int getItemCount() {
        return btnLabels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private Button mButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btn);
        }
    }

    private OnItemClickedListener mOnItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        mOnItemClickedListener = onItemClickedListener;
    }

    public interface OnItemClickedListener {
        /**
         * @param view
         * @param pos
         */
        void onItemClick(View view, int pos);
    }
}

