package com.foldershortcut.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.adapter.FolderAdapter;
import com.foldershortcut.app.databinding.ActivityFolderViewerBinding;
import com.foldershortcut.app.model.FolderItem;
import com.foldershortcut.app.utils.StorageUtils;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FolderViewerActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/foldershortcut/app/FolderViewerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/foldershortcut/app/adapter/FolderAdapter;", "binding", "Lcom/foldershortcut/app/databinding/ActivityFolderViewerBinding;", "navigationStack", "Ljava/util/ArrayDeque;", "Lkotlin/Pair;", "", "loadCurrentFolder", "", "navigateBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupUI", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FolderViewerActivity extends AppCompatActivity {
    public static final String EXTRA_FOLDER_PATH = "extra_folder_path";
    public static final String EXTRA_FOLDER_URI = "extra_folder_uri";
    private FolderAdapter adapter;
    private ActivityFolderViewerBinding binding;
    private final ArrayDeque<Pair<String, String>> navigationStack = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFolderViewerBinding inflate = ActivityFolderViewerBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityFolderViewerBinding activityFolderViewerBinding = this.binding;
        if (activityFolderViewerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding = null;
        }
        setContentView(activityFolderViewerBinding.getRoot());
        String initialPath = getIntent().getStringExtra("extra_folder_path");
        if (initialPath == null) {
            initialPath = StorageUtils.INSTANCE.getDefaultStoragePath();
        }
        Intrinsics.checkNotNull(initialPath);
        String initialUri = getIntent().getStringExtra("extra_folder_uri");
        this.navigationStack.addLast(new Pair<>(initialPath, initialUri));
        setupUI();
        loadCurrentFolder();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.foldershortcut.app.FolderViewerActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                FolderViewerActivity.this.navigateBack();
            }
        });
    }

    private final void setupUI() {
        ActivityFolderViewerBinding activityFolderViewerBinding = this.binding;
        FolderAdapter folderAdapter = null;
        if (activityFolderViewerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding = null;
        }
        activityFolderViewerBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.FolderViewerActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderViewerActivity.setupUI$lambda$0(FolderViewerActivity.this, view);
            }
        });
        ActivityFolderViewerBinding activityFolderViewerBinding2 = this.binding;
        if (activityFolderViewerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding2 = null;
        }
        activityFolderViewerBinding2.recyclerFolderContent.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new FolderAdapter(CollectionsKt.emptyList(), new Function1<FolderItem, Unit>() { // from class: com.foldershortcut.app.FolderViewerActivity$setupUI$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FolderItem folderItem) {
                invoke2(folderItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FolderItem item) {
                ArrayDeque arrayDeque;
                Intrinsics.checkNotNullParameter(item, "item");
                if (item.isFolder()) {
                    arrayDeque = FolderViewerActivity.this.navigationStack;
                    arrayDeque.addLast(new Pair(item.getPath(), item.getUriString()));
                    FolderViewerActivity.this.loadCurrentFolder();
                    return;
                }
                StorageUtils.INSTANCE.openFile(FolderViewerActivity.this, item);
            }
        });
        ActivityFolderViewerBinding activityFolderViewerBinding3 = this.binding;
        if (activityFolderViewerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding3 = null;
        }
        RecyclerView recyclerView = activityFolderViewerBinding3.recyclerFolderContent;
        FolderAdapter folderAdapter2 = this.adapter;
        if (folderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            folderAdapter = folderAdapter2;
        }
        recyclerView.setAdapter(folderAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(FolderViewerActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadCurrentFolder() {
        String displayName;
        Pair pair = (Pair) CollectionsKt.last(this.navigationStack);
        String path = (String) pair.component1();
        String uriString = (String) pair.component2();
        FolderAdapter folderAdapter = null;
        if (path.length() > 0) {
            String substringAfterLast$default = StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null);
            if (substringAfterLast$default.length() == 0) {
                substringAfterLast$default = path;
            }
            displayName = substringAfterLast$default;
        } else if (uriString == null || (displayName = StringsKt.substringAfterLast$default(uriString, ':', (String) null, 2, (Object) null)) == null) {
            displayName = "Folder";
        }
        ActivityFolderViewerBinding activityFolderViewerBinding = this.binding;
        if (activityFolderViewerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding = null;
        }
        TextView textView = activityFolderViewerBinding.txtCurrentPath;
        String str = path;
        if (str.length() == 0) {
            str = uriString != null ? uriString : "Folder";
        }
        textView.setText(str);
        ActivityFolderViewerBinding activityFolderViewerBinding2 = this.binding;
        if (activityFolderViewerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFolderViewerBinding2 = null;
        }
        activityFolderViewerBinding2.toolbar.setTitle(displayName);
        List items = StorageUtils.INSTANCE.listFilesAndFolders(this, path, uriString);
        FolderAdapter folderAdapter2 = this.adapter;
        if (folderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            folderAdapter = folderAdapter2;
        }
        folderAdapter.updateList(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateBack() {
        if (this.navigationStack.size() > 1) {
            this.navigationStack.removeLast();
            loadCurrentFolder();
        } else {
            finish();
        }
    }
}
