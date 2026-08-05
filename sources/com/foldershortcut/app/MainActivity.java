package com.foldershortcut.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.adapter.ShortcutAdapter;
import com.foldershortcut.app.databinding.ActivityMainBinding;
import com.foldershortcut.app.model.ShortcutModel;
import com.foldershortcut.app.utils.ShortcutHelper;
import com.foldershortcut.app.utils.ShortcutStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J-\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\nH\u0014J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/foldershortcut/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/foldershortcut/app/adapter/ShortcutAdapter;", "binding", "Lcom/foldershortcut/app/databinding/ActivityMainBinding;", "shortcutStore", "Lcom/foldershortcut/app/utils/ShortcutStore;", "checkPermissions", "", "confirmDelete", "shortcut", "Lcom/foldershortcut/app/model/ShortcutModel;", "editShortcut", "loadShortcuts", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openShortcut", "pinShortcut", "requestStoragePermissions", "setupUI", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class MainActivity extends AppCompatActivity {
    private static final int REQ_PERMISSION = 1001;
    private ShortcutAdapter adapter;
    private ActivityMainBinding binding;
    private ShortcutStore shortcutStore;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        setContentView(activityMainBinding.getRoot());
        this.shortcutStore = new ShortcutStore(this);
        setupUI();
        checkPermissions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        loadShortcuts();
    }

    private final void setupUI() {
        ActivityMainBinding activityMainBinding = this.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.recyclerShortcuts.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ShortcutAdapter(CollectionsKt.emptyList(), new Function1<ShortcutModel, Unit>() { // from class: com.foldershortcut.app.MainActivity$setupUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortcutModel shortcutModel) {
                invoke2(shortcutModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortcutModel shortcut) {
                Intrinsics.checkNotNullParameter(shortcut, "shortcut");
                MainActivity.this.openShortcut(shortcut);
            }
        }, new Function1<ShortcutModel, Unit>() { // from class: com.foldershortcut.app.MainActivity$setupUI$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortcutModel shortcutModel) {
                invoke2(shortcutModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortcutModel shortcut) {
                Intrinsics.checkNotNullParameter(shortcut, "shortcut");
                MainActivity.this.editShortcut(shortcut);
            }
        }, new Function1<ShortcutModel, Unit>() { // from class: com.foldershortcut.app.MainActivity$setupUI$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortcutModel shortcutModel) {
                invoke2(shortcutModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortcutModel shortcut) {
                Intrinsics.checkNotNullParameter(shortcut, "shortcut");
                MainActivity.this.pinShortcut(shortcut);
            }
        }, new Function1<ShortcutModel, Unit>() { // from class: com.foldershortcut.app.MainActivity$setupUI$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortcutModel shortcutModel) {
                invoke2(shortcutModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortcutModel shortcut) {
                Intrinsics.checkNotNullParameter(shortcut, "shortcut");
                MainActivity.this.confirmDelete(shortcut);
            }
        });
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        RecyclerView recyclerView = activityMainBinding3.recyclerShortcuts;
        ShortcutAdapter shortcutAdapter = this.adapter;
        if (shortcutAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            shortcutAdapter = null;
        }
        recyclerView.setAdapter(shortcutAdapter);
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        activityMainBinding4.fabAdd.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupUI$lambda$0(MainActivity.this, view);
            }
        });
        ActivityMainBinding activityMainBinding5 = this.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        activityMainBinding5.btnCreateFirstShortcut.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupUI$lambda$1(MainActivity.this, view);
            }
        });
        ActivityMainBinding activityMainBinding6 = this.binding;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding6;
        }
        activityMainBinding2.btnGrantPermission.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupUI$lambda$2(MainActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) CreateShortcutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$1(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) CreateShortcutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$2(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestStoragePermissions();
    }

    private final void loadShortcuts() {
        ShortcutStore shortcutStore = this.shortcutStore;
        ShortcutAdapter shortcutAdapter = null;
        ActivityMainBinding activityMainBinding = null;
        if (shortcutStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortcutStore");
            shortcutStore = null;
        }
        List<ShortcutModel> allShortcuts = shortcutStore.getAllShortcuts();
        if (allShortcuts.isEmpty()) {
            ActivityMainBinding activityMainBinding2 = this.binding;
            if (activityMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding2 = null;
            }
            activityMainBinding2.viewEmpty.setVisibility(0);
            ActivityMainBinding activityMainBinding3 = this.binding;
            if (activityMainBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMainBinding = activityMainBinding3;
            }
            activityMainBinding.recyclerShortcuts.setVisibility(8);
            return;
        }
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        activityMainBinding4.viewEmpty.setVisibility(8);
        ActivityMainBinding activityMainBinding5 = this.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        activityMainBinding5.recyclerShortcuts.setVisibility(0);
        ShortcutAdapter shortcutAdapter2 = this.adapter;
        if (shortcutAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            shortcutAdapter = shortcutAdapter2;
        }
        shortcutAdapter.updateList(allShortcuts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openShortcut(ShortcutModel shortcut) {
        Intent intent = new Intent(this, (Class<?>) FolderViewerActivity.class);
        intent.putExtra("extra_folder_path", shortcut.getFolderPath());
        intent.putExtra("extra_folder_uri", shortcut.getFolderUri());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editShortcut(ShortcutModel shortcut) {
        Intent intent = new Intent(this, (Class<?>) CreateShortcutActivity.class);
        intent.putExtra("extra_shortcut_id", shortcut.getId());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pinShortcut(ShortcutModel shortcut) {
        boolean success = ShortcutHelper.INSTANCE.pinShortcutToHomeScreen(this, shortcut);
        if (success) {
            Toast.makeText(this, getString(R.string.shortcut_created_success), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmDelete(final ShortcutModel shortcut) {
        new AlertDialog.Builder(this).setTitle(R.string.confirm_delete_title).setMessage(R.string.confirm_delete_msg).setPositiveButton(R.string.action_delete, new DialogInterface.OnClickListener() { // from class: com.foldershortcut.app.MainActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.confirmDelete$lambda$5(MainActivity.this, shortcut, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmDelete$lambda$5(MainActivity this$0, ShortcutModel shortcut, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shortcut, "$shortcut");
        ShortcutStore shortcutStore = this$0.shortcutStore;
        if (shortcutStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortcutStore");
            shortcutStore = null;
        }
        shortcutStore.deleteShortcut(shortcut.getId());
        this$0.loadShortcuts();
    }

    private final void checkPermissions() {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.READ_MEDIA_IMAGES") != 0) {
                z = false;
            }
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        boolean hasPermission = z;
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.bannerPermission.setVisibility(hasPermission ? 8 : 0);
    }

    private final void requestStoragePermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_MEDIA_IMAGES"}, 1001);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001) {
            checkPermissions();
        }
    }
}
