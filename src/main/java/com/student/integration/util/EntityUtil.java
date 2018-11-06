package com.student.integration.util;

import com.google.api.services.drive.model.File;
import com.student.integration.model.DTO.*;
import com.student.integration.model.entity.Academy;
import com.student.integration.model.entity.Semester;
import com.student.integration.model.entity.Subject;
import com.student.integration.model.entity.User;
import org.modelmapper.ModelMapper;

public class EntityUtil {
    public static Academy toEntity(AcademyDTO academyDTO){
        academyDTO.getClass().getName();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(academyDTO, Academy.class);
    }

    public static File toEntity(FileDTO fileDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fileDTO, File.class);
    }
    public static Semester toEntity(SemesterDTO semesterDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(semesterDTO, Semester.class);
    }
    public static Subject toEntity(SubjectDTO subjectDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(subjectDTO, Subject.class);
    }
    public static User toEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}
