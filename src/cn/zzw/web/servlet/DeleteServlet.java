package cn.zzw.web.servlet;

import cn.zzw.dao.NoteImplement;
import cn.zzw.entity.Notepad;
import cn.zzw.util.JedisUtil;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream is = request.getInputStream();
        String bodyInfo = IOUtils.toString(is, "utf-8");
        Gson gson = new Gson();
        Notepad notepad = gson.fromJson(bodyInfo,Notepad.class);
        NoteImplement noteImplement = new NoteImplement();
        int result = noteImplement.deleteId(notepad.getN_id());
        PrintWriter out = response.getWriter();
        Jedis jedis = JedisUtil.getJedis();
        jedis.flushDB();
        out.println(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
