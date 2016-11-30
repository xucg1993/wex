package com.xuc.wex.service.interfaces.coach;

import com.xuc.wex.model.coach.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoachService {
    public List<Coach> findCoachList(Coach coach);

}
