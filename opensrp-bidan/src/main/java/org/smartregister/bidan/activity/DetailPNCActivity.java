package org.smartregister.bidan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.smartregister.Context;
import org.smartregister.bidan.R;
import org.smartregister.bidan.utils.Support;
import org.smartregister.commonregistry.AllCommonsRepository;
import org.smartregister.commonregistry.CommonPersonObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.repository.DetailsRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.smartregister.util.StringUtil.humanize;
import static org.smartregister.util.StringUtil.humanizeAndDoUPPERCASE;

/**
 * Created by sid-tech on 11/30/17.
 */

public class DetailPNCActivity extends Activity {

    //image retrieving
    private static final String TAG = DetailPNCActivity.class.getName();
    private static final String IMAGE_CACHE_DIR = "thumbs";
    public static CommonPersonObjectClient pncclient;
    //  private static KmsCalc  kmsCalc;
    private static int mImageThumbSize;
    private static int mImageThumbSpacing;
    private static String showbgm;
//    private static ImageFetcher mImageFetcher;

    //image retrieving
    SimpleDateFormat timer = new SimpleDateFormat("hh:mm:ss");
    private SimpleDateFormat fta;
    private SimpleDateFormat ftb;
    private View.OnClickListener bpmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            bpmAction();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = Context.getInstance();
        setContentView(R.layout.pnc_detail_activity);

        String DetailStart = timer.format(new Date());
        Map<String, String> Detail = new HashMap<String, String>();
        Detail.put("start", DetailStart);
        //FlurryAgent.logEvent("PNC_detail_view",Detail, true );

        final ImageView kiview = (ImageView) findViewById(R.id.tv_mother_detail_profile_view);
        //header
        TextView today = (TextView) findViewById(R.id.tv_detail_today);

        //profile
        TextView nama = (TextView) findViewById(R.id.tv_wife_name);
        TextView nik = (TextView) findViewById(R.id.tv_nik);
        TextView husband_name = (TextView) findViewById(R.id.tv_husband_name);
        TextView dob = (TextView) findViewById(R.id.tv_dob);
        TextView phone = (TextView) findViewById(R.id.tv_contact_phone_number);
        TextView risk1 = (TextView) findViewById(R.id.tv_risk1);
        TextView risk2 = (TextView) findViewById(R.id.tv_risk2);
        TextView risk3 = (TextView) findViewById(R.id.tv_risk3);
        TextView risk4 = (TextView) findViewById(R.id.tv_risk4);
//        TextView risk5 = (TextView) findViewById(R.id.txt_risk5);
//        TextView risk6 = (TextView) findViewById(R.id.txt_risk6);
//        TextView risk7 = (TextView) findViewById(R.id.txt_risk7);
//        TextView risk8 = (TextView) findViewById(R.id.txt_risk8);

//        ImageView heart_bpm = (ImageView) findViewById(R.id.icon_device);
        ImageView device = (ImageView) findViewById(R.id.iv_icon_device);
        device.setVisibility(View.VISIBLE);
        device.setOnClickListener(bpmListener);

        //detail data
        TextView txt_keadaanIbu = (TextView) findViewById(R.id.txt_keadaanIbu);
        TextView txt_keadaanBayi = (TextView) findViewById(R.id.txt_keadaanBayi);
        TextView txt_beratLahir = (TextView) findViewById(R.id.txt_beratLahir);
        TextView txt_persalinan = (TextView) findViewById(R.id.txt_persalinan);
        TextView txt_jamKalaIAktif = (TextView) findViewById(R.id.txt_jamKalaIAktif);
        TextView txt_jamKalaII = (TextView) findViewById(R.id.txt_jamKalaII);
        TextView txt_jamPlasentaLahir = (TextView) findViewById(R.id.txt_jamPlasentaLahir);
        TextView txt_perdarahanKalaIV2JamPostpartum = (TextView) findViewById(R.id.txt_perdarahanKalaIV2JamPostpartum);
        TextView txt_persentasi = (TextView) findViewById(R.id.txt_persentasi);
        TextView txt_tempatBersalin = (TextView) findViewById(R.id.txt_tempatBersalin);
        TextView txt_penolong = (TextView) findViewById(R.id.txt_penolong);
        TextView txt_caraPersalinanIbu = (TextView) findViewById(R.id.txt_caraPersalinanIbu);
        TextView txt_namaBayi = (TextView) findViewById(R.id.txt_namaBayi);
        TextView txt_jenisKelamin = (TextView) findViewById(R.id.txt_jenisKelamin);

        TextView txt_tanggalLahirAnak = (TextView) findViewById(R.id.txt_tanggalLahirAnak);
        TextView txt_hariKeKF = (TextView) findViewById(R.id.txt_hariKeKF);
        TextView txt_tandaVitalTDDiastolik = (TextView) findViewById(R.id.txt_tandaVitalTDDiastolik);
        TextView txt_tandaVitalTDSistolik = (TextView) findViewById(R.id.txt_tandaVitalTDSistolik);
        TextView txt_tandaVitalSuhu = (TextView) findViewById(R.id.txt_tandaVitalSuhu);
        TextView txt_pelayananfe = (TextView) findViewById(R.id.txt_pelayananfe);
        TextView txt_vitaminA2jamPP = (TextView) findViewById(R.id.txt_vitaminA2jamPP);
        TextView txt_vitaminA24jamPP = (TextView) findViewById(R.id.txt_vitaminA24jamPP);
        TextView txt_integrasiProgramAntiMalaria = (TextView) findViewById(R.id.txt_integrasiProgramAntiMalaria);
        TextView txt_integrasiProgramantitb = (TextView) findViewById(R.id.txt_integrasiProgramantitb);

        TextView txt_integrasiProgramFotoThorax = (TextView) findViewById(R.id.txt_integrasiProgramFotoThorax);
        TextView txt_komplikasi = (TextView) findViewById(R.id.txt_komplikasi);
        TextView txt_daruratNifas = (TextView) findViewById(R.id.txt_daruratNifas);
        TextView txt_penangananNifas = (TextView) findViewById(R.id.txt_penangananNifas);

        final TextView show_risk = (TextView) findViewById(R.id.tv_show_more);
        final TextView show_detail = (TextView) findViewById(R.id.tv_show_more_detail);

        //detail RISK
        TextView highRiskSTIBBVs = (TextView) findViewById(R.id.txt_highRiskSTIBBVs);
        TextView highRiskEctopicPregnancy = (TextView) findViewById(R.id.txt_highRiskEctopicPregnancy);
        TextView highRiskCardiovascularDiseaseRecord = (TextView) findViewById(R.id.txt_highRiskCardiovascularDiseaseRecord);
        TextView highRiskDidneyDisorder = (TextView) findViewById(R.id.txt_highRiskDidneyDisorder);
        TextView highRiskHeartDisorder = (TextView) findViewById(R.id.txt_highRiskHeartDisorder);
        TextView highRiskAsthma = (TextView) findViewById(R.id.txt_highRiskAsthma);
        TextView highRiskTuberculosis = (TextView) findViewById(R.id.txt_highRiskTuberculosis);
        TextView highRiskMalaria = (TextView) findViewById(R.id.txt_highRiskMalaria);
        TextView highRiskPregnancyPIH = (TextView) findViewById(R.id.txt_highRiskPregnancyPIH);
        TextView highRiskPregnancyProteinEnergyMalnutrition = (TextView) findViewById(R.id.txt_highRiskPregnancyProteinEnergyMalnutrition);

        TextView txt_highRiskLabourTBRisk = (TextView) findViewById(R.id.txt_highRiskLabourTBRisk);
        TextView txt_HighRiskLabourSectionCesareaRecord = (TextView) findViewById(R.id.txt_HighRiskLabourSectionCesareaRecord);
        TextView txt_highRisklabourFetusNumber = (TextView) findViewById(R.id.txt_highRisklabourFetusNumber);
        TextView txt_highRiskLabourFetusSize = (TextView) findViewById(R.id.txt_highRiskLabourFetusSize);
        TextView txt_lbl_highRiskLabourFetusMalpresentation = (TextView) findViewById(R.id.txt_lbl_highRiskLabourFetusMalpresentation);
        TextView txt_highRiskPregnancyAnemia = (TextView) findViewById(R.id.txt_highRiskPregnancyAnemia);
        TextView txt_highRiskPregnancyDiabetes = (TextView) findViewById(R.id.txt_highRiskPregnancyDiabetes);
        TextView HighRiskPregnancyTooManyChildren = (TextView) findViewById(R.id.txt_HighRiskPregnancyTooManyChildren);
        TextView highRiskPostPartumSectioCaesaria = (TextView) findViewById(R.id.txt_highRiskPostPartumSectioCaesaria);
        TextView highRiskPostPartumForceps = (TextView) findViewById(R.id.txt_highRiskPostPartumForceps);
        TextView highRiskPostPartumVacum = (TextView) findViewById(R.id.txt_highRiskPostPartumVacum);
        TextView highRiskPostPartumPreEclampsiaEclampsia = (TextView) findViewById(R.id.txt_highRiskPostPartumPreEclampsiaEclampsia);
        TextView highRiskPostPartumMaternalSepsis = (TextView) findViewById(R.id.txt_highRiskPostPartumMaternalSepsis);
        TextView highRiskPostPartumInfection = (TextView) findViewById(R.id.txt_highRiskPostPartumInfection);
        TextView highRiskPostPartumHemorrhage = (TextView) findViewById(R.id.txt_highRiskPostPartumHemorrhage);

        TextView highRiskPostPartumPIH = (TextView) findViewById(R.id.txt_highRiskPostPartumPIH);
        TextView highRiskPostPartumDistosia = (TextView) findViewById(R.id.txt_highRiskPostPartumDistosia);
        TextView txt_highRiskHIVAIDS = (TextView) findViewById(R.id.txt_highRiskHIVAIDS);


        ImageButton back = (ImageButton) findViewById(R.id.btn_back_to_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(DetailPNCActivity.this, PNCSmartRegisterActivity.class));
                overridePendingTransition(0, 0);
                String DetailEnd = timer.format(new Date());
                Map<String, String> Detail = new HashMap<String, String>();
                Detail.put("end", DetailEnd);
                //FlurryAgent.logEvent("PNC_detail_view", Detail, true);
            }
        });

        txt_keadaanIbu.setText(String.format(": %s", humanize(pncclient.getDetails().get("keadaanIbu") != null ? pncclient.getDetails().get("keadaanIbu") : "-")));
        txt_keadaanBayi.setText(String.format(": %s", humanize(pncclient.getDetails().get("keadaanBayi") != null ? pncclient.getDetails().get("keadaanBayi") : "-")));
        txt_beratLahir.setText(String.format(": %s", humanize(pncclient.getDetails().get("beratLahir") != null ? pncclient.getDetails().get("beratLahir") : "-")));
        txt_persalinan.setText(String.format(": %s", humanize(pncclient.getDetails().get("persalinan") != null ? pncclient.getDetails().get("persalinan") : "-")));
        txt_jamKalaIAktif.setText(String.format(": %s", humanize(pncclient.getDetails().get("jamKalaIAktif") != null ? pncclient.getDetails().get("jamKalaIAktif") : "-")));
        txt_jamKalaII.setText(String.format(": %s", humanize(pncclient.getDetails().get("jamKalaII") != null ? pncclient.getDetails().get("jamKalaII") : "-")));
        txt_jamPlasentaLahir.setText(String.format(": %s", humanize(pncclient.getDetails().get("jamPlasentaLahir") != null ? pncclient.getDetails().get("jamPlasentaLahir") : "-")));
        txt_perdarahanKalaIV2JamPostpartum.setText(String.format(": %s", humanize(pncclient.getDetails().get("perdarahanKalaIV2JamPostpartum") != null ? pncclient.getDetails().get("perdarahanKalaIV2JamPostpartum") : "-")));
        txt_persentasi.setText(String.format(": %s", pncclient.getDetails().get("persentasi") != null ? pncclient.getDetails().get("persentasi") : "-"));
        txt_tempatBersalin.setText(String.format(": %s", humanize(pncclient.getDetails().get("tempatBersalin") != null ? pncclient.getDetails().get("tempatBersalin") : "-")));
        txt_penolong.setText(String.format(": %s", humanize(pncclient.getDetails().get("penolong") != null ? pncclient.getDetails().get("penolong") : "-")));
        txt_caraPersalinanIbu.setText(String.format(": %s", humanize(pncclient.getDetails().get("caraPersalinanIbu") != null ? pncclient.getDetails().get("caraPersalinanIbu") : "-")));
        txt_namaBayi.setText(String.format(": %s", humanize(pncclient.getDetails().get("namaBayi") != null ? pncclient.getDetails().get("namaBayi") : "-")));
        txt_jenisKelamin.setText(String.format(": %s", humanize(pncclient.getDetails().get("jenisKelamin") != null ? pncclient.getDetails().get("jenisKelamin") : "-")));
        txt_tanggalLahirAnak.setText(String.format(": %s", humanize(pncclient.getDetails().get("anak.tanggalLahirAnak") != null ? pncclient.getDetails().get("anak.tanggalLahirAnak") : "-")));

        txt_tandaVitalSuhu.setText(String.format(": %s", humanize(pncclient.getDetails().get("tandaVitalSuhu") != null ? pncclient.getDetails().get("tandaVitalSuhu") : "-")));
        txt_pelayananfe.setText(String.format(": %s", humanize(pncclient.getDetails().get("pelayananfe") != null ? pncclient.getDetails().get("pelayananfe") : "-")));
        txt_vitaminA2jamPP.setText(String.format(": %s", humanize(pncclient.getDetails().get("vitaminA2jamPP") != null ? pncclient.getDetails().get("vitaminA2jamPP") : "-")));
        txt_vitaminA24jamPP.setText(String.format(": %s", humanize(pncclient.getDetails().get("vitaminA24jamPP") != null ? pncclient.getDetails().get("vitaminA24jamPP") : "-")));
        txt_integrasiProgramAntiMalaria.setText(String.format(": %s", humanize(pncclient.getDetails().get("integrasiProgramAntiMalaria") != null ? pncclient.getDetails().get("integrasiProgramAntiMalaria") : "-")));
        txt_integrasiProgramantitb.setText(String.format(": %s", humanize(pncclient.getDetails().get("integrasiProgramantitb") != null ? pncclient.getDetails().get("integrasiProgramantitb") : "-")));

        txt_integrasiProgramFotoThorax.setText(String.format(": %s", humanize(pncclient.getDetails().get("integrasiProgramFotoThorax") != null ? pncclient.getDetails().get("integrasiProgramFotoThorax") : "-")));
        txt_komplikasi.setText(String.format(": %s", humanize(pncclient.getDetails().get("komplikasi") != null ? pncclient.getDetails().get("komplikasi") : "-")));
        txt_daruratNifas.setText(String.format(": %s", humanize(pncclient.getDetails().get("daruratNifas") != null ? pncclient.getDetails().get("daruratNifas") : "-")));
        txt_penangananNifas.setText(String.format(": %s", humanize(pncclient.getDetails().get("penangananNifas") != null ? pncclient.getDetails().get("penangananNifas") : "-")));

        //risk detail

        txt_lbl_highRiskLabourFetusMalpresentation.setText(humanize(pncclient.getDetails().get("highRiskLabourFetusMalpresentation") != null ? pncclient.getDetails().get("highRiskLabourFetusMalpresentation") : "-"));
        txt_highRisklabourFetusNumber.setText(humanize(pncclient.getDetails().get("highRisklabourFetusNumber") != null ? pncclient.getDetails().get("highRisklabourFetusNumber") : "-"));
        txt_highRiskLabourFetusSize.setText(humanize(pncclient.getDetails().get("highRiskLabourFetusSize") != null ? pncclient.getDetails().get("highRiskLabourFetusSize") : "-"));
        //   txt_highRiskLabourTBRisk.setText(humanize(pncclient.getDetails().get("highRiskLabourTBRisk") != null ? pncclient.getDetails().get("highRiskLabourTBRisk") : "-"));
        highRiskPregnancyProteinEnergyMalnutrition.setText(humanize(pncclient.getDetails().get("highRiskPregnancyProteinEnergyMalnutrition") != null ? pncclient.getDetails().get("highRiskPregnancyProteinEnergyMalnutrition") : "-"));
        highRiskPregnancyPIH.setText(humanize(pncclient.getDetails().get("highRiskPregnancyPIH") != null ? pncclient.getDetails().get("highRiskPregnancyPIH") : "-"));
        txt_highRiskPregnancyDiabetes.setText(humanize(pncclient.getDetails().get("highRiskPregnancyDiabetes") != null ? pncclient.getDetails().get("highRiskPregnancyDiabetes") : "-"));
        txt_highRiskPregnancyAnemia.setText(humanize(pncclient.getDetails().get("highRiskPregnancyAnemia") != null ? pncclient.getDetails().get("highRiskPregnancyAnemia") : "-"));

        highRiskPostPartumSectioCaesaria.setText(humanize(pncclient.getDetails().get("highRiskPostPartumSectioCaesaria") != null ? pncclient.getDetails().get("highRiskPostPartumSectioCaesaria") : "-"));
        highRiskPostPartumForceps.setText(humanize(pncclient.getDetails().get("highRiskPostPartumForceps") != null ? pncclient.getDetails().get("highRiskPostPartumForceps") : "-"));
        highRiskPostPartumVacum.setText(humanize(pncclient.getDetails().get("highRiskPostPartumVacum") != null ? pncclient.getDetails().get("highRiskPostPartumVacum") : "-"));
        highRiskPostPartumPreEclampsiaEclampsia.setText(humanize(pncclient.getDetails().get("highRiskPostPartumPreEclampsiaEclampsia") != null ? pncclient.getDetails().get("highRiskPostPartumPreEclampsiaEclampsia") : "-"));
        highRiskPostPartumMaternalSepsis.setText(humanize(pncclient.getDetails().get("highRiskPostPartumMaternalSepsis") != null ? pncclient.getDetails().get("highRiskPostPartumMaternalSepsis") : "-"));
        highRiskPostPartumInfection.setText(humanize(pncclient.getDetails().get("highRiskPostPartumInfection") != null ? pncclient.getDetails().get("highRiskPostPartumInfection") : "-"));
        highRiskPostPartumHemorrhage.setText(humanize(pncclient.getDetails().get("highRiskPostPartumHemorrhage") != null ? pncclient.getDetails().get("highRiskPostPartumHemorrhage") : "-"));
        highRiskPostPartumPIH.setText(humanize(pncclient.getDetails().get("highRiskPostPartumPIH") != null ? pncclient.getDetails().get("highRiskPostPartumPIH") : "-"));
        highRiskPostPartumDistosia.setText(humanize(pncclient.getDetails().get("highRiskPostPartumDistosia") != null ? pncclient.getDetails().get("highRiskPostPartumDistosia") : "-"));

        AllCommonsRepository kiRepository = Context.getInstance().allCommonsRepositoryobjects("ec_ibu");

        CommonPersonObject kiobject = kiRepository.findByCaseID(pncclient.entityId());

        AllCommonsRepository iburep = org.smartregister.Context.getInstance().allCommonsRepositoryobjects("ec_kartu_ibu");

        final CommonPersonObject ibuparent = iburep.findByCaseID(kiobject.getColumnmaps().get("base_entity_id"));

        DetailsRepository detailsRepository = org.smartregister.Context.getInstance().detailsRepository();
        detailsRepository.updateDetails(ibuparent);
        // Set Image
//        DrishtiApplication.getCachedImageLoaderInstance().getImageByClientId(ibuparent.getCaseId(), OpenSRPImageLoader.getStaticImageListener(kiview, R.mipmap.woman_placeholder, R.mipmap.woman_placeholder));

        Support.setImagetoHolderFromUri(this,
                pncclient.getDetails().get("base_entity_id"),
                kiview, R.mipmap.woman_placeholder);

        txt_hariKeKF.setText(String.format(": %s", humanizeAndDoUPPERCASE(kiobject.getColumnmaps().get("hariKeKF") != null ? kiobject.getColumnmaps().get("hariKeKF") : "-")));

        txt_tandaVitalTDSistolik.setText(String.format(": %s", humanize(ibuparent.getDetails().get("tandaVitalTDSistolik") != null ? ibuparent.getDetails().get("tandaVitalTDSistolik") : "-")));
        txt_tandaVitalTDDiastolik.setText(String.format(": %s", humanize(ibuparent.getDetails().get("tandaVitalTDDiastolik") != null ? ibuparent.getDetails().get("tandaVitalTDDiastolik") : "-")));

        nama.setText(String.format("%s%s", getResources().getString(R.string.name), humanize(ibuparent.getColumnmaps().get("namalengkap") != null ? ibuparent.getColumnmaps().get("namalengkap") : "-")));
        nik.setText(String.format("%s%s", getResources().getString(R.string.nik), humanize(ibuparent.getDetails().get("nik") != null ? ibuparent.getDetails().get("nik") : "-")));
        husband_name.setText(String.format("%s%s", getResources().getString(R.string.husband_name), humanize(ibuparent.getColumnmaps().get("namaSuami") != null ? ibuparent.getColumnmaps().get("namaSuami") : "-")));
        String tgl = ibuparent.getDetails().get("tanggalLahir") != null ? ibuparent.getDetails().get("tanggalLahir") : "-";
//        String tgl_lahir = tgl.substring(0, tgl.indexOf("T"));
        String tgl_lahir = "null";
        if (tgl != null && !tgl.isEmpty()) {
            tgl_lahir = tgl.substring(0, tgl.indexOf("T"));
        }
        dob.setText(String.format("%s%s", getResources().getString(R.string.dob), tgl_lahir));
        //dob.setText(getResources().getString(R.string.dob)+ humanize(ibuparent.getDetails().get("tanggalLahir") != null ? ibuparent.getDetails().get("tanggalLahir") : "-"));
        phone.setText(String.format("No HP: %s", ibuparent.getDetails().get("NomorTelponHp") != null ? ibuparent.getDetails().get("NomorTelponHp") : "-"));

        //risk
        if (ibuparent.getDetails().get("highRiskPregnancyYoungMaternalAge") != null) {
            risk1.setText(String.format("%s%s", getResources().getString(R.string.highRiskPregnancyYoungMaternalAge), humanize(kiobject.getDetails().get("highRiskPregnancyYoungMaternalAge"))));
        }
        if (ibuparent.getDetails().get("highRiskPregnancyOldMaternalAge") != null) {
            risk1.setText(String.format("%s%s", getResources().getString(R.string.highRiskPregnancyOldMaternalAge), humanize(kiobject.getDetails().get("highRiskPregnancyYoungMaternalAge"))));
        }
        if (ibuparent.getDetails().get("highRiskPregnancyProteinEnergyMalnutrition") != null
                || ibuparent.getDetails().get("HighRiskPregnancyAbortus") != null
                || ibuparent.getDetails().get("HighRiskLabourSectionCesareaRecord") != null
                ) {
            risk2.setText(String.format("%s%s", getResources().getString(R.string.highRiskPregnancyProteinEnergyMalnutrition), humanize(ibuparent.getDetails().get("highRiskPregnancyProteinEnergyMalnutrition"))));
            risk3.setText(String.format("%s%s", getResources().getString(R.string.HighRiskPregnancyAbortus), humanize(ibuparent.getDetails().get("HighRiskPregnancyAbortus"))));
            risk4.setText(String.format("%s%s", getResources().getString(R.string.HighRiskLabourSectionCesareaRecord), humanize(ibuparent.getDetails().get("HighRiskLabourSectionCesareaRecord"))));

        }
        txt_highRiskLabourTBRisk.setText(humanize(ibuparent.getDetails().get("highRiskLabourTBRisk") != null ? ibuparent.getDetails().get("highRiskLabourTBRisk") : "-"));

        highRiskSTIBBVs.setText(humanize(ibuparent.getDetails().get("highRiskSTIBBVs") != null ? ibuparent.getDetails().get("highRiskSTIBBVs") : "-"));
        highRiskEctopicPregnancy.setText(humanize(ibuparent.getDetails().get("highRiskEctopicPregnancy") != null ? ibuparent.getDetails().get("highRiskEctopicPregnancy") : "-"));
        highRiskCardiovascularDiseaseRecord.setText(humanize(ibuparent.getDetails().get("highRiskCardiovascularDiseaseRecord") != null ? ibuparent.getDetails().get("highRiskCardiovascularDiseaseRecord") : "-"));
        highRiskDidneyDisorder.setText(humanize(ibuparent.getDetails().get("highRiskDidneyDisorder") != null ? ibuparent.getDetails().get("highRiskDidneyDisorder") : "-"));
        highRiskHeartDisorder.setText(humanize(ibuparent.getDetails().get("highRiskHeartDisorder") != null ? ibuparent.getDetails().get("highRiskHeartDisorder") : "-"));
        highRiskAsthma.setText(humanize(ibuparent.getDetails().get("highRiskAsthma") != null ? ibuparent.getDetails().get("highRiskAsthma") : "-"));
        highRiskTuberculosis.setText(humanize(ibuparent.getDetails().get("highRiskTuberculosis") != null ? ibuparent.getDetails().get("highRiskTuberculosis") : "-"));
        highRiskMalaria.setText(humanize(ibuparent.getDetails().get("highRiskMalaria") != null ? ibuparent.getDetails().get("highRiskMalaria") : "-"));

        txt_HighRiskLabourSectionCesareaRecord.setText(humanize(ibuparent.getDetails().get("HighRiskLabourSectionCesareaRecord") != null ? ibuparent.getDetails().get("HighRiskLabourSectionCesareaRecord") : "-"));
        HighRiskPregnancyTooManyChildren.setText(humanize(ibuparent.getDetails().get("HighRiskPregnancyTooManyChildren") != null ? ibuparent.getDetails().get("HighRiskPregnancyTooManyChildren") : "-"));

        txt_highRiskHIVAIDS.setText(humanize(pncclient.getDetails().get("highRiskHIVAIDS") != null ? pncclient.getDetails().get("highRiskHIVAIDS") : "-"));

        show_risk.setText(getResources().getString(R.string.show_more_button));
        show_detail.setText(getResources().getString(R.string.show_less_button));

        show_risk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FlurryFacade.logEvent("click_risk_detail");
                findViewById(R.id.id1).setVisibility(View.GONE);
                findViewById(R.id.id2).setVisibility(View.VISIBLE);
                findViewById(R.id.tv_show_more_detail).setVisibility(View.VISIBLE);
                findViewById(R.id.tv_show_more).setVisibility(View.GONE);
            }
        });

        show_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.id1).setVisibility(View.VISIBLE);
                findViewById(R.id.id2).setVisibility(View.GONE);
                findViewById(R.id.tv_show_more).setVisibility(View.VISIBLE);
                findViewById(R.id.tv_show_more_detail).setVisibility(View.GONE);
            }
        });

        txt_tandaVitalTDSistolik.setOnClickListener(bpmListener);
        txt_tandaVitalTDDiastolik.setOnClickListener(bpmListener);

    }

}
