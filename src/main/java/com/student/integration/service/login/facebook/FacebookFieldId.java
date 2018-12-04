package com.student.integration.service.login.facebook;

public enum FacebookFieldId {
    EMAIL("email"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name");

    private final String filedId;

    FacebookFieldId(String filedId){
        this.filedId = filedId;
    }

    public String toString(){
        return filedId;
    }
}
