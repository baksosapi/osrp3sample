package org.smartregister.service.formsubmissionhandler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.smartregister.domain.form.FormSubmission;
import org.smartregister.service.EligibleCoupleService;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.smartregister.util.FormSubmissionBuilder.create;

@RunWith(RobolectricTestRunner.class)
public class FPChangeHandlerTest {
    @Mock
    private EligibleCoupleService ecService;

    private FPChangeHandler handler;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        handler = new FPChangeHandler(ecService);
    }

    @Test
    public void shouldDelegateFormSubmissionHandlingToECService() throws Exception {
        FormSubmission submission = create().withFormName("ec_registration").withInstanceId("instance id 1").withVersion("122").build();

        handler.handle(submission);

        verify(ecService).fpChange(submission);
    }

}
