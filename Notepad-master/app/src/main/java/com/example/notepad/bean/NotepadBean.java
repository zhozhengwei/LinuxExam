package com.example.notepad.bean;

public class NotepadBean {
    private String N_id;
    private String N_note;
    private String N_time;

    public String getN_id() {
        return N_id;
    }

    public void setN_id(String n_id) {
        N_id = n_id;
    }

    public String getN_note() {
        return N_note;
    }

    public void setN_note(String n_note) {
        N_note = n_note;
    }

    public String getN_time() {
        return N_time;
    }

    public void setN_time(String n_time) {
        N_time = n_time;
    }

    @Override
    public String toString() {
        return "NotepadBean{" +
                "N_id='" + N_id + '\'' +
                ", N_note='" + N_note + '\'' +
                ", N_time='" + N_time + '\'' +
                '}';
    }
}
