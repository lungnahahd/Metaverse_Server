package com.Lungnaha.MetaverseServer.Controller;

import com.Lungnaha.MetaverseServer.Domain.DataForm;
import com.Lungnaha.MetaverseServer.Domain.GetDataForm;
import com.Lungnaha.MetaverseServer.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 앞에서 구현된 서비스와 저장소를 연결해주는 컨트롤러
@Controller
public class ServiceController {
    private DataService service;
    
    @Autowired // Controller 생성 시 해당 Service도 같이 올려버리기
    public ServiceController(DataService service){
        this.service = service;
    }

    @GetMapping("/")
    public String FirstCome(){
        return "static.html";
    }

    @GetMapping("/main")
    public String ShowMain(){
        return "main.html";
    }

    @PostMapping("/join")
    public String MakeNew(GetDataForm getDataForm){ // HTML에서 받는 데이터의 형식은 따로 지정해야 한다.
        DataForm dataForm = new DataForm();
        // 받은 데이터를 Domain 형식으로 지정하고 이를 저장소에 넣는 과정
        dataForm.setId(getDataForm.getId());
        dataForm.setPassword(getDataForm.getPassword());
        service.Join(dataForm);
        return "redirect:/main"; // 동작 완료 후 이동할 위치
    }

    @GetMapping("/list")
    public String ShowList(Model model){
        List<DataForm> list = service.ShowAllMember();
        model.addAttribute("data",list);
        return "showAll.html";
    }

    @GetMapping("/join")
    public String NewData(){
        return "join.html";
    }
}

// 과정
// Controller -> Service -> Repository 연결되어서 서버 동작
