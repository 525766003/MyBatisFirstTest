package cn.cx.WeChat.Service;

import cn.cx.WeChat.Bean.Message;
import cn.cx.WeChat.Dao.MessageDao;

import java.util.List;

public class ListService {
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command,description);
    }
}
