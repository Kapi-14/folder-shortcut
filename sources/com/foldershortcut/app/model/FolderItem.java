package com.foldershortcut.app.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FolderItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/foldershortcut/app/model/FolderItem;", "", "name", "", "path", "isFolder", "", "sizeBytes", "", "lastModified", "uriString", "(Ljava/lang/String;Ljava/lang/String;ZJJLjava/lang/String;)V", "()Z", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "getPath", "getSizeBytes", "getUriString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class FolderItem {
    private final boolean isFolder;
    private final long lastModified;
    private final String name;
    private final String path;
    private final long sizeBytes;
    private final String uriString;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsFolder() {
        return this.isFolder;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastModified() {
        return this.lastModified;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUriString() {
        return this.uriString;
    }

    public final FolderItem copy(String name, String path, boolean isFolder, long sizeBytes, long lastModified, String uriString) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new FolderItem(name, path, isFolder, sizeBytes, lastModified, uriString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderItem)) {
            return false;
        }
        FolderItem folderItem = (FolderItem) other;
        return Intrinsics.areEqual(this.name, folderItem.name) && Intrinsics.areEqual(this.path, folderItem.path) && this.isFolder == folderItem.isFolder && this.sizeBytes == folderItem.sizeBytes && this.lastModified == folderItem.lastModified && Intrinsics.areEqual(this.uriString, folderItem.uriString);
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + FolderItem$$ExternalSyntheticBackport0.m(this.isFolder)) * 31) + FolderItem$$ExternalSyntheticBackport1.m(this.sizeBytes)) * 31) + FolderItem$$ExternalSyntheticBackport1.m(this.lastModified)) * 31) + (this.uriString == null ? 0 : this.uriString.hashCode());
    }

    public String toString() {
        return "FolderItem(name=" + this.name + ", path=" + this.path + ", isFolder=" + this.isFolder + ", sizeBytes=" + this.sizeBytes + ", lastModified=" + this.lastModified + ", uriString=" + this.uriString + ")";
    }

    public FolderItem(String name, String path, boolean isFolder, long sizeBytes, long lastModified, String uriString) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.path = path;
        this.isFolder = isFolder;
        this.sizeBytes = sizeBytes;
        this.lastModified = lastModified;
        this.uriString = uriString;
    }

    public /* synthetic */ FolderItem(String str, String str2, boolean z, long j, long j2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? System.currentTimeMillis() : j2, (i & 32) != 0 ? null : str3);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final String getUriString() {
        return this.uriString;
    }
}
