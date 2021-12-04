package cn.zzw.dao;

import cn.zzw.entity.Notepad;
import cn.zzw.util.C3P0util;
import cn.zzw.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteImplement implements NoteDao{
    Connection conn = null;


    @Override
    public List<Notepad> allSelect() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Notepad> list = new ArrayList<Notepad>();
        conn = C3P0util.getConnection();
        try {
            ps = conn.prepareStatement("SELECT N_id, N_note, N_time FROM t_note");
            rs = ps.executeQuery();
            while (rs.next()) {
                Notepad notepad = new Notepad();
                notepad.setN_id(rs.getInt(1));
                notepad.setN_note(rs.getString(2));
                notepad.setN_time(rs.getString(3));
                list.add(notepad);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

        return list;
    }

    //删除
    @Override
    public int deleteId(int id) {
        int sign = -1;
        PreparedStatement ps = null;
        conn = C3P0util.getConnection();
        String sql = "DELETE FROM t_note WHERE N_id = ?";
        if(id != 0){
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                sign = ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return sign;
    }

    //添加
    @Override
    public int addNote(String note, String time) {
        int sign = -1;
        PreparedStatement ps = null;
        conn = C3P0util.getConnection();
        String sql = "INSERT INTO t_note (N_note,N_time) VALUES (?,?)";
        if(note != null & time!= null){
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1,note);
                ps.setString(2,time);
                sign = ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return sign;
    }

    @Override
    public int updateId(int id, String note, String time) {
        int sign = -1;
        PreparedStatement ps = null;
        conn = C3P0util.getConnection();
        String sql = "UPDATE t_note SET N_note=?,N_time=? WHERE N_id=?";
        if(id != 0){
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1,note);
                ps.setString(2,time);
                ps.setInt(3,id);
                sign = ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return sign;
    }
}
