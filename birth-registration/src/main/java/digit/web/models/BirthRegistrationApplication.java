package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Address;
import digit.web.models.Applicant;
import digit.web.models.AuditDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

/**
 * A Object holds the basic data for a Birth Registration Application
 */
@ApiModel(description = "A Object holds the basic data for a Birth Registration Application")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-01-04T10:41:04.566+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BirthRegistrationApplication   {

        @Valid
        @JsonProperty("workflow")
        private Workflow workflow = null;

        @JsonProperty("id")
        private String id = null;

        @JsonProperty("tenantId")
        private String tenantId = null;

        @JsonProperty("applicationNumber")
        private String applicationNumber = null;

        @NotNull(message = "Name cannot be null")
        @JsonProperty("babyFirstName")
        private String babyFirstName = null;

        @JsonProperty("babyLastName")
        private String babyLastName = null;

        @JsonProperty("fatherOfApplicant")
        private FatherApplicant father = null;

        @JsonProperty("motherOfApplicant")
        private MotherApplicant mother = null;

        @JsonProperty("fatherMobileNumber")
        private String fatherMobileNumber = null;

        @JsonProperty("motherMobileNumber")
        private String motherMobileNumber = null;

        @JsonProperty("doctorName")
        private String doctorName = null;

        @JsonProperty("hospitalName")
        private String hospitalName = null;

        @JsonProperty("placeOfBirth")
        private String placeOfBirth = null;

        @JsonProperty("timeOfBirth")
        private Integer timeOfBirth = null;

        @JsonProperty("address")
        private Address address = null;

        @JsonProperty("applicant")
        private Applicant applicant = null;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails = null;


}

