package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes2.dex */
public final class ActivityFolderViewerBinding implements ViewBinding {
    public final RecyclerView recyclerFolderContent;
    private final LinearLayout rootView;
    public final MaterialToolbar toolbar;
    public final TextView txtCurrentPath;

    private ActivityFolderViewerBinding(LinearLayout rootView, RecyclerView recyclerFolderContent, MaterialToolbar toolbar, TextView txtCurrentPath) {
        this.rootView = rootView;
        this.recyclerFolderContent = recyclerFolderContent;
        this.toolbar = toolbar;
        this.txtCurrentPath = txtCurrentPath;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFolderViewerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFolderViewerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_folder_viewer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityFolderViewerBinding bind(View rootView) {
        int id = R.id.recyclerFolderContent;
        RecyclerView recyclerFolderContent = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
        if (recyclerFolderContent != null) {
            id = R.id.toolbar;
            MaterialToolbar toolbar = (MaterialToolbar) ViewBindings.findChildViewById(rootView, id);
            if (toolbar != null) {
                id = R.id.txtCurrentPath;
                TextView txtCurrentPath = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (txtCurrentPath != null) {
                    return new ActivityFolderViewerBinding((LinearLayout) rootView, recyclerFolderContent, toolbar, txtCurrentPath);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
