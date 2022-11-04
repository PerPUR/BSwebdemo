package com.example.bswebdemo.BSService.ServiceIm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.bswebdemo.BSEntity.User;
import com.example.bswebdemo.BSMapper.MapperDao;
import com.example.bswebdemo.BSService.WebServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImService implements WebServiceInterface {

    @Autowired
    MapperDao mapperDao;

    public void addUser(User user){
        mapperDao.insert(user);
    }

    public List<User> getAllUsers(){
        return mapperDao.selectList(null);
    }

    public List<User> getSomeUsers(String phone){

        QueryWrapper wrapper = new QueryWrapper<>();

        wrapper.eq("userphone",phone);

        return mapperDao.selectList(wrapper);
    }
    public void deleteUser(User user){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userphone",user.getUserphone());
        queryWrapper.eq("username",user.getUsername());
        mapperDao.delete(queryWrapper);
    }

    public void alter(User user,String name,String phone){
        UpdateWrapper wrapper = new UpdateWrapper();

        wrapper.eq("userphone",user.getUserphone());
        wrapper.set("userphone",phone);
        wrapper.set("username",name);
        mapperDao.update(user,wrapper);

    }
}
