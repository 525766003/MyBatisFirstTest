package cn.cx.WeChat.Service;

import cn.cx.WeChat.Dao.MessageDao;

public class MaintainService {
    public void deleteOne(String id){
        if(id !=null&&!"".equals(id.trim())){
            MessageDao messageDao =new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }
}
