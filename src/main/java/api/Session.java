package api;

import com.google.gson.annotations.SerializedName;

public class Session {
    @SerializedName("automation_session")
    public SessionInfo sessionInfo;

    public static class SessionInfo {
        @SerializedName("name")
        public String name;

        @SerializedName("duration")
        public String duration;

        @SerializedName("os")
        public String os;

        @SerializedName("os_version")
        public String osVersion;

        @SerializedName("browser_version")
        public String browserVersion;

        @SerializedName("browser")
        public String browser;

        @SerializedName("created_at")
        public String createdAt;

        @SerializedName("video_url")
        public String videoUrl;
    }
}
