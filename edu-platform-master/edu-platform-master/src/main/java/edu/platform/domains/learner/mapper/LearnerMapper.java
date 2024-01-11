package edu.platform.domains.learner.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.learner.model.entity.Learner;
import edu.platform.domains.learner.model.entity.LearnerMapping;
import edu.platform.domains.learner.model.request.LearnerSaveRequest;
import edu.platform.domains.learner.model.response.LearnerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LearnerMapper {

    public Learner to(LearnerSaveRequest request) {
        Learner learner = new Learner();
        BeanUtil.refine(request, learner, BeanUtil::copyNonNull);

        return learner;
    }

    public LearnerResponse to(Learner learner) {
        LearnerResponse response = new LearnerResponse();
        BeanUtil.refine(learner, response, BeanUtil::copyNonNull);

        return response;
    }
}
