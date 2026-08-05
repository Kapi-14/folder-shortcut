package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes2.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final LinearLayout bannerPermission;
    public final MaterialButton btnCreateFirstShortcut;
    public final MaterialButton btnGrantPermission;
    public final FloatingActionButton fabAdd;
    public final RecyclerView recyclerShortcuts;
    private final CoordinatorLayout rootView;
    public final MaterialToolbar toolbar;
    public final LinearLayout viewEmpty;

    private ActivityMainBinding(CoordinatorLayout rootView, LinearLayout bannerPermission, MaterialButton btnCreateFirstShortcut, MaterialButton btnGrantPermission, FloatingActionButton fabAdd, RecyclerView recyclerShortcuts, MaterialToolbar toolbar, LinearLayout viewEmpty) {
        this.rootView = rootView;
        this.bannerPermission = bannerPermission;
        this.btnCreateFirstShortcut = btnCreateFirstShortcut;
        this.btnGrantPermission = btnGrantPermission;
        this.fabAdd = fabAdd;
        this.recyclerShortcuts = recyclerShortcuts;
        this.toolbar = toolbar;
        this.viewEmpty = viewEmpty;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView) {
        int id = R.id.bannerPermission;
        LinearLayout bannerPermission = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (bannerPermission != null) {
            id = R.id.btnCreateFirstShortcut;
            MaterialButton btnCreateFirstShortcut = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (btnCreateFirstShortcut != null) {
                id = R.id.btnGrantPermission;
                MaterialButton btnGrantPermission = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                if (btnGrantPermission != null) {
                    id = R.id.fabAdd;
                    FloatingActionButton fabAdd = (FloatingActionButton) ViewBindings.findChildViewById(rootView, id);
                    if (fabAdd != null) {
                        id = R.id.recyclerShortcuts;
                        RecyclerView recyclerShortcuts = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                        if (recyclerShortcuts != null) {
                            id = R.id.toolbar;
                            MaterialToolbar toolbar = (MaterialToolbar) ViewBindings.findChildViewById(rootView, id);
                            if (toolbar != null) {
                                id = R.id.viewEmpty;
                                LinearLayout viewEmpty = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (viewEmpty != null) {
                                    return new ActivityMainBinding((CoordinatorLayout) rootView, bannerPermission, btnCreateFirstShortcut, btnGrantPermission, fabAdd, recyclerShortcuts, toolbar, viewEmpty);
                                }
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
