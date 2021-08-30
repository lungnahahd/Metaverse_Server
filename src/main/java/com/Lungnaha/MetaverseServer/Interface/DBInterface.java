package com.Lungnaha.MetaverseServer.Interface;

import com.Lungnaha.MetaverseServer.Domain.DataForm;

import java.util.List;
import java.util.Optional;

// 메모리에 저장하거나 DB에 저장하는 기능 등 다양한 구현을 위해서 인터페이스를 활용
public interface DBInterface {
    DataForm Save(DataForm dataForm); // 저장 기능
    Optional<DataForm> FindByName(String id); // 이름으로 찾기 기능
    List<DataForm> FindAll(); // 전체 리스트를 출력하는 기능
}
