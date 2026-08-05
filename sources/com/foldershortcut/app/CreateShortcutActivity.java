package com.foldershortcut.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.adapter.PresetIconAdapter;
import com.foldershortcut.app.databinding.ActivityCreateShortcutBinding;
import com.foldershortcut.app.model.PresetIcon;
import com.foldershortcut.app.model.ShortcutModel;
import com.foldershortcut.app.utils.ImageUtils;
import com.foldershortcut.app.utils.ShortcutHelper;
import com.foldershortcut.app.utils.ShortcutStore;
import com.foldershortcut.app.utils.StorageUtils;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CreateShortcutActivity.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u000e\u0010%\u001a\u00020\t*\u0004\u0018\u00010\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/foldershortcut/app/CreateShortcutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/foldershortcut/app/databinding/ActivityCreateShortcutBinding;", "colorOptions", "", "", "isEditMode", "", "model", "Lcom/foldershortcut/app/model/ShortcutModel;", "personalImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "presetIconAdapter", "Lcom/foldershortcut/app/adapter/PresetIconAdapter;", "presetIcons", "Lcom/foldershortcut/app/model/PresetIcon;", "safPickerLauncher", "shortcutStore", "Lcom/foldershortcut/app/utils/ShortcutStore;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "populateInitialData", "setShape", "shape", "", "setupFolderPicker", "setupIconStudio", "setupLabelInput", "setupPinButton", "setupToolbar", "updatePreview", "isNull_or_Empty", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CreateShortcutActivity extends AppCompatActivity {
    public static final String EXTRA_SHORTCUT_ID = "extra_shortcut_id";
    private ActivityCreateShortcutBinding binding;
    private boolean isEditMode;
    private ShortcutModel model;
    private final ActivityResultLauncher<Intent> personalImageLauncher;
    private PresetIconAdapter presetIconAdapter;
    private final ActivityResultLauncher<Intent> safPickerLauncher;
    private ShortcutStore shortcutStore;
    private final List<Integer> colorOptions = CollectionsKt.listOf((Object[]) new Integer[]{-10262799, -12877066, -15817239, -15681151, -15419226, -680437, -429290, -1292135, -7643914, -770210, -14800581});
    private final List<PresetIcon> presetIcons = CollectionsKt.listOf((Object[]) new PresetIcon[]{new PresetIcon("1", "Folder", "ic_folder", R.drawable.ic_folder), new PresetIcon("2", "Music", "ic_folder_music", R.drawable.ic_folder_music), new PresetIcon("3", "Video", "ic_folder_video", R.drawable.ic_folder_video), new PresetIcon("4", "Photos", "ic_folder_photos", R.drawable.ic_folder_photos), new PresetIcon("5", "Documents", "ic_folder_documents", R.drawable.ic_folder_documents), new PresetIcon("6", "Downloads", "ic_folder_downloads", R.drawable.ic_folder_downloads), new PresetIcon("7", "Code", "ic_folder_code", R.drawable.ic_folder_code), new PresetIcon("8", "Vault", "ic_folder_vault", R.drawable.ic_folder_vault), new PresetIcon("9", "Games", "ic_folder_games", R.drawable.ic_folder_games), new PresetIcon("10", "Cloud", "ic_folder_cloud", R.drawable.ic_folder_cloud), new PresetIcon("11", "Star", "ic_folder_star", R.drawable.ic_folder_star), new PresetIcon("12", "Zip", "ic_folder_zip", R.drawable.ic_folder_zip)});

    public CreateShortcutActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CreateShortcutActivity.safPickerLauncher$lambda$0(CreateShortcutActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.safPickerLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CreateShortcutActivity.personalImageLauncher$lambda$1(CreateShortcutActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.personalImageLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void safPickerLauncher$lambda$0(CreateShortcutActivity this$0, ActivityResult result) {
        String folderName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            ActivityCreateShortcutBinding activityCreateShortcutBinding = null;
            Uri treeUri = data != null ? data.getData() : null;
            if (treeUri != null) {
                this$0.getContentResolver().takePersistableUriPermission(treeUri, 3);
                String lastPathSegment = treeUri.getLastPathSegment();
                if (lastPathSegment == null || (folderName = StringsKt.substringAfterLast$default(lastPathSegment, ':', (String) null, 2, (Object) null)) == null) {
                    folderName = "Selected Folder";
                }
                ShortcutModel shortcutModel = this$0.model;
                if (shortcutModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel = null;
                }
                shortcutModel.setFolderUri(treeUri.toString());
                ShortcutModel shortcutModel2 = this$0.model;
                if (shortcutModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel2 = null;
                }
                shortcutModel2.setFolderPath("");
                if (!this$0.isEditMode) {
                    ShortcutModel shortcutModel3 = this$0.model;
                    if (shortcutModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("model");
                        shortcutModel3 = null;
                    }
                    shortcutModel3.setLabel(folderName);
                    ActivityCreateShortcutBinding activityCreateShortcutBinding2 = this$0.binding;
                    if (activityCreateShortcutBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityCreateShortcutBinding2 = null;
                    }
                    activityCreateShortcutBinding2.editShortcutLabel.setText(folderName);
                }
                ActivityCreateShortcutBinding activityCreateShortcutBinding3 = this$0.binding;
                if (activityCreateShortcutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityCreateShortcutBinding = activityCreateShortcutBinding3;
                }
                activityCreateShortcutBinding.txtSelectedFolderPath.setText("SAF: " + treeUri.getPath());
                this$0.updatePreview();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void personalImageLauncher$lambda$1(CreateShortcutActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            ShortcutModel shortcutModel = null;
            Uri imageUri = data != null ? data.getData() : null;
            if (imageUri != null) {
                String base64 = ImageUtils.uriToBase64$default(ImageUtils.INSTANCE, this$0, imageUri, 0, 4, null);
                if (base64 != null) {
                    ShortcutModel shortcutModel2 = this$0.model;
                    if (shortcutModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("model");
                        shortcutModel2 = null;
                    }
                    shortcutModel2.setPersonalImageBase64(base64);
                    ShortcutModel shortcutModel3 = this$0.model;
                    if (shortcutModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("model");
                    } else {
                        shortcutModel = shortcutModel3;
                    }
                    shortcutModel.setIconType(ShortcutModel.ICON_TYPE_PERSONAL);
                    this$0.updatePreview();
                    return;
                }
                Toast.makeText(this$0, "Failed to load selected image", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        ShortcutModel existingModel;
        super.onCreate(savedInstanceState);
        ActivityCreateShortcutBinding inflate = ActivityCreateShortcutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        ActivityCreateShortcutBinding activityCreateShortcutBinding2 = null;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        setContentView(activityCreateShortcutBinding.getRoot());
        this.shortcutStore = new ShortcutStore(this);
        String shortcutId = getIntent().getStringExtra("extra_shortcut_id");
        if (isNull_or_Empty(shortcutId)) {
            existingModel = null;
        } else {
            ShortcutStore shortcutStore = this.shortcutStore;
            if (shortcutStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shortcutStore");
                shortcutStore = null;
            }
            Intrinsics.checkNotNull(shortcutId);
            existingModel = shortcutStore.getShortcutById(shortcutId);
        }
        if (existingModel != null) {
            this.isEditMode = true;
            this.model = existingModel;
            ActivityCreateShortcutBinding activityCreateShortcutBinding3 = this.binding;
            if (activityCreateShortcutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityCreateShortcutBinding3 = null;
            }
            activityCreateShortcutBinding3.toolbar.setTitle("Edit Shortcut");
            ActivityCreateShortcutBinding activityCreateShortcutBinding4 = this.binding;
            if (activityCreateShortcutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityCreateShortcutBinding2 = activityCreateShortcutBinding4;
            }
            activityCreateShortcutBinding2.btnPinShortcut.setText("Save & Update Shortcut");
        } else {
            this.model = new ShortcutModel(null, "My Folder", StorageUtils.INSTANCE.getDefaultStoragePath(), null, null, null, null, 0, 0, null, ShortcutModel.ACTION_BUILT_IN_BROWSER, 0L, 3065, null);
        }
        setupToolbar();
        setupFolderPicker();
        setupLabelInput();
        setupIconStudio();
        setupPinButton();
        populateInitialData();
        updatePreview();
    }

    private final void setupToolbar() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        activityCreateShortcutBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupToolbar$lambda$2(CreateShortcutActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupToolbar$lambda$2(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x00e0. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void populateInitialData() {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.foldershortcut.app.CreateShortcutActivity.populateInitialData():void");
    }

    private final void setupFolderPicker() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        activityCreateShortcutBinding.btnSafPicker.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupFolderPicker$lambda$3(CreateShortcutActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFolderPicker$lambda$3(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        this$0.safPickerLauncher.launch(intent);
    }

    private final void setupLabelInput() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        activityCreateShortcutBinding.editShortcutLabel.addTextChangedListener(new TextWatcher() { // from class: com.foldershortcut.app.CreateShortcutActivity$setupLabelInput$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShortcutModel shortcutModel;
                shortcutModel = CreateShortcutActivity.this.model;
                if (shortcutModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel = null;
                }
                String valueOf = String.valueOf(s);
                if (valueOf.length() == 0) {
                    valueOf = "My Folder";
                }
                shortcutModel.setLabel(valueOf);
                CreateShortcutActivity.this.updatePreview();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private final void setupIconStudio() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        activityCreateShortcutBinding.toggleIconType.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda8
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
                CreateShortcutActivity.setupIconStudio$lambda$4(CreateShortcutActivity.this, materialButtonToggleGroup, i, z);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding2 = this.binding;
        if (activityCreateShortcutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding2 = null;
        }
        activityCreateShortcutBinding2.recyclerPresetIcons.setLayoutManager(new GridLayoutManager(this, 4));
        List<PresetIcon> list = this.presetIcons;
        ShortcutModel shortcutModel = this.model;
        if (shortcutModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel = null;
        }
        this.presetIconAdapter = new PresetIconAdapter(list, shortcutModel.getPresetIconName(), new Function1<PresetIcon, Unit>() { // from class: com.foldershortcut.app.CreateShortcutActivity$setupIconStudio$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PresetIcon presetIcon) {
                invoke2(presetIcon);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PresetIcon selectedIcon) {
                ShortcutModel shortcutModel2;
                Intrinsics.checkNotNullParameter(selectedIcon, "selectedIcon");
                shortcutModel2 = CreateShortcutActivity.this.model;
                if (shortcutModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel2 = null;
                }
                shortcutModel2.setPresetIconName(selectedIcon.getDrawableName());
                CreateShortcutActivity.this.updatePreview();
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding3 = this.binding;
        if (activityCreateShortcutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding3 = null;
        }
        RecyclerView recyclerView = activityCreateShortcutBinding3.recyclerPresetIcons;
        PresetIconAdapter presetIconAdapter = this.presetIconAdapter;
        if (presetIconAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presetIconAdapter");
            presetIconAdapter = null;
        }
        recyclerView.setAdapter(presetIconAdapter);
        ActivityCreateShortcutBinding activityCreateShortcutBinding4 = this.binding;
        if (activityCreateShortcutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding4 = null;
        }
        activityCreateShortcutBinding4.btnPickImage.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$6(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding5 = this.binding;
        if (activityCreateShortcutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding5 = null;
        }
        activityCreateShortcutBinding5.chipCircle.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$7(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding6 = this.binding;
        if (activityCreateShortcutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding6 = null;
        }
        activityCreateShortcutBinding6.chipRounded.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$8(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding7 = this.binding;
        if (activityCreateShortcutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding7 = null;
        }
        activityCreateShortcutBinding7.chipSquircle.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$9(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding8 = this.binding;
        if (activityCreateShortcutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding8 = null;
        }
        activityCreateShortcutBinding8.chipHexagon.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$10(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding9 = this.binding;
        if (activityCreateShortcutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding9 = null;
        }
        activityCreateShortcutBinding9.chipStar.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupIconStudio$lambda$11(CreateShortcutActivity.this, view);
            }
        });
        ActivityCreateShortcutBinding activityCreateShortcutBinding10 = this.binding;
        if (activityCreateShortcutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding10 = null;
        }
        activityCreateShortcutBinding10.layoutColorPalette.removeAllViews();
        Iterator<Integer> it = this.colorOptions.iterator();
        while (it.hasNext()) {
            final int colorInt = it.next().intValue();
            View circleView = new View(this);
            int size = (int) (36 * circleView.getResources().getDisplayMetrics().density);
            int margin = (int) (4 * circleView.getResources().getDisplayMetrics().density);
            LinearLayout.LayoutParams $this$setupIconStudio_u24lambda_u2414_u24lambda_u2412 = new LinearLayout.LayoutParams(size, size);
            $this$setupIconStudio_u24lambda_u2414_u24lambda_u2412.setMargins(margin, margin, margin, margin);
            circleView.setLayoutParams($this$setupIconStudio_u24lambda_u2414_u24lambda_u2412);
            circleView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_preset_normal));
            circleView.setBackgroundColor(colorInt);
            circleView.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CreateShortcutActivity.setupIconStudio$lambda$14$lambda$13(CreateShortcutActivity.this, colorInt, view);
                }
            });
            ActivityCreateShortcutBinding activityCreateShortcutBinding11 = this.binding;
            if (activityCreateShortcutBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityCreateShortcutBinding11 = null;
            }
            activityCreateShortcutBinding11.layoutColorPalette.addView(circleView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$4(CreateShortcutActivity this$0, MaterialButtonToggleGroup materialButtonToggleGroup, int checkedId, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isChecked) {
            ActivityCreateShortcutBinding activityCreateShortcutBinding = null;
            if (checkedId == R.id.btnTypePreset) {
                ShortcutModel shortcutModel = this$0.model;
                if (shortcutModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel = null;
                }
                shortcutModel.setIconType(ShortcutModel.ICON_TYPE_PRESET);
                ActivityCreateShortcutBinding activityCreateShortcutBinding2 = this$0.binding;
                if (activityCreateShortcutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityCreateShortcutBinding2 = null;
                }
                activityCreateShortcutBinding2.layoutPresetSection.setVisibility(0);
                ActivityCreateShortcutBinding activityCreateShortcutBinding3 = this$0.binding;
                if (activityCreateShortcutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityCreateShortcutBinding = activityCreateShortcutBinding3;
                }
                activityCreateShortcutBinding.layoutPersonalImage.setVisibility(8);
            } else {
                ShortcutModel shortcutModel2 = this$0.model;
                if (shortcutModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    shortcutModel2 = null;
                }
                shortcutModel2.setIconType(ShortcutModel.ICON_TYPE_PERSONAL);
                ActivityCreateShortcutBinding activityCreateShortcutBinding4 = this$0.binding;
                if (activityCreateShortcutBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityCreateShortcutBinding4 = null;
                }
                activityCreateShortcutBinding4.layoutPresetSection.setVisibility(8);
                ActivityCreateShortcutBinding activityCreateShortcutBinding5 = this$0.binding;
                if (activityCreateShortcutBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityCreateShortcutBinding = activityCreateShortcutBinding5;
                }
                activityCreateShortcutBinding.layoutPersonalImage.setVisibility(0);
            }
            this$0.updatePreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$6(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        this$0.personalImageLauncher.launch(Intent.createChooser(intent, "Select Image for Shortcut"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$7(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setShape(ShortcutModel.SHAPE_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$8(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setShape(ShortcutModel.SHAPE_ROUNDED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$9(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setShape(ShortcutModel.SHAPE_SQUIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$10(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setShape(ShortcutModel.SHAPE_HEXAGON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$11(CreateShortcutActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setShape(ShortcutModel.SHAPE_STAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIconStudio$lambda$14$lambda$13(CreateShortcutActivity this$0, int $colorInt, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ShortcutModel shortcutModel = this$0.model;
        if (shortcutModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel = null;
        }
        shortcutModel.setIconBgColor($colorInt);
        this$0.updatePreview();
    }

    private final void setShape(String shape) {
        ShortcutModel shortcutModel = this.model;
        if (shortcutModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel = null;
        }
        shortcutModel.setShapeMask(shape);
        updatePreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePreview() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        ActivityCreateShortcutBinding activityCreateShortcutBinding2 = null;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        TextView textView = activityCreateShortcutBinding.txtPreviewLabel;
        ShortcutModel shortcutModel = this.model;
        if (shortcutModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel = null;
        }
        String label = shortcutModel.getLabel();
        if (label.length() == 0) {
            label = "Folder Shortcut";
        }
        textView.setText(label);
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        CreateShortcutActivity createShortcutActivity = this;
        ShortcutModel shortcutModel2 = this.model;
        if (shortcutModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel2 = null;
        }
        Bitmap bitmap = imageUtils.createShortcutBitmap(createShortcutActivity, shortcutModel2, 256);
        ActivityCreateShortcutBinding activityCreateShortcutBinding3 = this.binding;
        if (activityCreateShortcutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityCreateShortcutBinding2 = activityCreateShortcutBinding3;
        }
        activityCreateShortcutBinding2.imgPreviewIcon.setImageBitmap(bitmap);
    }

    private final void setupPinButton() {
        ActivityCreateShortcutBinding activityCreateShortcutBinding = this.binding;
        if (activityCreateShortcutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityCreateShortcutBinding = null;
        }
        activityCreateShortcutBinding.btnPinShortcut.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.CreateShortcutActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateShortcutActivity.setupPinButton$lambda$16(CreateShortcutActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPinButton$lambda$16(CreateShortcutActivity this$0, View it) {
        String msg;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ShortcutModel shortcutModel = this$0.model;
        ShortcutModel shortcutModel2 = null;
        if (shortcutModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel = null;
        }
        if (shortcutModel.getFolderPath().length() == 0) {
            ShortcutModel shortcutModel3 = this$0.model;
            if (shortcutModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                shortcutModel3 = null;
            }
            if (this$0.isNull_or_Empty(shortcutModel3.getFolderUri())) {
                Toast.makeText(this$0, "Please select a target folder first", 0).show();
                return;
            }
        }
        ShortcutModel shortcutModel4 = this$0.model;
        if (shortcutModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel4 = null;
        }
        shortcutModel4.setClickAction(ShortcutModel.ACTION_BUILT_IN_BROWSER);
        ShortcutStore shortcutStore = this$0.shortcutStore;
        if (shortcutStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortcutStore");
            shortcutStore = null;
        }
        ShortcutModel shortcutModel5 = this$0.model;
        if (shortcutModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            shortcutModel5 = null;
        }
        shortcutStore.saveShortcut(shortcutModel5);
        ShortcutHelper shortcutHelper = ShortcutHelper.INSTANCE;
        CreateShortcutActivity createShortcutActivity = this$0;
        ShortcutModel shortcutModel6 = this$0.model;
        if (shortcutModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        } else {
            shortcutModel2 = shortcutModel6;
        }
        boolean success = shortcutHelper.pinShortcutToHomeScreen(createShortcutActivity, shortcutModel2);
        if (success) {
            if (this$0.isEditMode) {
                msg = "Shortcut updated & pinned!";
            } else {
                msg = this$0.getString(R.string.shortcut_created_success);
                Intrinsics.checkNotNullExpressionValue(msg, "getString(...)");
            }
            Toast.makeText(this$0, msg, 0).show();
            this$0.finish();
            return;
        }
        Toast.makeText(this$0, "Failed to pin shortcut to home screen", 0).show();
    }

    private final boolean isNull_or_Empty(String $this$isNull_or_Empty) {
        if ($this$isNull_or_Empty != null) {
            return $this$isNull_or_Empty.length() == 0;
        }
        return true;
    }
}
