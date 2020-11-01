package com.jhao.playdemo.applications;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhao.playdemo.R;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/4/23
 * @describe
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {

    private List<AppInfo> mAppInfoList;
    private Context mContext;
    private PackageManager mPackageManager;

    public AppAdapter(Context context, List<AppInfo> appInfoList) {
        mContext = context;
        mAppInfoList = appInfoList;
        mPackageManager = mContext.getPackageManager();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.ivAppIcon.setImageDrawable(mAppInfoList.get(position).icon);
        holder.tvAppTitle.setText(mAppInfoList.get(position).name);
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mAppInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        protected ImageView ivAppIcon;
        protected TextView tvAppTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAppIcon = itemView.findViewById(R.id.ItemImage);
            tvAppTitle = itemView.findViewById(R.id.ItemTitle);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int postation);
    }
}
