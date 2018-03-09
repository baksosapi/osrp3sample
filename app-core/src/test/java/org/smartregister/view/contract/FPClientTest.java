package org.smartregister.view.contract;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.smartregister.Context;
import org.smartregister.CoreLibrary;
import org.smartregister.R;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
public class FPClientTest {

    @Mock
    private Context context;

    private FPClient fpClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        CoreLibrary.init(context);
        fpClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
    }

    @Test
    public void shouldReturnTheReferralFollowUpAlert() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("FP Referral Followup", "normal", "2013-02-02")
                , new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
        )).withFPMethod("female_sterilization");
        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_referral)).thenReturn("referral");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("FP Referral Followup", "normal", "2013-02-02")
                , new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("FP Followup", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization")
                .withRefillFollowUps(new RefillFollowUps("FP Referral Followup", new AlertDTO("FP Referral Followup", "normal", "2013-02-02"), "referral"));

        RefillFollowUps expectedRefillFollowUps = expectedFPClient.refillFollowUps();
        RefillFollowUps refillFollowUps = fpClient.refillFollowUps();

        Assert.assertEquals(expectedRefillFollowUps.name(), refillFollowUps.name());
        Assert.assertEquals(expectedRefillFollowUps.type(), refillFollowUps.type());
        Assert.assertEquals(expectedRefillFollowUps.alert().name(), refillFollowUps.alert().name());
        Assert.assertEquals(expectedRefillFollowUps.alert().status(), refillFollowUps.alert().status());
        Assert.assertEquals(expectedRefillFollowUps.alert().date(), refillFollowUps.alert().date());
    }

    @Test
    public void shouldSetFPFollowupDataIfAFPFollowupExistsAndReferralAlertDoesNotExist() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("FP Followup", "normal", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization");
        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_follow_up)).thenReturn("follow-up");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
                , new AlertDTO("FP Followup", "normal", "2013-02-02")))
                .withFPMethod("female_sterilization")
                .withRefillFollowUps(new RefillFollowUps("FP Followup", new AlertDTO("FP Followup", "normal", "2013-02-02"), "follow-up"));

        Assert.assertEquals(expectedFPClient.refillFollowUps(), fpClient.refillFollowUps());
    }

    @Test
    public void shouldSetFemaleSterilizationFollowUpDataWhenAFemaleSterilizationAlertExitsAndReferralDataAndFPFollowUpIsNotSpecified() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization");

        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_follow_up)).thenReturn("follow-up");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization")
                .withRefillFollowUps(new RefillFollowUps("Female sterilization Followup 1", new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02"), "follow-up"));

        Assert.assertEquals(expectedFPClient.refillFollowUps(), fpClient.refillFollowUps());
    }

    @Test
    public void shouldOnlySetFemaleSterilizationFollowUpDataWhenFPMethodIsAlsoFemaleSterilization() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization");
        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_follow_up)).thenReturn("follow-up");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "urgent", "2013-02-02")
                , new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")))
                .withFPMethod("female_sterilization")
                .withRefillFollowUps(new RefillFollowUps("Female sterilization Followup 1", new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02"), "follow-up"));

        Assert.assertEquals(expectedFPClient.refillFollowUps(), fpClient.refillFollowUps());
    }

    @Test
    public void shouldSetCondomRefillDataOnlyIfFPMethodIsAlsoCondom() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Condom Refill", "urgent", "2013-02-02")))
                .withFPMethod("condom");

        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_refill)).thenReturn("refill");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                , new AlertDTO("Condom Refill", "urgent", "2013-02-02")))
                .withFPMethod("condom")
                .withRefillFollowUps(new RefillFollowUps("Condom Refill", new AlertDTO("Condom Refill", "urgent", "2013-02-02"), "refill"));

        Assert.assertEquals(expectedFPClient.refillFollowUps(), fpClient.refillFollowUps());
    }

    @Test
    public void shouldSetCondomRefillDataOverSterilisationDataIfFPMethodIsCondomAndNotAnyOfSterilizationMethods() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
                , new AlertDTO("Condom Refill", "urgent", "2013-02-02")))
                .withFPMethod("condom");

        Mockito.when(CoreLibrary.getInstance().context().getStringResource(R.string.str_refill)).thenReturn("refill");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
                , new AlertDTO("Condom Refill", "urgent", "2013-02-02")))
                .withFPMethod("condom")
                .withRefillFollowUps(new RefillFollowUps("Condom Refill", new AlertDTO("Condom Refill", "urgent", "2013-02-02"), "refill"));

        Assert.assertEquals(expectedFPClient.refillFollowUps(), fpClient.refillFollowUps());
    }
}