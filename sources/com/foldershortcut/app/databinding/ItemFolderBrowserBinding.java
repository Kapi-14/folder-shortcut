package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;

/* loaded from: classes2.dex */
public final class ItemFolderBrowserBinding implements ViewBinding {
    public final ImageView imgFolderIcon;
    private final LinearLayout rootView;
    public final TextView txtFolderDetails;
    public final TextView txtFolderName;

    private ItemFolderBrowserBinding(LinearLayout rootView, ImageView imgFolderIcon, TextView txtFolderDetails, TextView txtFolderName) {
        this.rootView = rootView;
        this.imgFolderIcon = imgFolderIcon;
        this.txtFolderDetails = txtFolderDetails;
        this.txtFolderName = txtFolderName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFolderBrowserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemFolderBrowserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_folder_browser, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemFolderBrowserBinding bind(View rootView) {
        int id = R.id.imgFolderIcon;
        ImageView imgFolderIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (imgFolderIcon != null) {
            id = R.id.txtFolderDetails;
            TextView txtFolderDetails = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (txtFolderDetails != null) {
                id = R.id.txtFolderName;
                TextView txtFolderName = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (txtFolderName != null) {
                    return new ItemFolderBrowserBinding((LinearLayout) rootView, imgFolderIcon, txtFolderDetails, txtFolderName);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
