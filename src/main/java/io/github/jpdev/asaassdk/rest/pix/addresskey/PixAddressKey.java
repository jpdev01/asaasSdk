package io.github.jpdev.asaassdk.rest.pix.addresskey;

import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyStatus;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;

public class PixAddressKey {

    public String id;
    public String key;
    public PixAddressKeyType type;
    public PixAddressKeyStatus status;
    public String dateCreated;
    public boolean canBeDeleted;
    public Object cannotBeDeletedReason;
    public Object qrCode;

    public static PixAddressKeyCreator creator() {
        return new PixAddressKeyCreator();
    }

    public static PixAddressKeyReader reader() {
        return new PixAddressKeyReader();
    }

    public PixAddressKey() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PixAddressKeyType getType() {
        return type;
    }

    public void setType(PixAddressKeyType type) {
        this.type = type;
    }

    public PixAddressKeyStatus getStatus() {
        return status;
    }

    public void setStatus(PixAddressKeyStatus status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isCanBeDeleted() {
        return canBeDeleted;
    }

    public void setCanBeDeleted(boolean canBeDeleted) {
        this.canBeDeleted = canBeDeleted;
    }

    public Object getCannotBeDeletedReason() {
        return cannotBeDeletedReason;
    }

    public void setCannotBeDeletedReason(Object cannotBeDeletedReason) {
        this.cannotBeDeletedReason = cannotBeDeletedReason;
    }

    public Object getQrCode() {
        return qrCode;
    }

    public void setQrCode(Object qrCode) {
        this.qrCode = qrCode;
    }
}
