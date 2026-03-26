package com.gyscan_doc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import com.gyscan_doc.model.DrawerItem;
import java.util.ArrayList;
import java.util.List;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    private Context context;
    private List<DrawerItem> drawerItems;
    private OnItemClickListener onItemClickListener;
    private List<DrawerItem> originalItems;

    public interface OnItemClickListener {
        void onItemClick(int itemId);
    }

    public DrawerAdapter(Context context, List<DrawerItem> drawerItems, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.originalItems = buildDrawerItems();
        this.drawerItems = drawerItems;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == DrawerItem.TYPE_CATEGORY) {
            view = LayoutInflater.from(context).inflate(R.layout.drawer_item_category, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.drawer_item, parent, false);
        }
        return new DrawerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        DrawerItem item = drawerItems.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getIconRes());
        // 将图标颜色设置为白色
        holder.icon.setColorFilter(android.graphics.Color.WHITE);

        if (item.getType() == DrawerItem.TYPE_CATEGORY) {
            // 分类项处理
            holder.arrow.setVisibility(View.VISIBLE);
            if (item.isExpanded()) {
                holder.arrow.setRotation(90);
            } else {
                holder.arrow.setRotation(0);
            }

            holder.itemView.setOnClickListener(v -> {
                // 添加Q弹动画
                v.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(100)
                    .withEndAction(() -> {
                        v.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(100)
                            .start();
                        
                        // 找到原始列表中对应的分类项并更新其展开状态
                        for (DrawerItem originalItem : originalItems) {
                            if (originalItem.getId() == item.getId()) {
                                boolean wasExpanded = originalItem.isExpanded();
                                originalItem.setExpanded(!wasExpanded);
                                
                                // 同时更新当前item的展开状态
                                item.setExpanded(!wasExpanded);
                                
                                // 计算插入或删除的位置
                                int currentPosition = drawerItems.indexOf(item);
                                if (currentPosition != -1) {
                                    if (!wasExpanded) {
                                        // 展开：添加子菜单项
                                        List<DrawerItem> children = originalItem.getChildren();
                                        if (children != null && !children.isEmpty()) {
                                            // 手动添加子菜单项到drawerItems
                                            for (int i = 0; i < children.size(); i++) {
                                                drawerItems.add(currentPosition + 1 + i, children.get(i));
                                            }
                                            // 通知RecyclerView有新项插入
                                            notifyItemRangeInserted(currentPosition + 1, children.size());
                                        }
                                    } else {
                                        // 收起：移除子菜单项
                                        List<DrawerItem> children = originalItem.getChildren();
                                        if (children != null && !children.isEmpty()) {
                                            // 计算需要移除的子菜单项数量
                                            int childCount = children.size();
                                            // 手动从drawerItems中移除子菜单项
                                            for (int i = 0; i < childCount; i++) {
                                                if (currentPosition + 1 < drawerItems.size()) {
                                                    drawerItems.remove(currentPosition + 1);
                                                }
                                            }
                                            // 通知RecyclerView有项被移除
                                            notifyItemRangeRemoved(currentPosition + 1, childCount);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    })
                    .start();
            });
        } else {
            // 普通项处理
            holder.arrow.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item.getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return drawerItems.get(position).getType();
    }

    // 构建可展开的菜单项列表
    public static List<DrawerItem> buildDrawerItems() {
        List<DrawerItem> items = new ArrayList<>();

        // 网络安全分类
        List<DrawerItem> securityItems = new ArrayList<>();
        securityItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "网络安全基础", R.drawable.ic_security, R.id.nav_security_basics));
        securityItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "白帽安全工程师技能", R.drawable.ic_security, R.id.nav_security_overview));
        securityItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "网络安全高级技巧", R.drawable.ic_security, R.id.nav_security_advanced));
        items.add(new DrawerItem(DrawerItem.TYPE_CATEGORY, "网络安全", R.drawable.ic_security, R.id.nav_security_category, securityItems));

        // 命令手册分类
        List<DrawerItem> commandsItems = new ArrayList<>();
        commandsItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "Linux自带命令手册", R.drawable.ic_terminal, R.id.nav_linux_commands));
        commandsItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "Windows命令手册", R.drawable.ic_windows, R.id.nav_windows_commands));
        commandsItems.add(new DrawerItem(DrawerItem.TYPE_ITEM, "Linux常用网安工具命令手册", R.drawable.ic_tools, R.id.nav_linux_tools));
        items.add(new DrawerItem(DrawerItem.TYPE_CATEGORY, "命令手册", R.drawable.ic_terminal, R.id.nav_commands_category, commandsItems));

        // 其他项
        items.add(new DrawerItem(DrawerItem.TYPE_ITEM, "相关项目", R.drawable.ic_projects, R.id.nav_related_projects));
        items.add(new DrawerItem(DrawerItem.TYPE_ITEM, "关于", R.drawable.ic_info, R.id.nav_about));

        return items;
    }

    // 获取扁平化的菜单项列表（用于显示）
    public static List<DrawerItem> getFlattenedItems(List<DrawerItem> items) {
        List<DrawerItem> flattenedItems = new ArrayList<>();
        for (DrawerItem item : items) {
            flattenedItems.add(item);
            if (item.getType() == DrawerItem.TYPE_CATEGORY && item.isExpanded() && item.getChildren() != null) {
                flattenedItems.addAll(item.getChildren());
            }
        }
        return flattenedItems;
    }

    public void updateItems(List<DrawerItem> items) {
        this.drawerItems = items;
        // 使用notifyDataSetChanged()会立即更新整个列表，没有动画效果
        // 为了实现展开/收起的动画效果，我们可以使用自定义动画
        notifyDataSetChanged();
    }

    class DrawerViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        ImageView arrow;

        DrawerViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}