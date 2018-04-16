package fung.umeng;

import java.io.IOException;

public interface UPushCallback {

    void onFailure(IOException e);

    void onResponse(UPushResponse response) throws IOException;

}
