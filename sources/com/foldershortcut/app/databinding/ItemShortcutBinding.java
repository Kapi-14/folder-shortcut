package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;

/* loaded from: classes2.dex */
public final class ItemShortcutBinding implements ViewBinding {
    public final ImageButton btnDeleteShortcut;
    public final ImageButton btnEditShortcut;
    public final ImageButton btnPinShortcut;
    public final ImageView imgShortcutIcon;
    private final LinearLayout rootView;
    public final TextView txtShortcutLabel;
    public final TextView txtShortcutPath;

    private ItemShortcutBinding(LinearLayout rootView, ImageButton btnDeleteShortcut, ImageButton btnEditShortcut, ImageButton btnPinShortcut, ImageView imgShortcutIcon, TextView txtShortcutLabel, TextView txtShortcutPath) {
        this.rootView = rootView;
        this.btnDeleteShortcut = btnDeleteShortcut;
        this.btnEditShortcut = btnEditShortcut;
        this.btnPinShortcut = btnPinShortcut;
        this.imgShortcutIcon = imgShortcutIcon;
        this.txtShortcutLabel = txtShortcutLabel;
        this.txtShortcutPath = txtShortcutPath;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemShortcutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemShortcutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shortcut, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemShortcutBinding bind(View rootView) {
        int id = R.id.btnDeleteShortcut;
        ImageButton btnDeleteShortcut = (ImageButton) ViewBindings.findChildViewById(rootView, id);
        if (btnDeleteShortcut != null) {
            id = R.id.btnEditShortcut;
            ImageButton btnEditShortcut = (ImageButton) ViewBindings.findChildViewById(rootView, id);
            if (btnEditShortcut != null) {
                id = R.id.btnPinShortcut;
                ImageButton btnPinShortcut = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                if (btnPinShortcut != null) {
                    id = R.id.imgShortcutIcon;
                    ImageView imgShortcutIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (imgShortcutIcon != null) {
                        id = R.id.txtShortcutLabel;
                        TextView txtShortcutLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (txtShortcutLabel != null) {
                            id = R.id.txtShortcutPath;
                            TextView txtShortcutPath = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (txtShortcutPath != null) {
                                return new ItemShortcutBinding((LinearLayout) rootView, btnDeleteShortcut, btnEditShortcut, btnPinShortcut, imgShortcutIcon, txtShortcutLabel, txtShortcutPath);
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
