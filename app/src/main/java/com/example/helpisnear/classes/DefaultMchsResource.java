package com.example.helpisnear.classes;

import com.example.helpisnear.enums.MyLanguage;
import com.example.helpisnear.enums.TypeResourse;

import java.util.ArrayList;

public class DefaultMchsResource {

    private static final String TAG = "myLogs";

    private ArrayList<UnitMchsResource> unitMchsResources_WhatToDo = new ArrayList<>();
    private ArrayList<UnitMchsResource> unitMchsResources_FirstAid = new ArrayList<>();;
    private ArrayList<UnitMchsResource> unitMchsResources_Encyclopedia = new ArrayList<>();;
    private ArrayList<UnitMchsResource> unitMchsResources_InformationAndSettings = new ArrayList<>();;

    public DefaultMchsResource(MyLanguage language) {

        switch (language){
            case RU:
                unitMchsResources_WhatToDo = init_WhatToDo_RU();
                unitMchsResources_FirstAid = init_FirstAid_RU();
                unitMchsResources_Encyclopedia = init_Encyclopedia_RU();
                unitMchsResources_InformationAndSettings = init_InformationAndSettings_RU();
                break;
            case EN:
                unitMchsResources_WhatToDo = init_WhatToDo_EN();
                unitMchsResources_FirstAid = init_FirstAid_EN();
                unitMchsResources_Encyclopedia = init_Encyclopedia_EN();
                unitMchsResources_InformationAndSettings = init_InformationAndSettings_EN();
                break;
            case UZ_LT:
                unitMchsResources_WhatToDo = init_WhatToDo_UZ_LT();
                unitMchsResources_FirstAid = init_FirstAid_UZ_LT();
                unitMchsResources_Encyclopedia = init_Encyclopedia_UZ_LT();
                unitMchsResources_InformationAndSettings = init_InformationAndSettings_UZ_LT();
                break;
            case UZ_KR:
                unitMchsResources_WhatToDo = init_WhatToDo_UZ_KR();
                unitMchsResources_FirstAid = init_FirstAid_UZ_KR();
                unitMchsResources_Encyclopedia = init_Encyclopedia_UZ_KR();
                unitMchsResources_InformationAndSettings = init_InformationAndSettings_UZ_KR();
        }
    }

    /**
     * lang RU
     */

    private ArrayList<UnitMchsResource> init_WhatToDo_RU(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        String initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_FirstAid_RU(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        String initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_Encyclopedia_RU(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        String initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_InformationAndSettings_RU(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.ONLY_PDF;
        String namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        String initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource);

        list.add(unitMchsResource);


        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Признаки_возникновения_биологической_угрозы.pdf";
        initAdress = "https://yadi.sk/i/ylRoPkWLPLCNKQ";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);

        return list;
    }

    /**
     * lang EN
     */
    private ArrayList<UnitMchsResource> init_WhatToDo_EN(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Signs_of_a_biological_threat.pdf";
        String initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Signs_of_a_biological_threat.pdf";
        initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_FirstAid_EN(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Signs_of_a_biological_threat.pdf";
        String initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Signs_of_a_biological_threat.pdf";
        initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_Encyclopedia_EN(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Signs_of_a_biological_threat.pdf";
        String initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Signs_of_a_biological_threat.pdf";
        initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_InformationAndSettings_EN(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.ONLY_PDF;
        String namePdf = "Signs_of_a_biological_threat.pdf";
        String initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource);

        list.add(unitMchsResource);

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Signs_of_a_biological_threat.pdf";
        initAdress = "https://yadi.sk/i/8gkMfKRd8zQZUw";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);

        return list;
    }

    /**
     * lang UZ_LT
     */
    private ArrayList<UnitMchsResource> init_WhatToDo_UZ_LT(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Biologik_tahdidning_alomatlari.pdf";
        String initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Biologik_tahdidning_alomatlari.pdf";
        initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_FirstAid_UZ_LT(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Biologik_tahdidning_alomatlari.pdf";
        String initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Biologik_tahdidning_alomatlari.pdf";
        initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_Encyclopedia_UZ_LT(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Biologik_tahdidning_alomatlari.pdf";
        String initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Biologik_tahdidning_alomatlari.pdf";
        initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_InformationAndSettings_UZ_LT(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.ONLY_PDF;
        String namePdf = "Biologik_tahdidning_alomatlari.pdf";
        String initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource);

        list.add(unitMchsResource);

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Biologik_tahdidning_alomatlari.pdf";
        initAdress = "https://yadi.sk/i/iNztyjXa05JiAQ";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);

        return list;
    }

    /**
     * lang UZ_KR
     */
    private ArrayList<UnitMchsResource> init_WhatToDo_UZ_KR(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Биологик_тахдиднинг_аломати.pdf";
        String initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Биологик_тахдиднинг_аломати.pdf";
        initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_FirstAid_UZ_KR(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Биологик_тахдиднинг_аломати.pdf";
        String initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img2_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img3_WhatToDo.png";
        initAdress = "https://yadi.sk/i/JlXAzgfgPZb7WQ";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Биологик_тахдиднинг_аломати.pdf";
        initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_Encyclopedia_UZ_KR(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.PDF_PNG;
        String namePdf = "Биологик_тахдиднинг_аломати.pdf";
        String initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        ArrayList<UnitResource> temp = new ArrayList<>();
        String namePng = "img1_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);

        list.add(unitMchsResource);
        temp.clear();

        typeResourse = TypeResourse.PDF_PNG;
        namePdf = "Биологик_тахдиднинг_аломати.pdf";
        initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        unitResource = new UnitResource(namePdf, initAdress);

        temp = new ArrayList<>();
        namePng = "img4_WhatToDo.png";
        initAdress = "https://yadi.sk/i/Lkn3E8uPwu-1lA";
        temp.add(new UnitResource(namePng, initAdress));

        namePng = "img5_WhatToDo.png";
        initAdress = "https://yadi.sk/i/-__qamnG8_RByA";
        temp.add(new UnitResource(namePng, initAdress));

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource, temp);
        list.add(unitMchsResource);
        temp.clear();

        return list;
    }

    private ArrayList<UnitMchsResource> init_InformationAndSettings_UZ_KR(){
        ArrayList<UnitMchsResource> list = new ArrayList<>();

        TypeResourse typeResourse = TypeResourse.ONLY_PDF;
        String namePdf = "Биологик_тахдиднинг_аломати.pdf";
        String initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        UnitResource unitResource = new UnitResource(namePdf, initAdress);

        UnitMchsResource unitMchsResource = new UnitMchsResource(typeResourse, unitResource);

        list.add(unitMchsResource);

        typeResourse = TypeResourse.ONLY_PDF;
        namePdf = "Биологик_тахдиднинг_аломати.pdf";
        initAdress = "https://yadi.sk/i/6VeNdDMH38L1aw";

        unitResource = new UnitResource(namePdf, initAdress);

        unitMchsResource = new UnitMchsResource(typeResourse, unitResource);
        list.add(unitMchsResource);

        return list;
    }

    public ArrayList<UnitMchsResource> getUnitMchsResources_WhatToDo() {
        return unitMchsResources_WhatToDo;
    }

    public ArrayList<UnitMchsResource> getUnitMchsResources_FirstAid() {
        return unitMchsResources_FirstAid;
    }

    public ArrayList<UnitMchsResource> getUnitMchsResources_Encyclopedia() {
        return unitMchsResources_Encyclopedia;
    }

    public ArrayList<UnitMchsResource> getUnitMchsResources_InformationAndSettings() {
        return unitMchsResources_InformationAndSettings;
    }
}
