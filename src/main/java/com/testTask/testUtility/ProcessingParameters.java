package com.testTask.testUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProcessingParameters {

    private String path = ""; //-o
    private String prefix = ""; // -p
    private boolean addNowFile = false; // -a
    private boolean extendedInfo = false; //-f
    private boolean shortInfo = false; //-s
    List<File> files = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isAddNowFile() {
        return addNowFile;
    }

    public void setAddNowFile(boolean addNowFile) {
        this.addNowFile = addNowFile;
    }

    public boolean isExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(boolean extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    public boolean isShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(boolean shortInfo) {
        this.shortInfo = shortInfo;
    }
}
