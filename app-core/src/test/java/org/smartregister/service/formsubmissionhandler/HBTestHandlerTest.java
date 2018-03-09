package org.smartregister.service.formsubmissionhandler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.smartregister.domain.form.FormSubmission;
import org.smartregister.service.MotherService;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.smartregister.util.FormSubmissionBuilder.create;

@RunWith(RobolectricTestRunner.class)
public class HBTestHandlerTest {
    @Mock
    private MotherService motherService;

    private HBTestHandler handler;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        handler = new HBTestHandler(motherService);
    }

    @Test
    public void shouldDelegateFormSubmissionHandlingToMotherService() throws Exception {
        FormSubmission submission = create().withFormName("tt_test").withInstanceId("instance id 1").withVersion("122").build();

        handler.handle(submission);

        verify(motherService).hbTest(submission);
    }
}