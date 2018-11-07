package com.student.integration.model

import com.student.integration.model.dto.FileDTO
import com.student.integration.model.entity.File
import org.modelmapper.ModelMapper
import spock.lang.Specification

class FileTest extends Specification{
    private static final ModelMapper modelMapper = new ModelMapper()

    def 'check File entity mapping to DTO and DTO to entity'(){
        given:
        File file = new File(id:10L, createUserId: 15L, rating: 80, ratingCount: 75)
        when:
        FileDTO fileDTO = modelMapper.map(file, FileDTO.class)
        File result = modelMapper.map(fileDTO, File.class)

        then:
        result.getId() == file.getId()
        result.getCreateUserId() == file.getCreateUserId()
        result.getRating() == file.getRating()
        result.getRatingCount() == file.getRatingCount()
    }
}
