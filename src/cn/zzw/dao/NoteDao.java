package cn.zzw.dao;

import cn.zzw.entity.Notepad;

import java.util.List;

public interface NoteDao {
    public List<Notepad> allSelect();

    public int deleteId( int id);

    public int addNote( String note, String time);

    public int updateId( int id, String note, String time);
}
