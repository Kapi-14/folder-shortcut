package com.foldershortcut.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.foldershortcut.app.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes2.dex */
public final class ActivityCreateShortcutBinding implements ViewBinding {
    public final MaterialButton btnPickImage;
    public final MaterialButton btnPinShortcut;
    public final MaterialButton btnSafPicker;
    public final MaterialButton btnTypePersonal;
    public final MaterialButton btnTypePreset;
    public final Chip chipCircle;
    public final ChipGroup chipGroupShapes;
    public final Chip chipHexagon;
    public final Chip chipRounded;
    public final Chip chipSquircle;
    public final Chip chipStar;
    public final TextInputEditText editShortcutLabel;
    public final ImageView imgPreviewIcon;
    public final LinearLayout layoutColorPalette;
    public final LinearLayout layoutPersonalImage;
    public final LinearLayout layoutPresetSection;
    public final RecyclerView recyclerPresetIcons;
    private final CoordinatorLayout rootView;
    public final MaterialButtonToggleGroup toggleIconType;
    public final MaterialToolbar toolbar;
    public final TextView txtPreviewLabel;
    public final TextView txtSelectedFolderPath;

    private ActivityCreateShortcutBinding(CoordinatorLayout rootView, MaterialButton btnPickImage, MaterialButton btnPinShortcut, MaterialButton btnSafPicker, MaterialButton btnTypePersonal, MaterialButton btnTypePreset, Chip chipCircle, ChipGroup chipGroupShapes, Chip chipHexagon, Chip chipRounded, Chip chipSquircle, Chip chipStar, TextInputEditText editShortcutLabel, ImageView imgPreviewIcon, LinearLayout layoutColorPalette, LinearLayout layoutPersonalImage, LinearLayout layoutPresetSection, RecyclerView recyclerPresetIcons, MaterialButtonToggleGroup toggleIconType, MaterialToolbar toolbar, TextView txtPreviewLabel, TextView txtSelectedFolderPath) {
        this.rootView = rootView;
        this.btnPickImage = btnPickImage;
        this.btnPinShortcut = btnPinShortcut;
        this.btnSafPicker = btnSafPicker;
        this.btnTypePersonal = btnTypePersonal;
        this.btnTypePreset = btnTypePreset;
        this.chipCircle = chipCircle;
        this.chipGroupShapes = chipGroupShapes;
        this.chipHexagon = chipHexagon;
        this.chipRounded = chipRounded;
        this.chipSquircle = chipSquircle;
        this.chipStar = chipStar;
        this.editShortcutLabel = editShortcutLabel;
        this.imgPreviewIcon = imgPreviewIcon;
        this.layoutColorPalette = layoutColorPalette;
        this.layoutPersonalImage = layoutPersonalImage;
        this.layoutPresetSection = layoutPresetSection;
        this.recyclerPresetIcons = recyclerPresetIcons;
        this.toggleIconType = toggleIconType;
        this.toolbar = toolbar;
        this.txtPreviewLabel = txtPreviewLabel;
        this.txtSelectedFolderPath = txtSelectedFolderPath;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCreateShortcutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCreateShortcutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_create_shortcut, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCreateShortcutBinding bind(View rootView) {
        int id = R.id.btnPickImage;
        MaterialButton btnPickImage = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
        if (btnPickImage != null) {
            id = R.id.btnPinShortcut;
            MaterialButton btnPinShortcut = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (btnPinShortcut != null) {
                id = R.id.btnSafPicker;
                MaterialButton btnSafPicker = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                if (btnSafPicker != null) {
                    id = R.id.btnTypePersonal;
                    MaterialButton btnTypePersonal = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                    if (btnTypePersonal != null) {
                        id = R.id.btnTypePreset;
                        MaterialButton btnTypePreset = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                        if (btnTypePreset != null) {
                            id = R.id.chipCircle;
                            Chip chipCircle = (Chip) ViewBindings.findChildViewById(rootView, id);
                            if (chipCircle != null) {
                                id = R.id.chipGroupShapes;
                                ChipGroup chipGroupShapes = (ChipGroup) ViewBindings.findChildViewById(rootView, id);
                                if (chipGroupShapes != null) {
                                    id = R.id.chipHexagon;
                                    Chip chipHexagon = (Chip) ViewBindings.findChildViewById(rootView, id);
                                    if (chipHexagon != null) {
                                        id = R.id.chipRounded;
                                        Chip chipRounded = (Chip) ViewBindings.findChildViewById(rootView, id);
                                        if (chipRounded != null) {
                                            id = R.id.chipSquircle;
                                            Chip chipSquircle = (Chip) ViewBindings.findChildViewById(rootView, id);
                                            if (chipSquircle != null) {
                                                id = R.id.chipStar;
                                                Chip chipStar = (Chip) ViewBindings.findChildViewById(rootView, id);
                                                if (chipStar != null) {
                                                    id = R.id.editShortcutLabel;
                                                    TextInputEditText editShortcutLabel = (TextInputEditText) ViewBindings.findChildViewById(rootView, id);
                                                    if (editShortcutLabel != null) {
                                                        id = R.id.imgPreviewIcon;
                                                        ImageView imgPreviewIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                                        if (imgPreviewIcon != null) {
                                                            id = R.id.layoutColorPalette;
                                                            LinearLayout layoutColorPalette = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                            if (layoutColorPalette != null) {
                                                                id = R.id.layoutPersonalImage;
                                                                LinearLayout layoutPersonalImage = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                                if (layoutPersonalImage != null) {
                                                                    id = R.id.layoutPresetSection;
                                                                    LinearLayout layoutPresetSection = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                                    if (layoutPresetSection != null) {
                                                                        id = R.id.recyclerPresetIcons;
                                                                        RecyclerView recyclerPresetIcons = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                                                                        if (recyclerPresetIcons != null) {
                                                                            id = R.id.toggleIconType;
                                                                            MaterialButtonToggleGroup toggleIconType = (MaterialButtonToggleGroup) ViewBindings.findChildViewById(rootView, id);
                                                                            if (toggleIconType != null) {
                                                                                id = R.id.toolbar;
                                                                                MaterialToolbar toolbar = (MaterialToolbar) ViewBindings.findChildViewById(rootView, id);
                                                                                if (toolbar != null) {
                                                                                    id = R.id.txtPreviewLabel;
                                                                                    TextView txtPreviewLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                                    if (txtPreviewLabel != null) {
                                                                                        id = R.id.txtSelectedFolderPath;
                                                                                        TextView txtSelectedFolderPath = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                                        if (txtSelectedFolderPath != null) {
                                                                                            return new ActivityCreateShortcutBinding((CoordinatorLayout) rootView, btnPickImage, btnPinShortcut, btnSafPicker, btnTypePersonal, btnTypePreset, chipCircle, chipGroupShapes, chipHexagon, chipRounded, chipSquircle, chipStar, editShortcutLabel, imgPreviewIcon, layoutColorPalette, layoutPersonalImage, layoutPresetSection, recyclerPresetIcons, toggleIconType, toolbar, txtPreviewLabel, txtSelectedFolderPath);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
