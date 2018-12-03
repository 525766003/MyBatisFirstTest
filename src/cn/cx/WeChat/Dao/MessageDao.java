package cn.cx.WeChat.Dao;

import cn.cx.WeChat.Bean.Message;
import cn.cx.WeChat.DB.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作层
 */

public class MessageDao {
    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messagesList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message =new Message();
            message.setCommand(command);
            message.setDescription(description);
            //通过sqlSession执行SQL语句
            messagesList = sqlSession.selectList("Message.queryMessageList",message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messagesList;
    }

    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
//
//    public static void main(String[] args){
//        MessageDao messageDao =new MessageDao();
//        messageDao.queryMessageList("","");
//        Map<String,Message> messageMap= new HashMap<String,Message>();
//        messageMap.put("key",new Message());
//        Logger log;
//        log.debug("adf");
//        log.info(message);
//        log.warn(messate);
//        log.error(message);
//    }
}

