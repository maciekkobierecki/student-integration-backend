package com.student.integration.mappers;

import com.student.integration.ApplicationTests;
import com.student.integration.model.File;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FileMapperIT extends ApplicationTests {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void checkValidityOfCrudOperations(){
        File file = new File();
        file.setCreateUserId(122L);
        file.setRating(85L);
        file.setRatingCount(1222L);
        fileMapper.insertFile(file);
        File result = fileMapper.getFile(file.getId());
        fileMapper.updateFile(file.getId(), file.getName(), file.getContent());
        fileMapper.deleteFile(file.getId());
    }
}
