package kr.co.hdtel.core.model;

public class Carbon {

    private final String mHeadTitle;
    private final String mUsageText;
    private final String mCarbonText;

    public Carbon(String headTitle, String usageText, String carbonText){
        this.mHeadTitle = headTitle;
        this.mUsageText = usageText;
        this.mCarbonText = carbonText;
    }

    public String getCarbonText() {
        return this.mCarbonText;
    }

    public String getmUsageText() {
        return this.mUsageText;
    }

    public String getHeadText() {
        return this.mHeadTitle;
    }

}
