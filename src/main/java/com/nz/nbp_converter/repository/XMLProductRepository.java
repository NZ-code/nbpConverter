package com.nz.nbp_converter.repository;


public final class XMLProductRepository {
    private static volatile XMLProductRepository instance;

    private XMLProductRepository(){

    }
    public static XMLProductRepository getInstance(){
        if(instance != null){
            return instance;
        }
        synchronized (XMLProductRepository.class){
            if(instance == null){
                instance = new XMLProductRepository();
            }
            return instance;
        }

    }
}
