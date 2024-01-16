package digit.validators;

import digit.repository.BirthRegistrationRepository;
import digit.web.models.BirthApplicationSearchCriteria;
import digit.web.models.BirthRegistrationApplication;
import digit.web.models.BirthRegistrationRequest;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BirthApplicationValidator {

    @Autowired
    private BirthRegistrationRepository repository;

    public void validateBirthApplication(BirthRegistrationRequest birthRegistrationRequest) {
        birthRegistrationRequest.getBirthRegistrationApplications().forEach(application -> {
            if (ObjectUtils.isEmpty(application)) {
                throw new CustomException("EG_BT_APP_ERR", "Birth registration application cannot be null");
            }

            if (ObjectUtils.isEmpty(application.getTenantId())) {
                throw new CustomException("EG_BT_APP_ERR", "tenantId is mandatory for creating birth registration applications");
            }

            //Checks if at least one of the parent name is provided in the application
            if((application.getFather().getName() == null) && (application.getMother().getName() == null)){
                throw new CustomException("EG_BT_APP_ERR","One of the Parent's name is required");
            }
        });
    }

    public List<BirthRegistrationApplication> validateApplicationUpdateRequest(BirthRegistrationRequest birthRegistrationRequest) {
        List<String> ids = birthRegistrationRequest.getBirthRegistrationApplications().stream().map(BirthRegistrationApplication::getId).collect(Collectors.toList());
        List<BirthRegistrationApplication> birthRegistrationApplications = repository.getApplications(BirthApplicationSearchCriteria.builder().ids(ids).build());
        if(birthRegistrationApplications.size() != ids.size())
            throw new CustomException("APPLICATION_DOES_NOT_EXIST", "One of the application ids does not exist.");
        return birthRegistrationApplications;
    }
}
