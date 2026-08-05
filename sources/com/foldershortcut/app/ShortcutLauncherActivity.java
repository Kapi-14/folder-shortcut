package com.foldershortcut.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.foldershortcut.app.model.ShortcutModel;
import com.foldershortcut.app.utils.ShortcutStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShortcutLauncherActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\tH\u0002¨\u0006\u000e"}, d2 = {"Lcom/foldershortcut/app/ShortcutLauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openBuiltInViewer", "folderPath", "", "folderUri", "isNull_or_Empty", "", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ShortcutLauncherActivity extends AppCompatActivity {
    public static final String EXTRA_FOLDER_PATH = "extra_folder_path";
    public static final String EXTRA_FOLDER_URI = "extra_folder_uri";
    public static final String EXTRA_SHORTCUT_ID = "extra_shortcut_id";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String shortcutId = getIntent().getStringExtra("extra_shortcut_id");
        String folderPath = getIntent().getStringExtra("extra_folder_path");
        if (folderPath == null) {
            folderPath = "";
        }
        String folderUri = getIntent().getStringExtra("extra_folder_uri");
        if (!isNull_or_Empty(shortcutId)) {
            ShortcutStore shortcutStore = new ShortcutStore(this);
            Intrinsics.checkNotNull(shortcutId);
            ShortcutModel savedModel = shortcutStore.getShortcutById(shortcutId);
            if (savedModel != null) {
                folderPath = savedModel.getFolderPath();
                folderUri = savedModel.getFolderUri();
            }
        }
        openBuiltInViewer(folderPath, folderUri);
        finish();
    }

    private final void openBuiltInViewer(String folderPath, String folderUri) {
        Intent intent = new Intent(this, (Class<?>) FolderViewerActivity.class);
        intent.putExtra("extra_folder_path", folderPath);
        intent.putExtra("extra_folder_uri", folderUri);
        intent.setFlags(335544320);
        startActivity(intent);
    }

    private final boolean isNull_or_Empty(String $this$isNull_or_Empty) {
        if ($this$isNull_or_Empty != null) {
            return $this$isNull_or_Empty.length() == 0;
        }
        return true;
    }
}
