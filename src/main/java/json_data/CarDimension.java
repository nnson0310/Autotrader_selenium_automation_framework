package json_data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarDimension {

    @SerializedName("make")
    private String make;

    @SerializedName("model")
    private String model;

    @SerializedName("year")
    private String year;

    @SerializedName("button_title")
    private String buttonTitle;

    @SerializedName("dimension_title")
    private String dimensionTitle;

    @SerializedName("dimension_results")
    private List<DimensionResults> dimensionResults;

    @Getter
    @Setter
    public static class DimensionResults {
        @SerializedName("variant")
        private String variant;

        // hxwxl: height x width x length
        @SerializedName("hxwxl")
        private String hxwxl;

        @SerializedName("kerb_weight")
        private String kerbWeight;
    }
}
