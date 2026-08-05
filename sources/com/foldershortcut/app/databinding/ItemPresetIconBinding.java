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
public final class ItemPresetIconBinding implements ViewBinding {
    public final ImageView imgPresetIcon;
    public final LinearLayout presetContainer;
    private final LinearLayout rootView;
    public final TextView txtPresetName;

    private ItemPresetIconBinding(LinearLayout rootView, ImageView imgPresetIcon, LinearLayout presetContainer, TextView txtPresetName) {
        this.rootView = rootView;
        this.imgPresetIcon = imgPresetIcon;
        this.presetContainer = presetContainer;
        this.txtPresetName = txtPresetName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPresetIconBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemPresetIconBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_preset_icon, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemPresetIconBinding bind(View rootView) {
        int id = R.id.imgPresetIcon;
        ImageView imgPresetIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (imgPresetIcon != null) {
            LinearLayout presetContainer = (LinearLayout) rootView;
            id = R.id.txtPresetName;
            TextView txtPresetName = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (txtPresetName != null) {
                return new ItemPresetIconBinding((LinearLayout) rootView, imgPresetIcon, presetContainer, txtPresetName);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
