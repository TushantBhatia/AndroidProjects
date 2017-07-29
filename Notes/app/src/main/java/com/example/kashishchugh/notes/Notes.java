package com.example.kashishchugh.notes;

/**
 * Created by kashish chugh on 26-Jun-17.
 */

public class Notes {
    String note;
    boolean checked;

    public Notes(String note, boolean checked) {
        this.note = note;
        this.checked = checked;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
