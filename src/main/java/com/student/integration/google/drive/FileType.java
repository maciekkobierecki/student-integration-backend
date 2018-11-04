package com.student.integration.google.drive;

public enum FileType {
    GOOGLE_DOCS("text/plain");

    private final String type;
    private FileType(String type){
        this.type = type;
    }

    public String toString(){
        return type;
    }
}
