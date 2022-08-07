package api;

import com.google.gson.annotations.SerializedName;

public class Build {
    @SerializedName("automation_build")
    public BuildInfo buildInfo;

    public static class BuildInfo {
        @SerializedName("name")
        public String name;

        @SerializedName("duration")
        public String duration;

        @SerializedName("status")
        public String status;

        @SerializedName("hashed_id")
        public String hashedId;

        @SerializedName("build_tag")
        public String buildTag;
    }
}
