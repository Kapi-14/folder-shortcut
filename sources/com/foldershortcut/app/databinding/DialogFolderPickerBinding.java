package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes2.dex */
public final class DialogFolderPickerBinding implements ViewBinding {
    public final MaterialButton btnCancelPicker;
    public final MaterialButton btnSelectCurrentFolder;
    public final ImageButton btnUpLevel;
    public final RecyclerView recyclerFolderTree;
    private final LinearLayout rootView;
    public final TextView txtDialogPath;

    private DialogFolderPickerBinding(LinearLayout rootView, MaterialButton btnCancelPicker, MaterialButton btnSelectCurrentFolder, ImageButton btnUpLevel, RecyclerView recyclerFolderTree, TextView txtDialogPath) {
        this.rootView = rootView;
        this.btnCancelPicker = btnCancelPicker;
        this.btnSelectCurrentFolder = btnSelectCurrentFolder;
        this.btnUpLevel = btnUpLevel;
        this.recyclerFolderTree = recyclerFolderTree;
        this.txtDialogPath = txtDialogPath;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogFolderPickerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogFolderPickerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_folder_picker, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogFolderPickerBinding bind(View rootView) {
        int id = R.id.btnCancelPicker;
        MaterialButton btnCancelPicker = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
        if (btnCancelPicker != null) {
            id = R.id.btnSelectCurrentFolder;
            MaterialButton btnSelectCurrentFolder = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (btnSelectCurrentFolder != null) {
                id = R.id.btnUpLevel;
                ImageButton btnUpLevel = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                if (btnUpLevel != null) {
                    id = R.id.recyclerFolderTree;
                    RecyclerView recyclerFolderTree = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                    if (recyclerFolderTree != null) {
                        id = R.id.txtDialogPath;
                        TextView txtDialogPath = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (txtDialogPath != null) {
                            return new DialogFolderPickerBinding((LinearLayout) rootView, btnCancelPicker, btnSelectCurrentFolder, btnUpLevel, recyclerFolderTree, txtDialogPath);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
