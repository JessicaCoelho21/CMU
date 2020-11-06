package pt.ipp.estg.recyclerview.models;

import java.io.Serializable;

public class Contacts implements Serializable {
    private String mName;
    private boolean mOnline;

    public Contacts(String mName, boolean mOnline) {
        this.mName = mName;
        this.mOnline = mOnline;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean ismOnline() {
        return mOnline;
    }

    public void setmOnline(boolean mOnline) {
        this.mOnline = mOnline;
    }
}

