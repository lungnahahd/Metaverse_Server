package com.Lungnaha.MetaverseServer.Controller;

import com.Lungnaha.MetaverseServer.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 앞에서 구현된 서비스와 저장소를 연결해주는 컨트롤러
@Controller
public class ServiceController {
    private DataService service;
    
    @Autowired // Controller 생성 시 해당 Service도 같이 올려버리기
    public ServiceController(DataService service){
        this.service = service;
    }
}
