package edu.platform.domains.learner.service;

import edu.platform.domains.learner.model.request.*;
import edu.platform.domains.learner.model.response.LearnerGetListResponse;
import edu.platform.domains.learner.model.response.LearnerResponse;

public interface LearnerService {
    LearnerResponse save(LearnerSaveRequest request);

    void active(Long learnerId, LearnerActiveRequest request);

    LearnerResponse auth(LearnerAuthRequest request);

    void mappingAdultAccount(LearnerMappingRequest request);

    void confirmMappingAdultAccount(LearnerConfirmMappingRequest request);

    LearnerGetListResponse getList(LearnerGetListRequest request);
}
