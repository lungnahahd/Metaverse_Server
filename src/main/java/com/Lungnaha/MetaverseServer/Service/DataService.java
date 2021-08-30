package com.Lungnaha.MetaverseServer.Service;

import com.Lungnaha.MetaverseServer.Domain.DataForm;
import com.Lungnaha.MetaverseServer.Repository.TemplateJDBC;
import java.util.List;
import java.util.Optional;

public class DataService {
    private TemplateJDBC repos; // 생성한 DB 저장소를 이용
    
    public DataService(TemplateJDBC repos){
        this.repos = repos; // 생성자를 만들때마다 불러주는 것이 아니라 입력하는 저장소를 그대로 사용
    }

    // 중복 회원 여부를 확인하고 회원가입을 진행하는 함수
    public String Join(DataForm dataForm){
        try {
            if(PresentMember(dataForm)){
                repos.Save(dataForm);
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new IllegalStateException("이미 존잰하는 회원 ID 입니다.");
        }
        return dataForm.getId();
    }

    // 이전에 가입된 적이 있는지 여부를 확인해주는 함수
    private boolean PresentMember(DataForm dataForm){
        boolean notSame = true;
        Optional<DataForm> presentMember = repos.FindByName(dataForm.getId()); // id로 이전에 아이디 사용 여부 확인
        if (presentMember.isPresent()){
            notSame = false;
        }
        return notSame;
    }
    // id로 해당 데이터를 불러올 수 있는 함수
    public Optional<DataForm> ShowIDMember(String id){
        Optional<DataForm> result = repos.FindByName(id);
        return result;
    }

    // 전체 id 목록을 보여주는 함수
    public List<DataForm> ShowAllMember(){
        List result = repos.FindAll();
        return result;
    }
}
