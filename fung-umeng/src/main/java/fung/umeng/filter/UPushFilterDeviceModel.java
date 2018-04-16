package fung.umeng.filter;

public class UPushFilterDeviceModel extends UPushFilterCondition {

    private String device_model;

    public String getDevice_model() {
        return device_model;
    }

    public UPushFilterDeviceModel setDevice_model(String device_model) {
        this.device_model = device_model;
        return this;
    }
}
