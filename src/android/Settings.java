package org.apache.plugin.luizheming.settings;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class CDVSettings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String value = "";
        int api = Integer.valueOf(android.os.Build.VERSION.SDK);

        if (action.equals("AUTO_TIME")) {
            if (api > 17) {
                value = android.provider.Settings.Global.getString(this.cordova.getActivity().getContentResolver(), android.provider.Settings.Global.AUTO_TIME);
            } else {
                value = android.provider.Settings.System.getString(this.cordova.getActivity().getContentResolver(), android.provider.Settings.System.AUTO_TIME);
            }
        } else if (action.equals("AUTO_TIME_ZONE")) {
            if (api > 17) {
                value = android.provider.Settings.Global.getString(this.cordova.getActivity().getContentResolver(), android.provider.Settings.Global.AUTO_TIME_ZONE);
            } else {
                value = android.provider.Settings.System.getString(this.cordova.getActivity().getContentResolver(), android.provider.Settings.System.AUTO_TIME_ZONE);
            }
        } else {
            value = "INVALID_ACTION";
        }
        
        callbackContext.success(value);

        return true;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
