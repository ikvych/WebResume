package ikvych.resume.service;

import ikvych.resume.entity.Hobby;

import java.util.List;
import java.util.Set;

public interface StaticDataService {

    List<Integer> getYearsForEducation();

    Set<Hobby> listAllHobbies();
}
