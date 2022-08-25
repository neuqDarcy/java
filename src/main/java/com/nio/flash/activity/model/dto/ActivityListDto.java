package com.nio.flash.activity.model.dto;

import java.util.List;

public class ActivityListDto {
    List<AcitivityBrief> briefList;

    private class AcitivityBrief {
        private String name;
        private String palace;
        private long startTime;
    }
}
