package com.Lungnaha.MetaverseServer.Domain;

public class DataForm {
    // 데이터 형식을 지정하는 부분
    private int num;
    private String id;
    private String password;
    
    // 각 변수에 알맞는 getter, setter 구현
    public int getNum(){
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
