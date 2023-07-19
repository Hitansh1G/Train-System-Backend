package com.geektrust.example.geektrust.repositories;

import javax.xml.crypto.Data;

public interface IDataRepository extends CRUDRepository<Data,String>{
    void loadData();    
}
