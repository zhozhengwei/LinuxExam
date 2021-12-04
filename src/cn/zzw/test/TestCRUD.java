package cn.zzw.test;

import cn.zzw.entity.Notepad;
import cn.zzw.util.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCRUD {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Test
    public void testSelect() {
        conn = DBUtils.getConnection();
        try {
            ps = conn.prepareStatement("SELECT N_id, N_note, N_time FROM t_note");
            rs = ps.executeQuery();
            List<Notepad> list = new ArrayList<Notepad>();
            while (rs.next()) {
                Notepad notepad = new Notepad();
                notepad.setN_id(rs.getInt(1));
                notepad.setN_note(rs.getString(2));
                notepad.setN_time(rs.getString(3));
                list.add(notepad);
            }
            for(Notepad notepad:list){
                System.out.println(notepad.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
