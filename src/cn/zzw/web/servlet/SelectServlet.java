package cn.zzw.web.servlet;

import cn.zzw.dao.NoteImplement;
import cn.zzw.entity.Notepad;
import cn.zzw.util.JedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/selectServlet")
public class SelectServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        NoteImplement noteImplement = new NoteImplement();
        List<Notepad> list = noteImplement.allSelect();
        Jedis jedis = JedisUtil.getJedis();
        String list_str = jedis.get("note");
        if(list_str == null){
            String json = gson.toJson(list,new TypeToken<List<Notepad>>() {
            }.getType());
            jedis.set("note",json);
            out.println(json);
        }else {
            out.println(list_str);

        }
    }
}
