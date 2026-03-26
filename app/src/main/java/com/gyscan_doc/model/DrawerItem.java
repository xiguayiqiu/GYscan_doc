package com.gyscan_doc.model;

import java.util.List;

public class DrawerItem {
    public static final int TYPE_CATEGORY = 0;
    public static final int TYPE_ITEM = 1;

    private int type;
    private String title;
    private int iconRes;
    private int id;
    private boolean isExpanded;
    private List<DrawerItem> children;

    public DrawerItem(int type, String title, int iconRes, int id) {
        this.type = type;
        this.title = title;
        this.iconRes = iconRes;
        this.id = id;
        this.isExpanded = false;
    }

    public DrawerItem(int type, String title, int iconRes, int id, List<DrawerItem> children) {
        this.type = type;
        this.title = title;
        this.iconRes = iconRes;
        this.id = id;
        this.isExpanded = false;
        this.children = children;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getIconRes() {
        return iconRes;
    }

    public int getId() {
        return id;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public List<DrawerItem> getChildren() {
        return children;
    }

    public void setChildren(List<DrawerItem> children) {
        this.children = children;
    }
}