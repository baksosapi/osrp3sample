package org.smartregister.view.activity;

import android.content.Context;
import android.content.Intent;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.smartregister.BaseUnitTest;
import org.smartregister.CoreLibrary;
import org.smartregister.service.ZiggyService;
import org.smartregister.view.activity.mock.FormActivityMock;
import org.smartregister.view.controller.ANMLocationController;

import static org.mockito.Mockito.when;
import static org.smartregister.AllConstants.ENTITY_ID_PARAM;
import static org.smartregister.AllConstants.FIELD_OVERRIDES_PARAM;
import static org.smartregister.AllConstants.FORM_NAME_PARAM;
import static org.smartregister.view.activity.NativeECSmartRegisterActivityTest.locationJson;

/**
 * Created by kaderchowdhury on 12/11/17.
 */
@PowerMockIgnore({"javax.xml.*", "org.xml.sax.*", "org.w3c.dom.*", "org.springframework.context.*", "org.apache.log4j.*"})
public class FormActivityTest extends BaseUnitTest {

    private ActivityController<FormActivityMock> controller;

    @InjectMocks
    private FormActivityMock activity;

    @Mock
    private org.smartregister.Context context_;

    @Mock
    private Context applicationContext;

    @Mock
    private ANMLocationController anmLocationController;

    @Mock
    CoreLibrary coreLibrary;

    @Mock
    private ZiggyService ziggyService;

    @Before
    public void setUp() throws Exception {
        org.mockito.MockitoAnnotations.initMocks(this);
        CoreLibrary.init(context_);
        when(context_.applicationContext()).thenReturn(applicationContext);
        when(context_.anmLocationController()).thenReturn(anmLocationController);
        when(anmLocationController.get()).thenReturn(locationJson);
        FormActivityMock.setContext(context_);
        when(context_.ziggyService()).thenReturn(ziggyService);
        Intent intent = new Intent(RuntimeEnvironment.application, FormActivity.class);
        intent.putExtra(FORM_NAME_PARAM, "birthnotificationpregnancystatusfollowup");
        intent.putExtra(ENTITY_ID_PARAM, "entityID");
        intent.putExtra(FIELD_OVERRIDES_PARAM, "");
        controller = Robolectric.buildActivity(FormActivityMock.class, intent);
        activity = controller.get();
        controller.create()
                .start()
                .resume()
                .visible()
                .get();

    }

    @Test
    public void assertActivityNotNull() {
        Assert.assertNotNull(activity);
    }
}
