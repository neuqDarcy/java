package com.nio.flash.activity.model.dto.response;

import java.util.List;

public class ActivityListResDto {
    List<AcitivityBrief> briefList;

    private class AcitivityBrief {
        private String name;
        private String palace;
        private long startTime;
    }
}
