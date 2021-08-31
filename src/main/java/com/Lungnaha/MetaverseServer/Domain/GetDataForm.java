package com.Lungnaha.MetaverseServer.Domain;

// HTML을 통해서 받을 데이터 형식을 따로 지정하는 부분
public class GetDataForm {
    private String id;
    private String password;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
