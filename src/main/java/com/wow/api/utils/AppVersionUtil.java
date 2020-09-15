package com.wow.api.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppVersionUtil {


    /**
     * 두 버전 문자열을 비교 한다.
     *
     * @param v1
     * @param v2
     * @return v1 > v2 -> + 1 이상
     *         v1 = v2 -> 0
     *         v1 < v2 -> - 1 이상
     */
    public static int compare(String v1, String v2) {
        String s1 = normalisedVersion(v1);
        String s2 = normalisedVersion(v2);
        return s1.compareTo(s2);
    }

    private static String normalisedVersion(String version) {
        return normalisedVersion(version, ".", 3);
    }

    private static String normalisedVersion(String version, String sep, int maxWidth) {
        String[] split = Pattern.compile(sep, Pattern.LITERAL).split(version);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(String.format("%" + maxWidth + 's', s));
        }
        return sb.toString();
    }

    /**
     * App 버전값 체크
     * - {**}.{**}.{**} 형식 체크 및 숫자외 체크
     * - true: 유효하지 않는 형식의 버전
     * - false: 유효한 앱 버전
     */
    public static boolean isBadNumberAppVersion(String appVersion) {
        if(StringUtils.isEmpty(appVersion) || appVersion.split("\\.").length != 3){
            return true;
        }
        boolean isBadNumberAppVersion = true;
        String numberValue = appVersion.replace(".", "");
        Pattern numPattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = numPattern.matcher(numberValue);
        if (matcher.find()) {
            isBadNumberAppVersion = false;
        }
        return isBadNumberAppVersion;
    }


    public static int stringToIntAppVersion(String version){
        return Integer.parseInt(normalisedVersion(version, ".", 2).replace(" ", "0"));
    }


}
