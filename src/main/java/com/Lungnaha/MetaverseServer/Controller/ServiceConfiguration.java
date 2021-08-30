package com.Lungnaha.MetaverseServer.Controller;

import com.Lungnaha.MetaverseServer.Repository.TemplateJDBC;
import com.Lungnaha.MetaverseServer.Service.DataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


// Controller 외에도 이를 보면 Spring Bean에 같이 올려주기에 여기서 Service나 저장소를 올리는 작업 가능
@Configuration
public class ServiceConfiguration {
    private final DataSource dataSource;

    public ServiceConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Bean // 저장소를 Spring Bean에 올리기
    public TemplateJDBC templateJDBC(){
        return new TemplateJDBC(dataSource);
    }
    
    @Bean // Service를 Spring Bean에 올리기
    public DataService dataService(){
        return new DataService(templateJDBC());
    }
    
    
}
