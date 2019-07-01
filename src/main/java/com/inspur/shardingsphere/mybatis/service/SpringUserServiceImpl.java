package com.inspur.shardingsphere.mybatis.service;

import com.inspur.shardingsphere.mybatis.entity.User;
import com.inspur.shardingsphere.mybatis.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpringUserServiceImpl implements UserService {
    
    @Resource
    private UserRepository userRepository;
    
    @Override
    public void initEnvironment() {
        userRepository.createTableIfNotExists();
        userRepository.truncateTable();
    }
    
    @Override
    public void cleanEnvironment() {
        userRepository.dropTable();
    }
    
    @Override
    public void processSuccess() {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> userIds = insertData();
        printData();
//        deleteData(userIds);
//        printData();
        System.out.println("-------------- Process Success Finish --------------");
    }
    
    private List<Long> insertData() {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("test_mybatis_" + i);
            user.setPwd("pwd_mybatis_" + i);
            userRepository.insert(user);
            result.add((long) user.getUserId());
        }
        return result;
    }
    
    @Override
    public void processFailure() {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }
    
    private void deleteData(final List<Long> userIds) {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : userIds) {
            userRepository.delete(each);
        }
    }
    
    @Override
    public void printData() {
        System.out.println("---------------------------- Print User Data -----------------------");
        for (Object each : userRepository.selectAll()) {
            User user = (User)each;
            System.out.println(user.getUserName());
        }
    }

    @Override
    public Map selectOne() {
        System.out.println("---------------------------- Print User Data -----------------------");
        Map map = userRepository.selectOne();
        System.out.println(map.get("user_name"));
        return map;
    }
}
