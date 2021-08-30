package com.Lungnaha.MetaverseServer.Service;

import com.Lungnaha.MetaverseServer.Domain.DataForm;
import com.Lungnaha.MetaverseServer.Repository.TemplateJDBC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Test 진행 시에 Spring Boot를 사용하겠다는 의미
@Transactional // 각 Test 실행시 진행되는 동작을 DB에 실제 반영하지 않겠다는 의미
class DataServiceTest {

    @Autowired DataService service;
    @Autowired
    TemplateJDBC repos;


    @Test
    void 회원가입() {
        //given
        DataForm dataForm = new DataForm();
        DataForm dataForm1 = new DataForm();
        DataForm dataForm2 = new DataForm();
        dataForm.setId("evan");
        dataForm.setPassword("1111");
        dataForm1.setId("lungnaha");
        dataForm1.setPassword("2222");
        dataForm2.setId("evan");
        dataForm2.setPassword("3333");
        //when
        service.Join(dataForm);
        service.Join(dataForm2);
        //then
        System.out.println(dataForm.getPassword());
    }

    @Test
    void 아이디로찾기() {
        //given
        DataForm dataForm = new DataForm();
        DataForm dataForm1 = new DataForm();
        DataForm dataForm2 = new DataForm();
        dataForm.setId("evan");
        dataForm.setPassword("1111");
        dataForm1.setId("lungnaha");
        dataForm1.setPassword("2222");
        dataForm2.setId("evan");
        dataForm2.setPassword("3333");
        //when
        service.Join(dataForm1);
        service.Join(dataForm);
        //then
        Optional<DataForm> check = service.ShowIDMember("lungnaha");
        DataForm result = check.get();
        System.out.println(result.getPassword());
    }

    @Test
    void 전체공개() {
        //given
        DataForm dataForm = new DataForm();
        DataForm dataForm1 = new DataForm();
        DataForm dataForm2 = new DataForm();
        dataForm.setId("evan");
        dataForm.setPassword("1111");
        dataForm1.setId("lungnaha");
        dataForm1.setPassword("2222");
        dataForm2.setId("evan");
        dataForm2.setPassword("3333");
        //when
        service.Join(dataForm);
        service.Join(dataForm1);
        //then
        List result = service.ShowAllMember();
        for(int i = 0; i < result.size(); i++){
            DataForm show = (DataForm)result.get(i);
            System.out.println(show.getId());
            System.out.println(show.getPassword());
        }
    }
}