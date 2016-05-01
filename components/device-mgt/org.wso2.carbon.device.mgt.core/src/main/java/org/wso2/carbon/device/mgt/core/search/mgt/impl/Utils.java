/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.wso2.carbon.device.mgt.core.search.mgt.impl;

import org.wso2.carbon.device.mgt.common.device.details.DeviceWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    private static Map<String, String> genericColumnsMap = new HashMap<>();
    private static Map<String, String> locationColumnsMap = new HashMap<>();

    static {

        genericColumnsMap.put("deviceModel", "DEVICE_MODEL");
        genericColumnsMap.put("vendor", "VENDOR");
        genericColumnsMap.put("osVersion", "OS_VERSION");
        genericColumnsMap.put("batteryLevel", "BATTERY_LEVEL");
        genericColumnsMap.put("internalTotalMemory", "INTERNAL_TOTAL_MEMORY");
        genericColumnsMap.put("internalAvailableMemory", "INTERNAL_AVAILABLE_MEMORY");
        genericColumnsMap.put("externalTotalMemory", "EXTERNAL_TOTAL_MEMORY");
        genericColumnsMap.put("externalAvailableMemory", "EXTERNAL_AVAILABLE_MEMORY");
        genericColumnsMap.put("connectionType", "CONNECTION_TYPE");
        genericColumnsMap.put("ssid", "SSID");
        genericColumnsMap.put("cpuUsage", "CPU_USAGE");
        genericColumnsMap.put("totalRAMMemory", "TOTAL_RAM_MEMORY");
        genericColumnsMap.put("availableRAMMemory", "AVAILABLE_RAM_MEMORY");
        genericColumnsMap.put("pluggedIn", "PLUGGED_IN");


        locationColumnsMap.put("latitude", "LATITUDE");
        locationColumnsMap.put("longitude", "LONGITUDE");
        locationColumnsMap.put("street1", "STREET1");
        locationColumnsMap.put("street2", "STREET2");
        locationColumnsMap.put("city", "CITY");
        locationColumnsMap.put("state", "ZIP");
        locationColumnsMap.put("zip", "STATE");
        locationColumnsMap.put("country", "COUNTRY");

    }

    public static Map<String, String> getDeviceDetailsColumnNames() {
        return genericColumnsMap;
    }

    public static Map<String, String> getDeviceLocationColumnNames() {
        return locationColumnsMap;
    }

    public static boolean checkDeviceDetailsColumns(String str) {
        if (genericColumnsMap.containsKey(str)) {
            return true;
        }
        if (genericColumnsMap.containsValue(str)) {
            return true;
        }
        return false;
    }

    public static boolean checkDeviceLocationColumns(String str) {
        if (locationColumnsMap.containsKey(str)) {
            return true;
        }
        if (locationColumnsMap.containsValue(str)) {
            return true;
        }
        return false;
    }

    public static List<String> convertStringToList(String str) {

        List<String> stList = new ArrayList<>();
        stList.add(str);
        return stList;
    }

    public static Integer[] getArrayOfDeviceIds(List<DeviceWrapper> deviceWrappers) {

        Integer[] arr = new Integer[deviceWrappers.size()];
        int x = 0;
        for (DeviceWrapper dw : deviceWrappers) {
            arr[x] = dw.getDevice().getId();
            x++;
        }
        return arr;
    }


    public static String getDeviceIdsAsString(List<DeviceWrapper> deviceWrappers) {

        String str = "";
        for (DeviceWrapper dw : deviceWrappers) {
            str += dw.getDevice().getId() + ",";
        }
        if (deviceWrappers.isEmpty()) {
            return null;
        }
        return str.substring(0, str.length() - 1);
    }
}
